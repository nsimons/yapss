
/**
 * Created by Isokeke on 30.10.2016.
 */

package com.yapssS.Views;

import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import com.yapssS.Controllers.QuestionList;
import com.yapssS.Interface.Menu;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.yapssS.Interface.QuestionArea;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("serial")
public class MainView extends VerticalLayout implements View {

    @Autowired
    QuestionList questionList;


    public MainView() {
        setSizeFull();
        setSpacing(true);
        addComponent(new Menu());
        addComponent(addHeader());
        addComponent(addSubHeader());
        addComponent(new QuestionArea());
        /*questionList.setWidth("80%");
        addComponent(questionList);*/
    }

    @Override
    public void enter(ViewChangeEvent event) {
        Notification.show("Showing view: Main!");
    }

    private Label addHeader() {
        Label header = new Label("WELCOME TO YAPSS!");
        header.setStyleName(ValoTheme.LABEL_H1);
        header.setSizeUndefined();
        return header;
    }

    private Label addSubHeader() {
        Label subHeader = new Label("YET ANOTHER PROBLEM SOLVING SITE");
        subHeader.setStyleName(ValoTheme.LABEL_TINY);
        subHeader.setSizeUndefined();
        return subHeader;
    }

}
