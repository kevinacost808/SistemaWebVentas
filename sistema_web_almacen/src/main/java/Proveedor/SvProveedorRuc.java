package Proveedor;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvProveedorRuc", urlPatterns = {"/SvProveedorRuc"})
public class SvProveedorRuc extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ruc = request.getParameter("ruc");
        String enlace = "https://dniruc.apisperu.com/api/v1/ruc/"+ruc
                        + "?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9."
                        + "eyJlbWFpbCI6ImtldmluYWNvc3Q4MDhAZ21haWwuY29tIn0."
                        + "HRNB-1DSI-_yR2LKy7WuyWmdvJiBYa0hgVrRMdHkaE0";
        try{
            URL url = new URL(enlace);
            URLConnection urlRequest = url.openConnection();
            urlRequest.connect();

            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream)urlRequest.getContent()));
            
            if(root.isJsonObject()){
                JsonObject rootObj = root.getAsJsonObject();

                String razonSocial = rootObj.get("razonSocial").getAsString();
                
                List<String> listaProveedorRucEditar = new ArrayList();
                listaProveedorRucEditar.add(ruc);
                listaProveedorRucEditar.add(razonSocial);
                
                HttpSession sesion = request.getSession();
                sesion.setAttribute("listaProveedorRucEditar",listaProveedorRucEditar);
                
                response.sendRedirect("almacen/proveedorFrmE.jsp");
                
                listaProveedorRucEditar = null;
            }
            
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ruc = request.getParameter("ruc");
        String enlace = "https://dniruc.apisperu.com/api/v1/ruc/"+ruc
                        + "?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9."
                        + "eyJlbWFpbCI6ImtldmluYWNvc3Q4MDhAZ21haWwuY29tIn0."
                        + "HRNB-1DSI-_yR2LKy7WuyWmdvJiBYa0hgVrRMdHkaE0";
        try{
            URL url = new URL(enlace);
            URLConnection urlRequest = url.openConnection();
            urlRequest.connect();

            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream)urlRequest.getContent()));
            
            if(root.isJsonObject()){
                JsonObject rootObj = root.getAsJsonObject();

                String razonSocial = rootObj.get("razonSocial").getAsString();
                
                List<String> listaProveedorRuc = new ArrayList();
                listaProveedorRuc.add(ruc);
                listaProveedorRuc.add(razonSocial);
                
                HttpSession sesion = request.getSession();
                sesion.setAttribute("listaProveedorRuc",listaProveedorRuc);
                
                response.sendRedirect("almacen/proveedorFrm.jsp");
                
                listaProveedorRuc = null;
            }
            
            
            
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
