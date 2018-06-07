package ru.organization.documents.generation;

import ru.organization.documents.model.staff.Department;
import ru.organization.documents.service.containers.DepartmentContainer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * класс генерирует департамент из xml файла.
 */
public class DepartmentGenerator {

    /**
     * получение департамента из xml.
     * @param pathXml - путь к xml
     * @return департамент
     */
    public List<Department> getDepartmentsFromXml(String pathXml) {
        List<Department> departments = new ArrayList<Department>();

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DepartmentContainer.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            InputStream is = this.getClass().getClassLoader().getResourceAsStream("jaxbXML" + File.separator + "departments"+ File.separator + pathXml);
            DepartmentContainer departmentContainer = (DepartmentContainer) unmarshaller.unmarshal(is);
            departments = departmentContainer.getDepartments();
            System.out.println("Create departments: " + departments.size());
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return departments;
    }
}
