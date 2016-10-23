package com.yapssS;

import com.vaadin.annotations.Theme;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Max on 12/10/16.
 */
@SpringUI
@Theme("valo")
public class YapssUI extends UI {

    private VerticalLayout layout;

    @Autowired
    QuestionList questionList;

    @Override
    protected void init(VaadinRequest vaadinRequest){
        setupLayout();
        addHeader();
        addForm();
        addQuestionList();
        addActionButton();

    }
    private void setupLayout() {
        layout = new VerticalLayout();
        layout.setSpacing(true);
        layout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setContent(layout);

    }
    private void addHeader() {
        Label header = new Label("WELCOME TO YAPSS!");
        Label subHeader = new Label("YET ANOTHER PROBLEM SOLVING SITE");
        header.setStyleName(ValoTheme.LABEL_H1);
        header.setSizeUndefined();
        subHeader.setStyleName(ValoTheme.LABEL_TINY);
        subHeader.setSizeUndefined();
        layout.addComponents(header, subHeader);
    }
    private void addForm() {
        VerticalLayout questionFormLayout = new VerticalLayout();
        questionFormLayout.setSpacing(true);
        questionFormLayout.setWidth("80%");

        RichTextArea questionField = new RichTextArea();
        questionField.setWidth("100%");

        Button postQuestionBttn = new Button(" ");
        postQuestionBttn.setIcon(FontAwesome.ENVELOPE_O);
        postQuestionBttn.addStyleName(ValoTheme.BUTTON_PRIMARY);

        questionFormLayout.addComponents(questionField, postQuestionBttn);
        questionFormLayout.setExpandRatio(questionField, 1);
        layout.addComponent(questionFormLayout);

        postQuestionBttn.addClickListener(click -> {
            questionList.save(new Question(questionField.getValue()));
            questionField.clear();
            questionField.focus();

        });

        questionField.focus();

        postQuestionBttn.setClickShortcut(ShortcutAction.KeyCode.ENTER);


    }

    private void addActionButton() {
        Button deleteButton = new Button("Delete Question");
        deleteButton.addClickListener(click-> questionList.deleteCompleted());
        layout.addComponent(deleteButton);

    }

    private void addQuestionList() {
        questionList.setWidth("80%");
        layout.addComponent(questionList);


    }







}
