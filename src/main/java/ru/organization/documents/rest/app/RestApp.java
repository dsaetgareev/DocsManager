package ru.organization.documents.rest.app;

import ru.organization.documents.rest.classes.RestEmployeesService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("ecm")
public class RestApp extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();

        classes.add(RestEmployeesService.class);

        return classes;
    }
}
