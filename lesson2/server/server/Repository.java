package ru.gb.lesson2.server.server;

public interface Repository {
    void saveLog(String text);
    String readLog();
}
