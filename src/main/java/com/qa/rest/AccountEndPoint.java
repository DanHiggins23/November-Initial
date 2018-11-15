package com.qa.rest;

import com.qa.business.AccountService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/account")
public class AccountEndPoint {
    @Inject
    private AccountService service;

    @GET
    @Path("/json")
    public String getAllAccounts (String account) {
        return service.getAllAccounts();
    }

    @POST
    @Path("/json")
    @Produces({"application/json"})
    public String createUser (String jsonString) {
        return service.createUser(jsonString);
    }
}
