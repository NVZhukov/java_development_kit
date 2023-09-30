package ru.gb.lesson1.Chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Server extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 500;
    private static final int WINDOW_POSY = 300;
    boolean isWork = false;
    Client client;

    JButton btnStart, btnStop;
    JTextArea textArea = new JTextArea();

    Server() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Chat Server");
        client = new Client(this);

        JPanel panelBtn = new JPanel(new GridLayout(1, 2));
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");
        panelBtn.add(btnStart);
        panelBtn.add(btnStop);
        add(panelBtn, BorderLayout.SOUTH);
        textArea.setEditable(false);
        add(textArea);
        setVisible(true);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isWork) {
                    textArea.append("Server started...\n");
                    isWork = true;
                } else {
                    textArea.append("Server already started!\n");
                }
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isWork) {
                    textArea.append("Server stopped!\n");
                    isWork = false;
                } else {
                    textArea.append("Server already stopped!\n");
                }
            }
        });
    }
}
