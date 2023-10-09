package ru.gb.lesson2.server;

import ru.gb.lesson2.server.client.ClientGUI;
import ru.gb.lesson2.server.server.Server;
import ru.gb.lesson2.server.server.ServerView;
import ru.gb.lesson2.server.server.ServerWindow;

public class Main {
    public static void main(String[] args) {

        Server server = new Server();
        new ClientGUI(server);
        new ClientGUI(server);
    }
}
