package ru.organization.documents.generation;

import ru.organization.documents.model.staff.Organization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * класс генерирует организацию.
 */
public class OrganizationGenerator {

    /**
     * получение организации из xml.
     * @param pathXml - путь к xml файлу
     * @return организация
     */
    public Organization getOrganizationFromXml(String pathXml) {
        Organization organization = null;

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Organization.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            File file = new File("src" + File.separator + "main" + File.separator
                    + "resources" + File.separator + "jaxbXML" + File.separator + "organization"+ File.separator + pathXml);
            organization = (Organization) unmarshaller.unmarshal(file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return organization;
    }
}
