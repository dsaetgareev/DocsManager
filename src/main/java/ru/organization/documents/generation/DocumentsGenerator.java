package ru.organization.documents.generation;

import ru.organization.documents.exception.DocumentExistsException;
import ru.organization.documents.model.docs.Incoming;
import ru.organization.documents.model.docs.OutGoing;
import ru.organization.documents.model.staff.Person;
import ru.organization.documents.service.PersonService;
import ru.organization.documents.model.docs.Document;
import ru.organization.documents.model.docs.Task;

import java.util.*;

/**
 * class generating documents for person.
 */
public class DocumentsGenerator {

    /**
     * documents of all persons.
     */
    private List<Document> documents = new ArrayList<Document>();

    /**
     * persons for whom documents are generating.
     */
    private List<Person> people;

    /**
     * personService object for manipulating of person.
     */
    private PersonService personService = new PersonService();

    public DocumentsGenerator() {
    }

    public DocumentsGenerator(List<Person> people) {
        this.people = people;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    /**
     * randomly setting author for document.
     * @return person - author of document
     */
    public Person getAuthor() {
        return this.people.get(new Random().nextInt(people.size()));
    }

    /**
     * randomly fill document.
     * @param document - completed document
     */
    public void fillDocument(Document document) {
        document.setId(new Random().nextInt(100));
        document.setDescribe(" Описание документа....");
        document.setRegNumber(new Random().nextInt() + "");
        document.setRegDate(new Date());
        document.setAuthor(getAuthor());
    }

    /**
     * method create document.
     * @param className - class of document.
     */
    public void createDocument(String className) {
        if (className.equals("Task")) {
            try {
                Document task = new Task();
                this.fillDocument(task);
                task.setName("Поручение");
                task.setRegNumber(this.checkExistsDocument(this.genRegNumber()));
                ((Task) task).setExtraditionDate(new Date());
                ((Task) task).setDeadline(new Date(new Date().getTime() + new Random().nextInt(10) * (1000 * 60 * 60 * 24)));
                ((Task) task).setExecutor(this.getAuthor());
                ((Task) task).setControl(new Random().nextInt() > 0.5);
                ((Task) task).setController(this.getAuthor());
                this.documents.add(task);
            } catch (DocumentExistsException dee) {
                dee.printStackTrace();
                System.out.println("Введите название документа еще раз!");
            }
        }
        if (className.equals("Incoming")) {
            try {
                Document incoming = new Incoming();
                this.fillDocument(incoming);
                incoming.setName("Входящий");
                incoming.setRegNumber(this.checkExistsDocument(this.genRegNumber()));
                ((Incoming) incoming).setSender(this.getAuthor());
                ((Incoming) incoming).setDestination(this.getAuthor());
                ((Incoming) incoming).setOutgoingNumber(new Random().nextInt() + "");
                ((Incoming) incoming).setOutRegDate(new Date());
                this.documents.add(incoming);
            } catch (DocumentExistsException dee) {
                dee.printStackTrace();
                System.out.println("Введите название документа еще раз!");
            }
        }
        if (className.equals("OutGoing")) {
            try {
                Document outgoing = new OutGoing();
                this.fillDocument(outgoing);
                outgoing.setName("Исходящий");
                outgoing.setRegNumber(this.checkExistsDocument(this.genRegNumber()));
                ((OutGoing) outgoing).setDestination(this.getAuthor());
                ((OutGoing) outgoing).setDeliveryMethod("Электронный");
                this.documents.add(outgoing);
            } catch (DocumentExistsException dee) {
                dee.printStackTrace();
                System.out.println("Введите название документа еще раз!");
            }
        }
    }

    /**
     * generates registration number for document
     * @return registration document
     */
    public String genRegNumber() {
        return "№" + Math.abs(new Random().nextInt(10));
    }

    /**
     * checks the existing registration number of document.
     * @param regNumber - checked number
     * @return regNumber
     * @throws DocumentExistsException - exception
     */
    public String checkExistsDocument(String regNumber) throws DocumentExistsException {
       for (Document document : this.documents) {
           if (document.getRegNumber().equals(regNumber)) {
               throw new DocumentExistsException("Данный регистрационный номер уже существует!!");
           }
       }
       return regNumber;
    }
}
