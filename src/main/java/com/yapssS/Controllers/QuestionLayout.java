package com.yapssS.Controllers;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;

import java.util.Arrays;

/**
 * Created by Max on 12/10/16.
 *
 */
public class QuestionLayout extends HorizontalLayout {

    private final CheckBox done;
    private final TextField text;

    public QuestionLayout(Question question, QuestionChangeListener changeListener) {
        setSpacing(true);
        setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
        done = new CheckBox();
        text = new TextField();
        text.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
        text.setWidth("100%");

        FieldGroup fieldGroup = new FieldGroup(new BeanItem<>(question));
        fieldGroup.bindMemberFields(this);
        fieldGroup.setBuffered(false);

        addComponents(done, text);
        setExpandRatio(text, 1);

        Arrays.asList(done, text).forEach(field->
            field.addValueChangeListener(change ->
                changeListener.questionChanged(question))
        );
    }
}
