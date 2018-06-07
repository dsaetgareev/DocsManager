package ru.organization.documents.generation;

import ru.organization.documents.model.staff.Person;
import ru.organization.documents.service.containers.PersonsContainer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * class generation of person from xml.
 */
public class PersonGenerator {

    /**
     * get persons list from xml.
     * @param pathXml - path to xml folder
     * @return persons list
     */
    public static List<Person> getPersonsFromXml(String pathXml) {
        List<Person> authors = new ArrayList<Person>();

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(PersonsContainer.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            File file = new File("src\\main\\resources\\jaxbXML\\persons\\" + pathXml);

            PersonsContainer authors1 = (PersonsContainer) unmarshaller.unmarshal(file);

            authors = authors1.getPersons();

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return authors;
    }
}
