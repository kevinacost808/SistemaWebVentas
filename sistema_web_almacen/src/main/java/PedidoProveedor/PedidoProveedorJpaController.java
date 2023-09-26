package PedidoProveedor;

import Excepcion.NonexistentEntityException;
import Proveedor.Proveedor;
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
public class PedidoProveedorJpaController implements Serializable {

    public PedidoProveedorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public PedidoProveedorJpaController() {
        emf = Persistence.createEntityManagerFactory("conexionPU");
    }
    
    public void create(PedidoProveedor pedidoProveedor) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proveedor proveedor = pedidoProveedor.getProveedor();
            if (proveedor != null) {
                proveedor = em.getReference(proveedor.getClass(), proveedor.getIdProveedor());
                pedidoProveedor.setProveedor(proveedor);
            }
            em.persist(pedidoProveedor);
            if (proveedor != null) {
                proveedor.getPedidosProveedor().add(pedidoProveedor);
                proveedor = em.merge(proveedor);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PedidoProveedor pedidoProveedor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PedidoProveedor persistentPedidoProveedor = em.find(PedidoProveedor.class, pedidoProveedor.getIdPedidoProveedor());
            Proveedor proveedorOld = persistentPedidoProveedor.getProveedor();
            Proveedor proveedorNew = pedidoProveedor.getProveedor();
            if (proveedorNew != null) {
                proveedorNew = em.getReference(proveedorNew.getClass(), proveedorNew.getIdProveedor());
                pedidoProveedor.setProveedor(proveedorNew);
            }
            pedidoProveedor = em.merge(pedidoProveedor);
            if (proveedorOld != null && !proveedorOld.equals(proveedorNew)) {
                proveedorOld.getPedidosProveedor().remove(pedidoProveedor);
                proveedorOld = em.merge(proveedorOld);
            }
            if (proveedorNew != null && !proveedorNew.equals(proveedorOld)) {
                proveedorNew.getPedidosProveedor().add(pedidoProveedor);
                proveedorNew = em.merge(proveedorNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = pedidoProveedor.getIdPedidoProveedor();
                if (findPedidoProveedor(id) == null) {
                    throw new NonexistentEntityException("The pedidoProveedor with id " + id + " no longer exists.");
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
            PedidoProveedor pedidoProveedor;
            try {
                pedidoProveedor = em.getReference(PedidoProveedor.class, id);
                pedidoProveedor.getIdPedidoProveedor();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pedidoProveedor with id " + id + " no longer exists.", enfe);
            }
            Proveedor proveedor = pedidoProveedor.getProveedor();
            if (proveedor != null) {
                proveedor.getPedidosProveedor().remove(pedidoProveedor);
                proveedor = em.merge(proveedor);
            }
            em.remove(pedidoProveedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PedidoProveedor> findPedidoProveedorEntities() {
        return findPedidoProveedorEntities(true, -1, -1);
    }

    public List<PedidoProveedor> findPedidoProveedorEntities(int maxResults, int firstResult) {
        return findPedidoProveedorEntities(false, maxResults, firstResult);
    }

    private List<PedidoProveedor> findPedidoProveedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PedidoProveedor.class));
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

    public PedidoProveedor findPedidoProveedor(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PedidoProveedor.class, id);
        } finally {
            em.close();
        }
    }

    public int getPedidoProveedorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PedidoProveedor> rt = cq.from(PedidoProveedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
