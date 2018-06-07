package ru.organization.documents.generation;

import ru.organization.documents.model.staff.Department;
import ru.organization.documents.service.containers.DepartmentContainer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * class generating a department from xml
 */
public class DepartmentGenerator {

    /**
     * get a department from xml.
     * @param pathXml - path to a xml folder
     * @return department
     */
    public List<Department> getDepartmentsFromXml(String pathXml) {
        List<Department> departments = new ArrayList<Department>();

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DepartmentContainer.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            File file = new File("src\\main\\resources\\jaxbXML\\departments\\" + pathXml);
            DepartmentContainer departmentContainer = (DepartmentContainer) unmarshaller.unmarshal(file);
            departments = departmentContainer.getDepartments();
            System.out.println("Create departments: " + departments.size());
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return departments;
    }
}
