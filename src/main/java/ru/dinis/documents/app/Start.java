package ru.dinis.documents.app;

import ru.dinis.documents.generation.Generator;
import ru.dinis.documents.model.Document;
import ru.dinis.documents.model.Task;

import java.util.Date;
import java.util.Scanner;

public class Start {

    public static void main(String[] args) {
        Generator generator = new Generator();

        while (true) {
            System.out.print("Введите название класса:___");
            Scanner scann = new Scanner(System.in);
            generator.createClass(scann.nextLine());
            generator.showDocuments();
        }
    }
}
