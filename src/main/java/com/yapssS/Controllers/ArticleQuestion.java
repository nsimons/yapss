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
    private boolean layout_is_initialized;
    private ArticleQuestionLayout articleQuestionLayout;

    @PostConstruct
    public void init() {
        setSpacing(true);
        layout_is_initialized = false;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setSpecificQuestion(Long id) {
        this.id = id;
        update();
        if (layout_is_initialized) {
            articleQuestionLayout.setText(question.getText());
            articleQuestionLayout.setSubject(question.getSubject());
        } else {
            articleQuestionLayout = new ArticleQuestionLayout(question, this);
            addComponent(articleQuestionLayout);
            layout_is_initialized = true;
        }
    }

    /* Unused for now, modify to save comments? */
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
