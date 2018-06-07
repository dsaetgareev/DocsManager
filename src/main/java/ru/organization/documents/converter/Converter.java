package ru.organization.documents.converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ru.organization.documents.model.docs.Document;

import java.util.List;

/**
 * конвертация в json объект.
 */
public class Converter {

    /**
     * конвертация в json объект.
     */
    public String converterToJson(List<Document> documents) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(documents);
        System.out.println(json);
        return json;
    }
}
