package io.github.view;

import java.util.Scanner;

public class TextValidation {
    public String validateInput(Scanner sc, String info){
        String data;
        while(true){
            System.out.println(info);
            data = sc.nextLine();
            if (data.matches("[a-zA-ZÀ-ÿ ]+")) return data;
            System.out.println("Error. You can only enter text");
        }

    }
}
