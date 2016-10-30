package com.yapssS.Controllers;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import com.yapssS.YapssUI;

import java.util.Arrays;

/**
 * Created by Max on 12/10/16.
 *
 */
public class QuestionLayout extends HorizontalLayout {

    private final CheckBox checkBox;
    private final Button subject;
    private final TextArea text;
    private final VerticalLayout vlayout;
    private final Button enterView;

    public QuestionLayout(Question question, QuestionChangeListener changeListener) {
        setSpacing(true);
        setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);

        checkBox = new CheckBox();

        subject = new Button(question.getSubject());
        // add view changer here!
        //enterView = new Link("Go to question", new ExternalResource("http://localhost:8080/#!" + question.getId()));
        enterView = new Button(question.getId());
        enterView.addClickListener(clickEvent -> {getUI().getNavigator().navigateTo(YapssUI.ARTICLEVIEW);}

        );


        enterView.setVisible(false);

        text = new TextArea();
        text.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
        text.setWidth("100%");
        text.setVisible(false);

        subject.addClickListener(clickEvent -> {
            text.setVisible(!text.isVisible());
            enterView.setVisible(!enterView.isVisible());
        });

        vlayout = new VerticalLayout();

        FieldGroup fieldGroup = new FieldGroup(new BeanItem<>(question));
        fieldGroup.bindMemberFields(this);
        fieldGroup.setBuffered(false);

        vlayout.addComponents(subject, text);
        addComponents(checkBox, vlayout, enterView);

        Arrays.asList(checkBox, text).forEach(field->
            field.addValueChangeListener(change ->
                changeListener.questionChanged(question))
        );
    }
}
