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
 * класс генерирует сотрудника из xml.
 */
public class PersonGenerator {

    /**
     * получение сотрудника из xml.
     * @param pathXml - путь к xml файлу
     * @return лист сотрудников
     */
    public static List<Person> getPersonsFromXml(String pathXml) {
        List<Person> authors = new ArrayList<Person>();

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(PersonsContainer.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            File file = new File("src" + File.separator + "main" + File.separator
                    + "resources" + File.separator + "jaxbXML" + File.separator + "persons"+ File.separator + pathXml);

            PersonsContainer authors1 = (PersonsContainer) unmarshaller.unmarshal(file);

            authors = authors1.getPersons();

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return authors;
    }
}
