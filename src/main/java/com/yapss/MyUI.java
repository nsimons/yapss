package com.yapss;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.HorizontalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final HorizontalLayout rootLayout = new HorizontalLayout();
        setContent(rootLayout);

        final VerticalLayout sideLayout = new VerticalLayout();
        sideLayout.setWidth("250px");
        rootLayout.addComponent(sideLayout);

        final VerticalLayout mainLayout = new VerticalLayout();
        rootLayout.addComponent(mainLayout);

        Label home = new Label("Home");
        sideLayout.addComponent(home);

        Label login = new Label("Login");
        sideLayout.addComponent(login);

        final Label yapssLabel = new Label("Welcome to YAPSS!");


        final TextField submitTextField = new TextField();
        submitTextField.setCaption("Submit your oneliner question here");

        Button uploadButton = new Button("Upload");
        uploadButton.addClickListener( e -> {
            mainLayout.addComponent(new Label("Thanks " + submitTextField.getValue()
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
