package ru.organization.documents.service.containers;

import ru.organization.documents.model.staff.Department;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * a container for departments.
 */
@XmlRootElement(name = "departments")
@XmlAccessorType(XmlAccessType.FIELD)
public class DepartmentContainer {

    /**
     * departments.
     */
    @XmlElement(name = "department")
    private List<Department> departments;

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
