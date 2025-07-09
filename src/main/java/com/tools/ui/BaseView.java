package com.tools.ui;

import javax.swing.JPanel;

public abstract class BaseView extends JPanel {
    
    public BaseView() {
        initComponents();
        initEvents();
    }
    protected abstract void initComponents();
    protected abstract void initEvents();
}
