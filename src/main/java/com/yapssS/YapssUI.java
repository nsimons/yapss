package com.yapssS;

import com.yapssS.Controllers.QuestionList;
import com.yapssS.Views.LoginView;
import com.yapssS.Views.MainView;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.Navigator.ComponentContainerViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Max on 12/10/16.
 */
@SpringUI
@Theme("valo")
public class YapssUI extends UI {

    public Navigator navigator;

    public static final String MAINVIEW = "main";

    @Override
    protected void init(VaadinRequest vaadinRequest){
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        layout.setSpacing(true);
        setContent(layout);
        ComponentContainerViewDisplay viewDisplay = new ComponentContainerViewDisplay(layout);
        navigator = new Navigator(UI.getCurrent(), viewDisplay);
        navigator.addView("", new LoginView());
        navigator.addView(MAINVIEW, new MainView());
    }

}
