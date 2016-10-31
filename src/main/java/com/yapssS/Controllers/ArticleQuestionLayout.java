package com.yapssS.Controllers;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import com.yapssS.YapssUI;

import java.util.Arrays;

/**
 * Created by Max on 31/10/16.
 */
public class ArticleQuestionLayout extends HorizontalLayout {


    private final Label subject;
    private final TextArea text;
    private final Label commentHeader;
    private final TextArea comment;
    private final VerticalLayout vlayout;

    public ArticleQuestionLayout(Question question, QuestionChangeListener changeListener) {
        setSpacing(true);
        //setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
        setWidth("100%");
        subject = new Label(question.getSubject());

        text = new TextArea();
        text.setValue(question.getText());
        text.setReadOnly(true);
        text.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
        text.setWidth("100%");

        commentHeader = new Label("Add your solution to the posted problem here :");
        comment = new TextArea();
        vlayout = new VerticalLayout();

        FieldGroup fieldGroup = new FieldGroup(new BeanItem<>(question));
        fieldGroup.bindMemberFields(this);
        fieldGroup.setBuffered(false);
        vlayout.addComponents(subject, text, commentHeader, comment);
        addComponent(vlayout);
    }
}

