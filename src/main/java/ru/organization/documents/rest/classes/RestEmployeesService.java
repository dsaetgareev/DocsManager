package ru.organization.documents.rest.classes;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.organization.documents.generation.PersonGenerator;
import ru.organization.documents.model.staff.Person;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path(value = "/employees")
public class RestEmployeesService {

    @GET
    @Produces("application/json")
    @Path(value = "/all")
    public String getAllPersons() {
        List<Person> personList = new PersonGenerator().getPersonsFromXml("personsForAO.xml");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(personList);
        System.out.println(json);
        return json;
    }
}
