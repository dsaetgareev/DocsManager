package ru.organization.documents.app;

import ru.organization.documents.converter.Converter;
import ru.organization.documents.generation.DocumentsGenerator;
import ru.organization.documents.model.docs.Document;
import ru.organization.documents.model.staff.Department;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * class stars app.
 */
public class Start {


    public static void main(String[] args) {

        BuildApp buildApp = new BuildApp();
        DocumentsGenerator documentsGenerator = new DocumentsGenerator();

        /**
         * создание структуры организации.
         */
        buildApp.buildStructure();
        do {

            try {

                /**
                 * показывает welcome страницу.
                 */
                buildApp.showWelcome();
                System.out.print("Выберите департамент по порядковому номеру:__");
                int number = Integer.MAX_VALUE;

                number = new Scanner(System.in).nextInt();


                if (number == 0) {
                    return;
                }


                /**
                 * проверяет хочет ли пользователь выйти из приложения.
                 */

                String consoleCommand = "";

                try {
                    while (!consoleCommand.equals("0")) {

                        List<Document> departmentDocuments = documentsGenerator.getDocuments();


                        /**
                         * возвращает требуемый департамент.
                         */
                        Department department = buildApp.getDepartmentById(number - 1);


                        /**
                         * устанавливает persons для которых будут генерироваться документы.
                         */
                        documentsGenerator.setPeople(department.getPersons());

                        /**
                         * показывает страницу департамента.
                         */
                        buildApp.showDepartment(department, departmentDocuments);
                        System.out.print("Введите название генерируемого документа:__");
                        consoleCommand = new Scanner(System.in).nextLine();
                        if (consoleCommand.equals("push")) {
                            // введена команда сериализации в json
                            buildApp.writeDocuments(department, departmentDocuments);
                        }
                        // введено название класса
                        String className = consoleCommand;

                        /**
                         * создает документ для person.
                         */
                        documentsGenerator.createDocument(className);

                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("\nВведите число из списка!!\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nВведите пожалуйста число!!!\n");
            }

        } while (true);
    }
}
