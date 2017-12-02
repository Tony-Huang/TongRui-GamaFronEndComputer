/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.ui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

/**
 *
 * @author Administrator
 */
/*************************   下面是有模态功能的JFrame   ***************************/
public class Model_JFrame extends JFrame implements WindowListener {

    private JFrame parentFrame = null;
    private boolean modal = false;
    private String title = null;

    public Model_JFrame() {
        this(null, false);
    }

    public Model_JFrame(JFrame father) {
        this(father, false);
    }

    public Model_JFrame(JFrame father, boolean modal) {
        this(father, modal, "");
    }

    public Model_JFrame(JFrame frame, boolean modal, String title) {
        super(title);
        this.parentFrame = frame;
        this.modal = modal;
        this.title = title;
        this.init();
    }

    private void init() {
        if(parentFrame == null)
            return;
        
        if (modal) {
            parentFrame.setEnabled(false);
        }
        this.addWindowListener(this);
    }

    public void windowOpened(WindowEvent windowEvent) {
    }

    public void windowClosing(WindowEvent windowEvent) {
        if(parentFrame == null)
            return;

        if (modal) {
            parentFrame.setEnabled(true);
        }
    }

    public void windowClosed(WindowEvent windowEvent) {
    }

    public void windowIconified(WindowEvent windowEvent) {
    }

    public void windowDeiconified(WindowEvent windowEvent) {
    }

    public void windowActivated(WindowEvent windowEvent) {
    }

    public void windowDeactivated(WindowEvent windowEvent) {
        if (modal) {
            this.requestFocus();
        }
    }
}
