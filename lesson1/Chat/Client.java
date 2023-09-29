package ru.gb.lesson1.Chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class Client extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;
    JButton btnSendMsg, btnLogIn;
    JTextField textFieldMsg, textIP, textPort, textLogin, textPass;
    JTextArea textArea = new JTextArea();
    JScrollPane scrollPane;
    String login = "";

    Client() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Chat Client");
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textFieldMsg = new JTextField();
        JPanel panelLogin = new JPanel(new BorderLayout());
        JPanel panelForm = new JPanel(new GridLayout(2,2));
        btnLogIn = new JButton("Login");
        textIP = new JTextField("IP");
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

        btnSendMsg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append(textFieldMsg.getText() + "\n");
                textFieldMsg.setText("");
                textFieldMsg.requestFocus(true);
            }
        });

        btnLogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = e.getActionCommand();
                if(s.equals("Login")){
                    login = textLogin.getText();
                    panelLogin.setVisible(false);
                    textArea.append("Привет " + login);
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
                if (key == KeyEvent.VK_ENTER) {
                    textArea.append(textFieldMsg.getText() + "\n");
                    textFieldMsg.setText("");
                    textFieldMsg.requestFocus(true);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        textIP.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(Objects.equals(textIP.getText(), "IP")){
                    textIP.setText("");
                }else return;
            }
        });
        textPort.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(Objects.equals(textPort.getText(), "Port")){
                    textPort.setText("");
                }else return;
            }
        });
        textLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(Objects.equals(textLogin.getText(), "Login")){
                    textLogin.setText("");
                }else return;
            }
        });
        textPass.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(Objects.equals(textPass.getText(), "Password")){
                    textPass.setText("");
                }else return;
            }
        });
    }
}
