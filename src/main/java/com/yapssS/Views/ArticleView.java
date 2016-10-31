package com.yapssS.Views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import com.yapssS.Controllers.QuestionList;
import com.yapssS.YapssUI;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created by Max on 30/10/16.
 */
@SuppressWarnings("serial")
@SpringView(name = YapssUI.ARTICLEVIEW)
public class ArticleView extends HorizontalLayout implements View {
    //Long id = 1.0;
    @Autowired
    private QuestionList questionList;

    @PostConstruct
    void init() {
        setSizeFull();
        setSpacing(true);
        Label label = new Label("Here be question");

        addComponent(backButton());
        addComponent(label);
        addComponent(questionList);


        // addComponent(questionList.setSpecificQuestion());
    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        Notification.show("You're viewing a question!");
    }

    private Button backButton() {

        Button button = new Button("Back to home", new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getUI().getNavigator().navigateTo(YapssUI.MAINVIEW);
            }
        });
        return button;
    }
}
