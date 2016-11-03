package com.yapssS.Controllers;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Max on 12/10/16.
 */


@SpringComponent
public class QuestionList extends VerticalLayout implements QuestionChangeListener{

    @Autowired
    QuestionRepository repository;
    private List<Question> questions;

    @PostConstruct
    public void init() {
        setSpacing(true);

        setQuestions(repository.findAll());
        
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
        removeAllComponents();

        questions.forEach(question -> {
            addComponent(new QuestionLayout(question, this));
        });
    }
    //find the specific question based on the ID
    /*public void setSpecificQuestion(Long id) {
        addComponent(new QuestionLayout(repository.findOne(id), this));
        //setQuestions(questions.add(id, repository.findOne(id)));
        System.out.println(repository.findOne(id));
    }*/

    public void save(Question question) {
        repository.save(question);
        update();
    }

    private void update() {
        setQuestions(repository.findAll());
    }

    @Override
    public void questionChanged(Question question) {
        save(question);
    }


    public void deleteCompleted() {
        repository.deleteInBatch(
                questions.stream().filter(Question::isDone).collect(Collectors.toList())
        );


        update();
    }
}
