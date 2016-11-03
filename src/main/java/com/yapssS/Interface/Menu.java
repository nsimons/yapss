
/**
 * Created by Isokeke on 30.10.2016.
 */
package com.yapssS.Interface;
import com.vaadin.ui.Label;
import com.yapssS.YapssUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Button.ClickEvent;

@SuppressWarnings("serial")
public class Menu extends CustomComponent {

    private Label currentUserLabel;

    public Menu() {
        HorizontalLayout layout = new HorizontalLayout();
        currentUserLabel = new Label();
        layout.addComponent(currentUserLabel);
        layout.addComponent(mainButton());
        layout.addComponent(logoutButton());
        layout.setSizeUndefined();
        layout.setSpacing(true);
        setSizeUndefined();
        setCompositionRoot(layout);
    }

    private Button mainButton() {
        Button button = new Button("Main", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                getUI().getNavigator().navigateTo(YapssUI.MAINVIEW);
            }
        });
        return button;
    }

    private Button logoutButton() {
        Button button = new Button("Logout", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                getUI().getSession().close();
                getUI().getPage().setLocation(getLogoutPath());
            }
        });
        return button;
    }

    public void setCurrentUserLabel(String user) {
        currentUserLabel.setValue(user);
    }

    private String getLogoutPath() {
        return getUI().getPage().getLocation().getPath();
    }

}
