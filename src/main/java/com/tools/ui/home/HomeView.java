package com.tools.ui.home;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.tools.AppContext;
import com.tools.core.model.ThreadsAccount;
import com.tools.ui.BaseView;

public class HomeView extends BaseView {

    private JTable trackingUsernameTable;
    private JButton executeButton;
    private HomeController controller;

    public HomeView() {
        super();
        this.controller = new HomeController(this);
    }

    @Override
    protected void initComponents() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        List<String> trackingUsernames = AppContext.getInstance().getConfig().getTrackingUsernames();
        String[] columnNames = { "STT", "Username" };
        Object[][] data = new Object[trackingUsernames.size()][trackingUsernames.size() + 1];
        for (int i = 0; i < trackingUsernames.size(); i++) {
            data[i][0] = i + 1; // STT
            data[i][1] = trackingUsernames.get(i); // Username
        }
        trackingUsernameTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(trackingUsernameTable);
        add(scrollPane);

        ThreadsAccount threadsAccount = AppContext.getInstance().getConfig().getAccount();

        JLabel accountLabel = new JLabel("Account: " + threadsAccount.getUsername());
        add(accountLabel);

        executeButton = new JButton("Execute");
        add(executeButton);

    }

    @Override
    protected void initEvents() {
        executeButton.addActionListener(e -> controller.execute());
    }

}
