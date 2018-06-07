package ru.organization.documents.exception;

public class DocumentExistsException extends Exception {

    public DocumentExistsException() {
    }

    public DocumentExistsException(String message) {
        super(message);
    }
}
