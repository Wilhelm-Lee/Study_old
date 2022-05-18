package com.MichealWilliam;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Functions functions = new Functions();
        Functions.TodoList todoList = new Functions.TodoList();

        System.out.println(todoList.onCreate());

    }
}
