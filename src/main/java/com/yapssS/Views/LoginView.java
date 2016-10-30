
/**
 * Created by Isokeke on 30.10.2016.
 */

package com.yapssS.Views;

import com.vaadin.spring.annotation.SpringView;
import com.yapssS.YapssUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

@SuppressWarnings("serial")
@SpringView(name = YapssUI.LOGINVIEW)
public class LoginView extends VerticalLayout implements View {

    @PostConstruct
    void init() {
        setSizeFull();
        setSpacing(true);

        Label label = new Label("Enter your information below to log in.");
        TextField username = new TextField("Username");
        TextField password = new TextField("Password");

        addComponent(label);
        addComponent(username);
        addComponent(password);
        addComponent(loginButton());
    }

    @Override
    public void enter(ViewChangeEvent event) {
        Notification.show("Welcome! Please log in.");
    }

    private Button loginButton() {
        Button button = new Button("Log In", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                getUI().getNavigator().navigateTo(YapssUI.MAINVIEW);
            }
        });
        return button;
    }

}
