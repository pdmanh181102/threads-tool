package com.tools.ui;

import javax.swing.JFrame;

public class ScreenManager {

    // singleton instance
    private static ScreenManager instance;
    public static ScreenManager getInstance() {
        if (instance == null) {
            instance = new ScreenManager();
        }
        return instance;
    }

    
    private JFrame window;

    public ScreenManager() {
        this.window = new JFrame();
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setSize(800, 600);
        this.window.setLocationRelativeTo(null); 
        this.window.setVisible(true);
    }

    public void setView(BaseView view) {
        window.getContentPane().removeAll();
        window.add(view);
        window.revalidate();
        window.repaint();
    }

}
