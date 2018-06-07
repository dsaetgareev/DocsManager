package ru.organization.documents.storage;

import ru.organization.documents.model.docs.Document;

public interface Storable {

    void addDocument(Document document);

    Document getDocumentById(int id);

    Document getDocumentByTable(String tableName);

}
