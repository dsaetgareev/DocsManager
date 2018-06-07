package ru.organization.documents.converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ru.organization.documents.model.docs.Document;
import ru.organization.documents.model.staff.Person;

import java.util.List;


public class Converter {

    public String converterToJson(List<Document> documents) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(documents);
        System.out.println(json);
        return json;
    }
}
