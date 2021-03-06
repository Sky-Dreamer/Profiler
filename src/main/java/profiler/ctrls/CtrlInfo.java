/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profiler.ctrls;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;
import profiler.beans.Compte;
import profiler.wrks.WrkDB;

/**
 * REST Web Service
 *
 * @author skyid
 */
@Path("info")
public class CtrlInfo {

    @Context
    private UriInfo context;

    @Context
    private HttpServletRequest req;
    
    private WrkDB wrkDB;

    /**
     * Creates a new instance of CtrlREST
     */
    public CtrlInfo() {
        wrkDB = new WrkDB();
    }

    @GET
    @Path("compte")
    @Produces(MediaType.APPLICATION_JSON)
    public Compte getCompte(@QueryParam("id") Integer id) throws JSONException, IOException {
        Compte result = null;
        
        if (id != null) {
            result = wrkDB.getCompte(id);
        }
        
        return result;
    }

    @GET
    @Path("contacts")
    @Produces(MediaType.APPLICATION_JSON)
    public String getContacts() throws JSONException, IOException {
        HashMap<String, Object> map = new HashMap<>();

        ObjectMapper oMapper = new ObjectMapper();

        Compte compte = (Compte)req.getSession().getAttribute("compte");
        
        if (compte != null) {
            List<Compte> list = wrkDB.getContacts(compte.getPkCompte());

            map.put("comptes", list);
  
        }
        
        return oMapper.writeValueAsString(map);
    }

}
