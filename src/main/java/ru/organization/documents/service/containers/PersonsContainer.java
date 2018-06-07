package ru.organization.documents.service.containers;

import ru.organization.documents.model.staff.Person;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * a container for persons.
 */
@XmlRootElement(name = "persons")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonsContainer {

    /*
     * Список сотрудников.
     */
    @XmlElement(name = "person")
    private List<Person> persons;

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
