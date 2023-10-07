package ru.gb.lesson2.server;

import ru.gb.lesson2.server.client.ClientGUI;

public class Main {
    public static void main(String[] args) {

        ServerWindow serverWindow = new ServerWindow();
        new ClientGUI(serverWindow);
        new ClientGUI(serverWindow);
    }
}
