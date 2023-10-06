package Sucursal;

import Empresa.Empresa;
import Excepcion.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author kevin
 */
public class SucursalJpaController implements Serializable {

    public SucursalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public SucursalJpaController() {
        emf = Persistence.createEntityManagerFactory("conexionPU");
    }
    
    public void create(Sucursal sucursal) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empresa empresa = sucursal.getEmpresa();
            if (empresa != null) {
                empresa = em.getReference(empresa.getClass(), empresa.getIdEmpresa());
                sucursal.setEmpresa(empresa);
            }
            em.persist(sucursal);
            if (empresa != null) {
                empresa.getSucursal().add(sucursal);
                empresa = em.merge(empresa);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Sucursal sucursal) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sucursal persistentSucursal = em.find(Sucursal.class, sucursal.getIdSucursal());
            Empresa empresaOld = persistentSucursal.getEmpresa();
            Empresa empresaNew = sucursal.getEmpresa();
            if (empresaNew != null) {
                empresaNew = em.getReference(empresaNew.getClass(), empresaNew.getIdEmpresa());
                sucursal.setEmpresa(empresaNew);
            }
            sucursal = em.merge(sucursal);
            if (empresaOld != null && !empresaOld.equals(empresaNew)) {
                empresaOld.getSucursal().remove(sucursal);
                empresaOld = em.merge(empresaOld);
            }
            if (empresaNew != null && !empresaNew.equals(empresaOld)) {
                empresaNew.getSucursal().add(sucursal);
                empresaNew = em.merge(empresaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = sucursal.getIdSucursal();
                if (findSucursal(id) == null) {
                    throw new NonexistentEntityException("The sucursal with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sucursal sucursal;
            try {
                sucursal = em.getReference(Sucursal.class, id);
                sucursal.getIdSucursal();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sucursal with id " + id + " no longer exists.", enfe);
            }
            Empresa empresa = sucursal.getEmpresa();
            if (empresa != null) {
                empresa.getSucursal().remove(sucursal);
                empresa = em.merge(empresa);
            }
            em.remove(sucursal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Sucursal> findSucursalEntities() {
        return findSucursalEntities(true, -1, -1);
    }

    public List<Sucursal> findSucursalEntities(int maxResults, int firstResult) {
        return findSucursalEntities(false, maxResults, firstResult);
    }

    private List<Sucursal> findSucursalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Sucursal.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Sucursal findSucursal(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Sucursal.class, id);
        } finally {
            em.close();
        }
    }

    public int getSucursalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Sucursal> rt = cq.from(Sucursal.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
