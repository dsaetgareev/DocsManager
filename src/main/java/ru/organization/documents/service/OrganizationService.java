package ru.organization.documents.service;

import ru.organization.documents.generation.OrganizationGenerator;
import ru.organization.documents.model.staff.Department;
import ru.organization.documents.model.staff.Organization;

/**
 * service for organizations.
 */
public class OrganizationService {

    /**
     * generator for organization.
     */
    private OrganizationGenerator generator = new OrganizationGenerator();

    /**
     * gets organization from a xml file.
     * @param pathXml - path to a xml file
     * @return a organization.
     */
    public Organization getOrganization(String pathXml) {
        return this.generator.getOrganizationFromXml(pathXml);
    }

    /**
     * sets a director for a organization.
     * @param organization - current organization
     */
    public void setDirector(Organization organization) {
        for (Department department : organization.getDepartments()) {
            if (department.getShortName().equals("AO")) {
                organization.setDirector(department.getDirector());
            }
        }
    }

    /**
     * shows organization.
     * @param organization - current organization
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
     * gets a department by id.
     * @param organization - current organization
     * @param id - id
     * @return a department
     */
    public Department getDepartmentById(Organization organization, int id) {
        return organization.getDepartments().get(id);
    }
}
