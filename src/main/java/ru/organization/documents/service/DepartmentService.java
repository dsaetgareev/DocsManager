package ru.organization.documents.service;

import ru.organization.documents.generation.DepartmentGenerator;
import ru.organization.documents.generation.PersonGenerator;
import ru.organization.documents.model.docs.Document;
import ru.organization.documents.model.staff.Department;
import ru.organization.documents.model.staff.Person;

import java.util.List;

/**
 * сервис для департамента.
 */
public class DepartmentService {
    /**
     * генератор департаментов.
     */
    private DepartmentGenerator generator = new DepartmentGenerator();

    /**
     * сервис для сотрудников.
     */
    private PersonService personService = new PersonService();

    /**
     * получение департаментов из xml файлв.
     *
     * @param pathXml - путь к xml файлу
     * @return спсок депатаментов.
     */
    public List<Department> getDepartments(String pathXml) {
        return this.generator.getDepartmentsFromXml(pathXml);
    }

    /**
     * заполняет сотрудников для департамента.
     *
     * @param department - департамент для сотрудников
     */
    public void fillPersonsForDepartment(Department department) {
        List<Person> personList = PersonGenerator
                .getPersonsFromXml("personsFor" + department.getShortName() + ".xml");
        department.setPersons(personList);
    }

    /**
     * метод получает департаменты из xml файла и заполняет его сотрудниками.
     *
     * @param pathXml - путь к xml файлу
     * @return список департаментов
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
     * назначает директора.
     *
     * @param department - департамент
     */
    public void setDirector(Department department) {
        for (Person person : department.getPersons()) {
            if (person.getPosition().equals("director")) {
                department.setDirector(person);
            }
        }
    }

    /**
     * представление для департамента.
     *
     * @param department - департамент
     */
    public void showDepartment(Department department, List<Document> documents) {
        System.out.println("\n" + department.toString());
        System.out.println("\n Список сотрудников:");
        for (Person person : department.getPersons()) {
            this.personService.setPerson(person);
            this.personService.showDocuments(documents);
        }
    }

    /**
     * записывает документы в файлю
     * @param department - департамент
     * @param documents - записываемые документы
     */
    public void writeDocuments(Department department, List<Document> documents) {
        for (Person person : department.getPersons()) {
            this.personService.setPerson(person);
            this.personService.writeDocuments(documents);
        }
    }
}
