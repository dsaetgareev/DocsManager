package ru.organization.documents.service;

import ru.organization.documents.generation.DepartmentGenerator;
import ru.organization.documents.generation.PersonGenerator;
import ru.organization.documents.model.docs.Document;
import ru.organization.documents.model.staff.Department;
import ru.organization.documents.model.staff.Person;

import java.util.List;

/**
 * service for a department.
 */
public class DepartmentService {
    /**
     * generator for department.
     */
    private DepartmentGenerator generator = new DepartmentGenerator();

    /**
     * service for a person.
     */
    private PersonService personService = new PersonService();

    /**
     * gets departments from a xml file.
     *
     * @param pathXml - path to a xml file
     * @return list departments.
     */
    public List<Department> getDepartments(String pathXml) {
        return this.generator.getDepartmentsFromXml(pathXml);
    }

    /**
     * fills persons for a department.
     *
     * @param department - current department
     */
    public void fillPersonsForDepartment(Department department) {
        List<Person> personList = PersonGenerator
                .getPersonsFromXml("personsFor" + department.getShortName() + ".xml");
        department.setPersons(personList);
    }

    /**
     * method gets department from a xml file and fills persons for all departments.
     *
     * @param pathXml - path to a xml file
     * @return departments list
     */
    public List<Department> getDepartmentsAndFillPersonsForAllDepartments(String pathXml) {
        List<Department> departments = this.getDepartments(pathXml);
        for (Department department : departments) {
            this.fillPersonsForDepartment(department);
            this.setDirector(department);
        }
        return departments;
    }

    /**
     * sets director.
     *
     * @param department - department
     */
    public void setDirector(Department department) {
        for (Person person : department.getPersons()) {
            if (person.getPosition().equals("director")) {
                department.setDirector(person);
            }
        }
    }

    /**
     * show department.
     *
     * @param department - department
     */
    public void showDepartment(Department department, List<Document> documents) {
        System.out.println("\n" + department.toString());
        System.out.println("\n Список сотрудников:");
        for (Person person : department.getPersons()) {
            this.personService.setPerson(person);
            this.personService.showDocuments(documents);
        }
    }

    public void writeDocuments(Department department, List<Document> documents) {
        for (Person person : department.getPersons()) {
            this.personService.setPerson(person);
            this.personService.writeDocuments(documents);
        }
    }
}
