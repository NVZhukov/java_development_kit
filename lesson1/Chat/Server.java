package ru.gb.lesson1.Chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Server extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 500;
    private static final int WINDOW_POSY = 300;
    boolean isWork = false;
    Client client;

    JButton btnStart, btnStop;
    JTextArea textArea = new JTextArea();

    File log = new File("log.txt");

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

    void saveToFile(String msg) {
        try {
            FileWriter fw = new FileWriter(log, true);
            DateFormat dateF = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            String time = dateF.format(cal.getTime());
            fw.write(time + " " + msg);
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void getHistory() {
        if (log.isFile()) {
            try {
                FileReader fr = new FileReader(log);
                BufferedReader br = new BufferedReader(fr);
                String line = br.readLine();
                while (line != null) {
                    client.textArea.append(line + "\n");
                    line = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
