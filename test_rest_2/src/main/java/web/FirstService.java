package web;

import Exceptions.TestException;
import dao.PoolConnectionBuilder;
import dao.TestPOJO;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/check")
@Singleton
public class FirstService
{
    private TestPOJO pojo;

    @PostConstruct
    public void init() {
        pojo = new TestPOJO();
        pojo.setId(1);
        pojo.setName("John");
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TestPOJO checPOJO(TestPOJO pojo) throws TestException {
        return pojo;
    }
}