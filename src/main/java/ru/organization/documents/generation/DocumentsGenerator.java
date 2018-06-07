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
 * класс генерирует документы.
 */
public class DocumentsGenerator {

    /**
     * документы всех сотрудников.
     */
    private List<Document> documents = new ArrayList<Document>();

    /**
     * сотрудники для которых будут генерироваться документы.
     */
    private List<Person> people;

    /**
     * сервис для persons.
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
     * случайно назначает автора.
     * @return person - автор документа
     */
    public Person getAuthor() {
        return this.people.get(new Random().nextInt(people.size()));
    }

    /**
     * заполнение документа случайными числами.
     * @param document - заполненный документ
     */
    public void fillDocument(Document document) {
        document.setId(new Random().nextInt(100));
        document.setDescribe(" Описание документа....");
        document.setRegNumber(new Random().nextInt() + "");
        document.setRegDate(new Date());
        document.setAuthor(getAuthor());
    }

    /**
     * создание документа.
     * @param className - класс документа.
     */
    public void createDocument(String className) {
        if ("Task".equals(className)) {
            try {
                Task task = new Task();
                this.fillDocument(task);
                task.setName("Поручение");
                task.setRegNumber(this.checkExistsDocument(this.genRegNumber()));
                task.setExtraditionDate(new Date());
                task.setDeadline(new Date(new Date().getTime() + new Random().nextInt(10) * (1000 * 60 * 60 * 24)));
                task.setExecutor(this.getAuthor());
                task.setControl(new Random().nextInt() > 0.5);
                task.setController(this.getAuthor());
                this.documents.add(task);
            } catch (DocumentExistsException dee) {
                dee.printStackTrace();
                System.out.println("Введите название документа еще раз!");
            }
        }
        if ("Incoming".equals(className)) {
            try {
                Incoming incoming = new Incoming();
                this.fillDocument(incoming);
                incoming.setName("Входящий");
                incoming.setRegNumber(this.checkExistsDocument(this.genRegNumber()));
                incoming.setSender(this.getAuthor());
                incoming.setDestination(this.getAuthor());
                incoming.setOutgoingNumber(new Random().nextInt() + "");
                incoming.setOutRegDate(new Date());
                this.documents.add(incoming);
            } catch (DocumentExistsException dee) {
                dee.printStackTrace();
                System.out.println("Введите название документа еще раз!");
            }
        }
        if ("OutGoing".equals(className)) {
            try {
                OutGoing outgoing = new OutGoing();
                this.fillDocument(outgoing);
                outgoing.setName("Исходящий");
                outgoing.setRegNumber(this.checkExistsDocument(this.genRegNumber()));
                outgoing.setDestination(this.getAuthor());
                outgoing.setDeliveryMethod("Электронный");
                this.documents.add(outgoing);
            } catch (DocumentExistsException dee) {
                dee.printStackTrace();
                System.out.println("Введите название документа еще раз!");
            }
        }
    }

    /**
     * генерация регестрационного номера
     * @return номер документа
     */
    public String genRegNumber() {
        return "№" + Math.abs(new Random().nextInt(10));
    }

    /**
     * проверка номера документа на дубликаты.
     * @param regNumber - проверяемый номер
     * @return regNumber - номер документа
     * @throws DocumentExistsException - возможное исключение
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
