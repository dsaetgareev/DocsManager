package ru.organization.documents.service;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import ru.organization.documents.converter.Converter;
import ru.organization.documents.model.docs.Document;
import ru.organization.documents.model.staff.Person;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * service for persons.
 */
public class PersonService {

    /**
     * a person
     */
    private Person person;

    public PersonService() {
    }

    public PersonService(Person person) {
        this.person = person;
    }

    /**
     * shows documents of a current person.
     */
    public void showDocuments(List<Document> documentList) {
        List<Document> documents = DocumentService.filtersDocumentsByPerson(documentList, this.person);
        Collections.sort(documents);

        System.out.println(" * " + this.getFullName() + ": " + person.getPosition());
        for (Document document : documents) {
            System.out.println("    -- " + document.toString());
        }

    }

    public void writeDocuments(List<Document> documentList) {
        List<Document> documents = DocumentService.filtersDocumentsByPerson(documentList, this.person);
        String text = new Converter().converterToJson(documents);
        if (documents.size() != 0) {
            FileOutputStream fos = null;
            BufferedOutputStream bos = null;
            try {
                fos = new FileOutputStream("src\\main\\resources\\outputFiles\\"
                        + this.person.getFullName() + ".txt");
                bos = new BufferedOutputStream(fos);
                byte[] buffer = text.getBytes();
                bos.write(buffer, 0, buffer.length);

            } catch (FileNotFoundException fnfe) {
                fnfe.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    bos.flush();
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    /**
     * gets a full name of a current person.
     * @return a full name
     */
    public String getFullName() {
        return this.person.getSurname() + " " + this.person.getFirstName() + " " + this.person.getPatronymic();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
