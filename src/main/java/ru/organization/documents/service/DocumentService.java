package ru.organization.documents.service;

import ru.organization.documents.model.docs.Document;
import ru.organization.documents.model.staff.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * сервис для документовю
 */
public class DocumentService {

    /**
     * фильтрует документы для сотрудника.
     * @param documents - документы
     * @param person - сотрудник
     * @return - отфильтрованные документы
     */
    public static List<Document> filtersDocumentsByPerson(List<Document> documents, Person person) {
        List<Document> result = new ArrayList<Document>();
        for (Document document : documents) {
            if (document.getAuthor().equals(person)) {
                result.add(document);
            }
        }
        return result;
    }
}
