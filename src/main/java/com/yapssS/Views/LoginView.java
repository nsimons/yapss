
/**
 * Created by Isokeke on 30.10.2016.
 */

package com.yapssS.Views;

import com.vaadin.event.ShortcutAction;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import com.yapssS.YapssUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button.ClickEvent;

import javax.annotation.PostConstruct;

@SuppressWarnings("serial")
@SpringView(name = YapssUI.LOGINVIEW)
public class LoginView extends VerticalLayout implements View {

    private String currentUser = null;
    private Label label;
    private TextField username;
    private PasswordField password;

    @PostConstruct
    void init() {
        setSizeFull();
        setSpacing(true);

        label = new Label("Enter your information below to log in.");
        username = new TextField("Username");
        password = new PasswordField("Password");

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
                currentUser = username.getValue();
                getUI().getNavigator().navigateTo(YapssUI.MAINVIEW + "/" + currentUser); //populate in database instead?
            }

        });
        button.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        return button;
    }
    public String getCurrentUser()
    {
        return currentUser;
    }



}
