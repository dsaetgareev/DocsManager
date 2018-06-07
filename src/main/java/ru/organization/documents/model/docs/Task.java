package ru.organization.documents.model.docs;


import ru.organization.documents.model.staff.Person;

import java.util.Date;

/**
 * task.
 */
public class Task extends Document {
    /**
     * extradition date of document.
     */
    private Date extraditionDate;

    /**
     * deadline of document.
     */
    private Date deadline;

    /**
     * executor.
     */
    private Person executor;

    /**
     * is control.
     */
    private Boolean isControl;
    /**
     * controller.
     */
    private Person controller;


    @Override
    public String toString() {
        return super.toString()
                + "\n         - Дата выдачи документа: " + this.extraditionDate
                + ".\n         - Срок исполнения: " + this.deadline
                + ".\n         - Исполнитель: " + this.executor.getFullName()
                + ".\n         - Признак контрольности: " + (this.isControl ? "На контроле." : "Не на контроле.")
                + ".\n         - Контролер: " + this.controller.getFullName();
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
