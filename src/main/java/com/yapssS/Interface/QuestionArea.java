
/**
 * Created by Isokeke on 30.10.2016.
 */

package com.yapssS.Interface;

import com.vaadin.event.ShortcutAction;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import com.yapssS.Controllers.*;

@SuppressWarnings("serial")
@SpringComponent
public class QuestionArea extends VerticalLayout {

    public QuestionArea(QuestionList questionList) {
        super();

        VerticalLayout questionFormLayout = new VerticalLayout();
        questionFormLayout.setSpacing(true);
        questionFormLayout.setWidth("80%");

        TextField subjectField = new TextField();
        subjectField.setWidth("100%");

        RichTextArea questionField = new RichTextArea();
        questionField.setWidth("100%");

        Button postQuestionBttn = new Button(" ");
        postQuestionBttn.setIcon(FontAwesome.ENVELOPE_O);
        postQuestionBttn.addStyleName(ValoTheme.BUTTON_PRIMARY);

        questionFormLayout.addComponents(subjectField, questionField, postQuestionBttn);
        questionFormLayout.setExpandRatio(questionField, 1);
        addComponent(questionFormLayout);

        postQuestionBttn.addClickListener(click -> {
            if(subjectField.isEmpty() || questionField.isEmpty()) {
                Notification.show("You need to write both a subject and description of your problem!");
                return;
            }
            questionList.save(new Question(subjectField.getValue(), questionField.getValue()));
            subjectField.clear();
            questionField.clear();
            questionField.focus();

        });

        questionField.focus();

        postQuestionBttn.setClickShortcut(ShortcutAction.KeyCode.ENTER);

        Button deleteButton = new Button("Delete Question");
        deleteButton.addClickListener(click-> questionList.deleteCompleted());
        addComponent(deleteButton);


    }
}