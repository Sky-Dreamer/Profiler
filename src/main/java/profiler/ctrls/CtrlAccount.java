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
@Path("account")
public class CtrlAccount {

    @Context
    private UriInfo context;

    private WrkDB wrkDB;

    /**
     * Creates a new instance of CtrlREST
     */
    public CtrlAccount() {
        wrkDB = new WrkDB();
    }

    @GET
    @Path("addfriend")
    @Produces(MediaType.APPLICATION_JSON)
    public String addFriend(@QueryParam("frienderID") Integer frienderID, @QueryParam("friendedID") Integer friendedID) throws JSONException, IOException {
        ObjectMapper oMapper = new ObjectMapper();

        Map<String, Object> map = new HashMap<>();
        boolean result = false;
        
        if (frienderID != null && friendedID != null) {
            result = wrkDB.addFriend(frienderID, friendedID);
            map.put("success", result);
        }

        return oMapper.writeValueAsString(map);
    }

}
