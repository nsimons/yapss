
/**
 * Created by Isokeke on 30.10.2016.
 */

package com.yapssS.Views;

import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import com.yapssS.Controllers.QuestionList;
import com.yapssS.Interface.Menu;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.yapssS.Interface.QuestionArea;
import com.yapssS.YapssUI;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@SuppressWarnings("serial")
@SpringView(name = YapssUI.MAINVIEW)
public class MainView extends VerticalLayout implements View {

    @Autowired
    private QuestionList questionList;

    @PostConstruct
    void init() {
        setSizeFull();
        setSpacing(true);
        addComponent(new Menu());
        addComponent(addHeader());
        addComponent(addSubHeader());
        addComponent(new QuestionArea(questionList));
        questionList.setWidth("80%");
        addComponent(questionList);
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
