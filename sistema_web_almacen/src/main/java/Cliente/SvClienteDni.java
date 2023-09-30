package Cliente;

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

/**
 *
 * @author kevin
 */
@WebServlet(name = "SvClienteDni", urlPatterns = {"/SvClienteDni"})
public class SvClienteDni extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dni = request.getParameter("dni");
        String enlace = "https://dniruc.apisperu.com/api/v1/dni/"+dni
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

                String apellidoPaterno = rootObj.get("apellidoPaterno").getAsString();
                String apellidoMaterno = rootObj.get("apellidoMaterno").getAsString();

                String nombre = rootObj.get("nombres").getAsString();
                String apellido = apellidoPaterno+" "+apellidoMaterno;
                
                List<String> listaClienteDni = new ArrayList();
                listaClienteDni.add(dni);
                listaClienteDni.add(nombre);
                listaClienteDni.add(apellido);
                
                HttpSession sesion = request.getSession();
                sesion.setAttribute("listaClienteDni",listaClienteDni);
                
                response.sendRedirect("vendedor/clienteFrm.jsp");
            }
            
            
            
        }catch(Exception ex){
            System.out.println(ex);
        }
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
