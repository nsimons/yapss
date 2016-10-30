package com.yapssS;

import com.vaadin.spring.navigator.SpringViewProvider;
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

    @Autowired
    private SpringViewProvider springViewProvider;

    public static final String MAINVIEW = "main";
    public static final String LOGINVIEW = "";

    @Override
    protected void init(VaadinRequest vaadinRequest){
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        layout.setSpacing(true);
        setContent(layout);
        ComponentContainerViewDisplay viewDisplay = new ComponentContainerViewDisplay(layout);
        navigator = new Navigator(this, viewDisplay);
        navigator.addProvider(springViewProvider);
        //navigator.addView("", new LoginView());
        //navigator.addView(MAINVIEW, new MainView());
    }

}
