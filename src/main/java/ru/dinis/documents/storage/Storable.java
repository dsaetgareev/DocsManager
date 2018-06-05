package ru.dinis.documents.storage;

import ru.dinis.documents.model.Document;

public interface Storable {

    void addDocument(Document document);

    Document getDocumentById(int id);

    Document getDocumentByTable(String tableName);

}
