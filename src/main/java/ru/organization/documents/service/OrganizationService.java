package ru.organization.documents.service;

import ru.organization.documents.generation.OrganizationGenerator;
import ru.organization.documents.model.staff.Department;
import ru.organization.documents.model.staff.Organization;

/**
 * сервис для организации.
 */
public class OrganizationService {

    /**
     * генератор организации.
     */
    private OrganizationGenerator generator = new OrganizationGenerator();

    /**
     * получение организации из xml файла.
     * @param pathXml - путь к xml файлу
     * @return организация.
     */
    public Organization getOrganization(String pathXml) {
        return this.generator.getOrganizationFromXml(pathXml);
    }

    /**
     * устанавливает директора для организации.
     * @param organization - организация
     */
    public void setDirector(Organization organization) {
        for (Department department : organization.getDepartments()) {
            if (department.getShortName().equals("AO")) {
                organization.setDirector(department.getDirector());
            }
        }
    }

    /**
     * представление для организации.
     * @param organization - организация
     */
    public void showOrganization(Organization organization) {
        System.out.println("Здравствуйте, вы находитесь на странице " + organization.getShortName());
        System.out.println("======================================================================");

        System.out.println(organization.toString());
        System.out.println("\n Департаменты:");
        int count = 1;
        for (Department department : organization.getDepartments()) {
            System.out.println(count++ + ". " + department.getFullName());
        }
    }

    /**
     * получение департамента по id.
     * @param organization - организация
     * @param id - id
     * @return департамент
     */
    public Department getDepartmentById(Organization organization, int id) {
        return organization.getDepartments().get(id);
    }
}
