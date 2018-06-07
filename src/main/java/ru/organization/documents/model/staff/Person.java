package ru.organization.documents.model.staff;


import javax.xml.bind.annotation.*;



/**
 * сотрудник.
 */
@XmlType(name="")
public class Person extends Staff {

    /**
     * фамилия.
     */
    private String surname;

    /**
     * имя.
     */
    private String firstName;
    /**
     * отчество.
     */
    private String patronymic;
    /**
     * должность.
     */
    private String position;


    public Person() {
    }

    /**
     * полное имя.
     * @return полное имя
     */
    public String getFullName() {
        return this.surname + " " + this.firstName + " " + this.patronymic;
    }

    public String getSurname() {
        return surname;
    }
    @XmlElement(name = "surname")
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }
    @XmlElement(name = "firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }
    @XmlElement(name = "patronymic")
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPosition() {
        return position;
    }
    @XmlElement(name = "position")
    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (surname != null ? !surname.equals(person.surname) : person.surname != null) return false;
        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
        if (patronymic != null ? !patronymic.equals(person.patronymic) : person.patronymic != null) return false;
        return position != null ? position.equals(person.position) : person.position == null;
    }

    @Override
    public int hashCode() {
        int result = surname != null ? surname.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }
}
