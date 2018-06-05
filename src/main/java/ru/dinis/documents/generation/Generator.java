package ru.dinis.documents.generation;

import ru.dinis.documents.exception.DocumentExistsException;
import ru.dinis.documents.model.*;

import java.util.*;

public class Generator {

    private List<Document> documents = new ArrayList<Document>();

    private List<Person> people = this.fillAuthors();

    private int taskNumber = 0;

    private int incomingNumber = 0;

    private int outGoingNumber = 0;

    public void fillAllDocuments() {
        for (Person person : this.people) {
            this.documents.addAll(person.getDocuments());
        }
    }


    public List<Person> fillAuthors() {
        List<Person> authors = new ArrayList<Person>();
        authors.add(new Person("Иванов Иван Иванович"));
        authors.add(new Person("Сидоров Сидор Сидорович"));
//        authors.add(new Person("Петров Петр Петрович"));
//        authors.add(new Person("Андреев Андрей Андреевич"));
//        authors.add(new Person("Николаев Николай Николаевич"));
//        authors.add(new Person("Данилов Даниил Данилович"));
        return authors;
    }

    public Person getAuthor() {
        return this.people.get(new Random().nextInt(people.size()));
    }

    public void fillDocument(Document document) {
        document.setId(new Random().nextInt(100));
        document.setDescribe(" Описание документа....");
        document.setRegNumber(new Random().nextInt() + "");
        document.setRegDate(new Date());
        document.setAuthor(getAuthor());
    }

    public void createClass(String className) {
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
                task.getAuthor().getDocuments().add(task);
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
                incoming.getAuthor().getDocuments().add(incoming);
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
                outgoing.getAuthor().getDocuments().add(outgoing);
            } catch (DocumentExistsException dee) {
                dee.printStackTrace();
                System.out.println("Введите название документа еще раз!");
            }
        }
    }

    public void showDocuments() {
        for (Person person : this.people) {
            person.showDocuments();
        }
    }

    public String genRegNumber() {
        return "№" + Math.abs(new Random().nextInt(5));
    }

    public String checkExistsDocument(String regNumber) throws DocumentExistsException {
       this.fillAllDocuments();
       for (Document document : this.documents) {
           if (document.getRegNumber().equals(regNumber)) {
               throw new DocumentExistsException("Данный регистрацищнный номер уже существует!!");
           }
       }
       return regNumber;
    }
}
