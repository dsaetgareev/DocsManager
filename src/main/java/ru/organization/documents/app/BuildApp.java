package ru.organization.documents.app;

import ru.organization.documents.generation.PersonGenerator;
import ru.organization.documents.model.docs.Document;
import ru.organization.documents.model.staff.Department;
import ru.organization.documents.model.staff.Organization;

import ru.organization.documents.service.DepartmentService;
import ru.organization.documents.service.OrganizationService;

import java.util.List;

/**
 * класс создает организационную структуру.
 */
public class BuildApp {

    /**
     * текущая организация.
     */
    private Organization organization;

    /**
     * сервис для организации.
     */
    private OrganizationService organizationService = new OrganizationService();

    /**
     * сервис для департамента.
     */
    private DepartmentService departmentService = new DepartmentService();

    /**
     * генератор для persons.
     */
    private PersonGenerator personGenerator = new PersonGenerator();

    /**
     * создание структуры организации.
     */
    public void buildStructure() {
        List<Department> departments = this.departmentService
                .getDepartmentsAndFillPersonsForAllDepartments("departments.xml");
        this.organization = this.organizationService.getOrganization("organization.xml");
        this.organization.setDepartments(departments);
        this.organizationService.setDirector(this.organization);

    }

    /**
     * представление welcome страницы.
     */
    public void showWelcome() {
        this.organizationService.showOrganization(this.organization);
    }

    /**
     * представление страницы департамента.
     * @param department - представляемый департамент
     */
    public void showDepartment(Department department, List<Document> documents) {
        this.departmentService.showDepartment(department, documents);
    }

    /**
     * записывает документ в файл.
     * @param department - департамент
     * @param documents - записываемые документы
     */
    public void writeDocuments(Department department, List<Document> documents) {
        this.departmentService.writeDocuments(department, documents);
    }

    /**
     * получение департамента по id.
     * @param index - индекс департамента
     * @return департамент
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
