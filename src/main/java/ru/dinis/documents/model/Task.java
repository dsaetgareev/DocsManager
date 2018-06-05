package ru.dinis.documents.model;


import java.util.Date;

public class Task extends Document {

    private Date extraditionDate;

    private Date deadline;

    private Person executor;

    private Boolean isControl;

    private Person controller;


    @Override
    public String toString() {
        return super.toString()
                + " Дата выдачи документа: " + this.extraditionDate
                + ". Срок исполнения: " + this.deadline
                + ". Исполнитель: " + this.executor.getName()
                + ". Признак контрольности: " + (this.isControl ? "На контроле." : "Не на контроле.")
                + ". Контролер: " + this.controller.getName();
    }

    public Date getExtraditionDate() {
        return extraditionDate;
    }

    public void setExtraditionDate(Date extraditionDate) {
        this.extraditionDate = extraditionDate;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Person getExecutor() {
        return executor;
    }

    public void setExecutor(Person executor) {
        this.executor = executor;
    }

    public Boolean getControl() {
        return isControl;
    }

    public void setControl(Boolean control) {
        isControl = control;
    }

    public Person getController() {
        return controller;
    }

    public void setController(Person controller) {
        this.controller = controller;
    }
}
