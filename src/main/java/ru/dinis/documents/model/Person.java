package ru.dinis.documents.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {

    private String name;

    private List<Document> documents = new ArrayList<Document>();

    public Person(String name) {
        this.name = name;
    }

    public void showDocuments() {
        Collections.sort(this.documents);
        if (documents.size() != 0) {
            System.out.println(" * " + this.name);
            for (Document document : this.documents) {
                System.out.println("    -- " + document.toString());
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
}
