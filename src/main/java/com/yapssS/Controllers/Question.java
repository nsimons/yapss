package com.yapssS.Controllers;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String subject;

    private String text;

    private boolean done;

    public Question() {
    }

    public Question(String subject, String text) {
        this.subject = subject;
        this.text = text;

    }

    public Question(String subject, String text, boolean done) {
        this.subject = subject;
        this.text = text;
        this.done = done;

    }

    public String getSubject() { return subject; }

    public Long getId() {return id;}

    public void setSubject(String subject) { this.subject = subject; }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void toggleDone() {
        setDone(!isDone());
    }

}