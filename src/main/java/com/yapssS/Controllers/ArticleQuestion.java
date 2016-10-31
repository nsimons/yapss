package com.yapssS.Controllers;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Max on 31/10/16.
 */

@SpringComponent
public class ArticleQuestion extends VerticalLayout implements QuestionChangeListener {

    @Autowired
    QuestionRepository repository;
    private Question question;
    private Long id;

    @PostConstruct
    public void init() {
        setSpacing(true);
        //setSpecificQuestion(repository.findOne(id));
    }

    public void setQuestion(Question question) {
        this.question = question;
        //addComponent(new QuestionLayout(repository.findOne(id), this));

    }

    //find the specific question based on the ID
    public void setSpecificQuestion(Long id) {
        addComponent(new ArticleQuestionLayout(repository.findOne(id), this));

    }

    public void save(Question question) {
        repository.save(question);
        update();
    }

    private void update() {
        setQuestion(repository.findOne(id));
    }

    @Override
    public void questionChanged(Question question) {
        save(question);
    }


}
