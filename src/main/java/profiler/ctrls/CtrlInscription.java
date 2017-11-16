/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profiler.ctrls;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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
@Path("inscription")
public class CtrlInscription {

    @Context
    private UriInfo context;

    private WrkDB wrkDB;

    /**
     * Creates a new instance of CtrlREST
     */
    public CtrlInscription() {
        wrkDB = new WrkDB();
    }

    @GET
    @Path("edit")
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
    public String getContacts(@QueryParam("id") Integer id) throws JSONException, IOException {
        HashMap<String, Object> map = new HashMap<>();

        ObjectMapper oMapper = new ObjectMapper();

        if (id != null) {

            List<Compte> list = wrkDB.getContacts(id);

            map.put("comptes", list);
        }
        
        return oMapper.writeValueAsString(map);
    }

}
