// The war is acome, we shall say no more
package com.MichealWilliam;

import com.MichealWilliam.Functions.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        File file;

        Functions functions = new Functions();
        Functions.TodoList functions_TodoList = new Functions.TodoList();
        file = new File(functions.targetPath.getAbsolutePath());


        System.out.println(functions_TodoList.onCreate(file));
    }


}
