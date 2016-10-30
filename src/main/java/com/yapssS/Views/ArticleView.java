package com.yapssS.Views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.yapssS.Controllers.QuestionList;
import com.yapssS.YapssUI;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created by Max on 30/10/16.
 */
@SuppressWarnings("serial")
@SpringView(name = YapssUI.ARTICLEVIEW)
public class ArticleView extends VerticalLayout implements View{

    @Autowired
    private QuestionList questionList;

    @PostConstruct
    void init() {
        setSizeFull();
        setSpacing(true);
        Label label = new Label("Heppafjonk");
        addComponent(label);
    }
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        Notification.show("Welcome! Please log in.");
    }
}
