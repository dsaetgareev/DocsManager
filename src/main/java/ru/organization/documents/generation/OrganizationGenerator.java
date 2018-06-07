package ru.organization.documents.generation;

import ru.organization.documents.model.staff.Organization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * class generating a organization.
 */
public class OrganizationGenerator {

    /**
     * get a organization from xml.
     * @param pathXml - path to a xml folder
     * @return organization
     */
    public Organization getOrganizationFromXml(String pathXml) {
        Organization organization = null;

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Organization.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            File file = new File("src\\main\\resources\\jaxbXML\\organization\\" + pathXml);
            organization = (Organization) unmarshaller.unmarshal(file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return organization;
    }
}
