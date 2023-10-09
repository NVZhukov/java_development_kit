package ru.gb.lesson2.server.server;

import ru.gb.lesson2.server.client.Client;

import java.util.ArrayList;
import java.util.List;

public class Server {

    List<Client> clientList;
    private ServerView serverView;
    private Repository repository;
    boolean work;

    public Server() {
        repository = new Storage();
        clientList = new ArrayList<>();
        serverView = new ServerWindow(this);
    }

    public boolean connectUser(Client client){
        if (!work){
            return false;
        }
        clientList.add(client);
        return true;
    }

    public void disconnectUser(Client client){
        clientList.remove(client);
        if (client != null){
            client.disconnect();
        }
    }

    public void sendMessage(String text) {
        if (!work){
            return;
        }
        answerAll(text);
        saveInLog(text);
        printText(text);
    }

    private void answerAll(String text){
        for (Client client: clientList){
            client.serverAnswer(text);
        }
    }

    public void startServer() {
        if (work){
            printText("Сервер уже был запущен");
        } else {
            work = true;
            printText("Сервер запущен!");
        }
    }

    public void stopServer() {
        int k = clientList.size();
        if (!work){
            printText("Сервер уже был остановлен");
        } else {
            work = false;
            while (k > 0) {
                k--;
                disconnectUser(clientList.get(k));
            }
            printText("Сервер остановлен!");
        }
    }

    private void printText(String text){
        serverView.appendLog(text);
    }

    public String getLog() {
        return readLog();
    }

    private void saveInLog(String text){
        repository.saveLog(text);
    }

    private String readLog(){
        return repository.readLog();
    }
}
