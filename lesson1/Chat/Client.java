package ru.gb.lesson1.Chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Client extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;
    Server server;

    JButton btnSendMsg, btnLogIn;
    JTextField textFieldMsg, textIP, textPort, textLogin, textPass;
    JTextArea textArea = new JTextArea();
    JScrollPane scrollPane;
    String login = "";

    Client(Server server) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Chat Client");
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textFieldMsg = new JTextField();
        JPanel panelLogin = new JPanel(new BorderLayout());
        JPanel panelForm = new JPanel(new GridLayout(2, 2));
        btnLogIn = new JButton("Login");
        textIP = new JTextField("Your IP");
        textPort = new JTextField("Port");
        textLogin = new JTextField("Login");
        textPass = new JPasswordField("Password");
        panelForm.add(textIP);
        panelForm.add(textPort);
        panelForm.add(textLogin);
        panelForm.add(textPass);
        panelLogin.add(panelForm, BorderLayout.CENTER);
        panelLogin.add(btnLogIn, BorderLayout.EAST);
        add(panelLogin, BorderLayout.NORTH);

        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        btnSendMsg = new JButton("Send");
        JPanel panelMsg = new JPanel(new BorderLayout());
        getContentPane().add(scrollPane);
        panelMsg.add(textFieldMsg, BorderLayout.CENTER);
        panelMsg.add(btnSendMsg, BorderLayout.EAST);
        add(panelMsg, BorderLayout.SOUTH);
        setVisible(true);


        btnSendMsg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String msg = login + ": " + textFieldMsg.getText() + "\n";
                if (!login.equals("")) {
                    if (!textFieldMsg.getText().equals("")) {
                        textArea.append(msg);
                        if (server.isWork) {
                            server.saveToFile(msg);
                            server.textArea.append(msg);
                        }
                        textFieldMsg.setText("");
                        textFieldMsg.requestFocus(true);
                    }
                } else {
                    textArea.append("Сначала надо залогиниться!\n");
                }
            }
        });

        btnLogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = e.getActionCommand();
                if (s.equals("Login")) {
                    if (server.isWork) {
                        server.getHistory();
                        login = textLogin.getText();
                        panelLogin.setVisible(false);
                        setTitle("Chat Client" + " [" + login + "]");
                        textArea.append("Привет " + login + "\n");
                    } else {
                        login = textLogin.getText();
                        panelLogin.setVisible(false);
                        setTitle("Chat Client" + " [" + login + "]");
                        textArea.append("Привет " + login + "\n");
                    }
                }
            }
        });

        textFieldMsg.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                String msg = login + ": " + textFieldMsg.getText() + "\n";
                if (key == KeyEvent.VK_ENTER && !textFieldMsg.getText().equals("")) {
                    if (!login.equals("")) {
                        textArea.append(msg);
                        if (server.isWork) {
                            server.textArea.append(msg);
                            server.saveToFile(msg);
                        }
                        textFieldMsg.setText("");
                        textFieldMsg.requestFocus(true);
                    } else {
                        textArea.append("Сначала надо залогиниться!\n");
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        textIP.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textIP.getText().equals("Your IP")) {
                    textIP.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textIP.getText().equals("")) {
                    textIP.setText("Your IP");
                }
            }
        });
        textPort.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textPort.getText().equals("Port")) {
                    textPort.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textPort.getText().equals("")) {
                    textPort.setText("Port");
                }
            }
        });
        textLogin.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textLogin.getText().equals("Login")) {
                    textLogin.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textLogin.getText().equals("")) {
                    textLogin.setText("Login");
                }
            }
        });

        textPass.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textPass.getText().equals("Password")) {
                    textPass.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textPass.getText().equals("")) {
                    textPass.setText("Password");
                }
            }
        });
    }
}
