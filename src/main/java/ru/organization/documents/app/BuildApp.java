package ru.organization.documents.app;

import ru.organization.documents.generation.PersonGenerator;
import ru.organization.documents.model.docs.Document;
import ru.organization.documents.model.staff.Department;
import ru.organization.documents.model.staff.Organization;

import ru.organization.documents.service.DepartmentService;
import ru.organization.documents.service.OrganizationService;

import java.util.List;

/**
 * builds a organization structure.
 */
public class BuildApp {

    /**
     * a current organization.
     */
    private Organization organization;

    /**
     * a service for organization.
     */
    private OrganizationService organizationService = new OrganizationService();

    /**
     * a service for departments.
     */
    private DepartmentService departmentService = new DepartmentService();

    /**
     * a generator for persons.
     */
    private PersonGenerator personGenerator = new PersonGenerator();

    /**
     *builds a organization structure.
     */
    public void buildStructure() {
        List<Department> departments = this.departmentService
                .getDepartmentsAndFillPersonsForAllDepartments("departments.xml");
        this.organization = this.organizationService.getOrganization("organization.xml");
        this.organization.setDepartments(departments);
        this.organizationService.setDirector(this.organization);

    }

    /**
     * shows a welcome page.
     */
    public void showWelcome() {
        this.organizationService.showOrganization(this.organization);
    }

    /**
     * shows departments page.
     * @param department - a current department
     */
    public void showDepartment(Department department, List<Document> documents) {
        this.departmentService.showDepartment(department, documents);
    }

    public void writeDocuments(Department department, List<Document> documents) {
        this.departmentService.writeDocuments(department, documents);
    }

    /**
     * gets a department by id.
     * @param index - index of a department
     * @return a department
     */
    public Department getDepartmentById(int index) {
        return this.organizationService.getDepartmentById(this.organization, index);
    }


    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public OrganizationService getOrganizationService() {
        return organizationService;
    }

    public void setOrganizationService(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    public DepartmentService getDepartmentService() {
        return departmentService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public PersonGenerator getPersonGenerator() {
        return personGenerator;
    }

    public void setPersonGenerator(PersonGenerator personGenerator) {
        this.personGenerator = personGenerator;
    }
}
