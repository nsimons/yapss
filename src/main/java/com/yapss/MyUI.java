package com.yapss;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    //private QuestionForm questionForm = QuestionForm.getInstance();


    @Override
    protected void init(VaadinRequest vaadinRequest) {

        final HorizontalLayout rootLayout = new HorizontalLayout();
        setContent(rootLayout);

        final VerticalLayout sideLayout = new VerticalLayout();
        sideLayout.setWidth("250px");


        final VerticalLayout mainLayout = new VerticalLayout();


        rootLayout.addComponents(sideLayout, mainLayout);


        Button homeButton = new Button("Home");
        homeButton.addClickListener( e -> {

        });

        Button loginButton = new Button("Login");
        loginButton.addClickListener( e -> {

        });


        sideLayout.addComponents(homeButton, loginButton);
        sideLayout.setSpacing(true);

        final Label yapssLabel = new Label("Welcome to YAPSS!");

        final RichTextArea submitTextField = new RichTextArea();
        submitTextField.setCaption("Submit your oneliner question here");

        Button uploadButton = new Button("Upload");
        uploadButton.addClickListener( e -> {
            mainLayout.addComponent(new Button("Thanks " + submitTextField.getValue()
                    + ", it works!"));
        });
        
        mainLayout.addComponents(yapssLabel, submitTextField, uploadButton);
        rootLayout.setMargin(true);
        rootLayout.setSpacing(true);
        

    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
