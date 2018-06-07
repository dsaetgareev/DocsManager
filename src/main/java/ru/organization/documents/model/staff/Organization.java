package ru.organization.documents.model.staff;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "organization")
@XmlAccessorType(XmlAccessType.FIELD)
public class Organization extends Staff {

    @XmlElement(name = "fullName")
    private String fullName;
    @XmlElement(name = "shortName")
    private String shortName;
    @XmlElement(name = "director")
    private Person director;
    @XmlElement(name = "phones")
    private String phones;
    @XmlElement(name = "departments")
    private List<Department> departments;

    public Organization() {
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "   " + this.fullName
                + "\n   " + this.shortName
                + "\n   Директор: " + this.director.getFullName()
                + "\n   тел.: " + this.phones;
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

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
