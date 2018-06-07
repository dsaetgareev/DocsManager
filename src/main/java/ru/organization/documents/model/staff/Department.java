package ru.organization.documents.model.staff;

import java.util.List;

/**
 * Department.
 */
public class Department extends Staff {
    /**
     * full name.
     */
    private String fullName;
    /**
     * short name.
     */
    private String shortName;
    /**
     * director.
     */
    private Person director;
    /**
     * phones.
     */
    private String phones;

    /**
     * persons
     */
    private List<Person> persons;

    public Department() {
    }

    @Override
    public String toString() {
        return "   " + this.fullName
                + "\n   " + this.shortName
                + "\n   Директор: " + this.director.getFullName()
                + "\n   тел.: " + this.phones;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Person getDirector() {
        return director;
    }

    public void setDirector(Person director) {
        this.director = director;
    }

    public String getPhones() {
        return phones;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
