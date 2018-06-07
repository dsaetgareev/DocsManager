package ru.organization.documents.app;

import ru.organization.documents.rest.classes.RestEmployeesService;

public class Test {

    public static void main(String[] args) {
        System.out.println(new RestEmployeesService().getAllPersons());
    }
}
