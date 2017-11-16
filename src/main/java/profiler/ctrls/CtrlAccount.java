/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profiler.ctrls;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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

    @Context
    private HttpServletRequest req;

    private WrkDB wrkDB;

    /**
     * Creates a new instance of CtrlREST
     */
    public CtrlAccount() {
        wrkDB = new WrkDB();
    }

    @POST
    @Path("createaccount")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createAccount(Compte compte) throws JSONException, IOException {
        ObjectMapper oMapper = new ObjectMapper();

        Map<String, Object> map = new HashMap<>();
        boolean result = false;

        result = wrkDB.createUser(compte);
        map.put("success", result);

        return oMapper.writeValueAsString(map);
    }

    @POST
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    public String login(@QueryParam("email") String email, @QueryParam("password") String password) throws IOException {
        ObjectMapper oMapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<>();

        if (req.getSession().getAttribute("compte") == null) {

            boolean loginValid = wrkDB.verifyLoginInfo(email, password);

            if (loginValid) {
                HttpSession session = req.getSession(true);
                Compte compte = wrkDB.getCompte(email);
                session.setAttribute("compte", compte);
                map.put("success", true);
                map.put("message", "Connecté");
                map.put("compte", compte);
            } else {
                map.put("success", false);
                map.put("message", "Login invalide");
            }
        } else {
            map.put("success", false);
            map.put("message", "Déjà connecté");
        }

        return oMapper.writeValueAsString(map);
    }

    @GET
    @Path("logout")
    @Produces(MediaType.APPLICATION_JSON)
    public String logout() throws JSONException, IOException {
        ObjectMapper oMapper = new ObjectMapper();

        Map<String, Object> map = new HashMap<>();
        boolean result = false;

        if (req.getSession().getAttribute("compte") != null) {
            req.getSession().invalidate();
            result = true;
        }

        map.put("success", result);

        return oMapper.writeValueAsString(map);
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
