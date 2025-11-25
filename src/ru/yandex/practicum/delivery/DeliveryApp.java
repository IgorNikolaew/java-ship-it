package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {
    //создаем списки посылок
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Parcel> allParcels = new ArrayList<>();
    private static final List<Trackable> trackableParcels = new ArrayList<>();

    //создаем коробки с посылками

    private static ParcelBox standartBox = new ParcelBox("Стандартная коробка", 0, 10);
    private static ParcelBox fragileBox = new ParcelBox("Хрупкая коробка", 0, 15);
    private static ParcelBox perishableBox = new ParcelBox("Коробка со сроком годности", 0, 20);


    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4: // с трэкингом
                    reportStatus();
                    break;
                case 5: //стандартная коробка
                    standartBox.viewAllParcelsInBox();
                    break;
                case 6: //хрупкая коорбка
                    fragileBox.viewAllParcelsInBox();
                    break;
                case 7: // со сроком годности
                    perishableBox.viewAllParcelsInBox();
                    break;

                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 - Посылки с трэкингом");
        System.out.println("5 - Стандартная коробка (показать содержимое)");
        System.out.println("6 - Коробка с хрупкими посылками (показать содержимое)");
        System.out.println("7 - Коробка с портящимися посылками (показать содержимое)");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() { //Создать посылку.

        System.out.println("Укажите описание посылки: ");
        String description = scanner.nextLine();


        System.out.println("Сообщите нам адрес доставки посылки: ");
        String address = scanner.nextLine();

        //System.out.println("Укажите вес посылки в кг (целое число): ");
        //Integer weight = Integer.parseInt(scanner.nextLine());


        Integer weight = null; // посмотрел такую конструкцию и понял, как она работает внешне
        while (weight == null) {
            System.out.println("Укажите вес посылки в кг (целое число): ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Ошибка: вес не может быть пустым.");
                continue;
            }

            try {
                weight = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число.");
            }
        }


        //System.out.println("Укажите день отправки посылки (номер дня месяца): ");
        //Integer sendDay = Integer.parseInt(scanner.nextLine());


        Integer sendDay = null; // посмотрел такую конструкцию и понял, как она работает внешне
        // а вообще, на будущее надо сделать какой то отдельный класс для любого ввода данных, который возьмет на себя
        //весь ввод, проверку и возвращение корректных результватов, чтоб не дублировать похожий код

        while (sendDay == null) {
            System.out.println("Укажите день недели: ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Ошибка: день не может быть пустым.");
                continue;
            }

            try {
                sendDay = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число.");
            }
        }


        System.out.println("Укажите тип посылки: 1 - Стандартная; 2 - Хрупкая; 3 - Скоропортящаяся");
        int type = Integer.parseInt(scanner.nextLine());

        switch (type) { //cоздаем и добавляем в ArrayList
            case 1:
                StandartParcel standartParcel1 = new StandartParcel(description, weight, address, sendDay);
                boolean isCorrect = Parcel.checkUserEnter(standartParcel1); //проверяем введенные данные статическим
                // методом
                if (isCorrect) {
                    allParcels.add(standartParcel1);
                    standartBox.addParcel(standartParcel1);
                    break;
                } else {
                    error1();
                    break;
                }

            case 2:
                FragileParcel fragileParcel1 = new FragileParcel(description, weight, address, sendDay);
                isCorrect = Parcel.checkUserEnter(fragileParcel1);
                if (isCorrect) {
                    allParcels.add(fragileParcel1);
                    trackableParcels.add(fragileParcel1);
                    fragileBox.addParcel(fragileParcel1);
                    break;
                } else {
                    error1();
                    break;
                }
            case 3:
                System.out.println("Укажите срок годности вашей послыки в днях: ");
                Integer timeToLive = Integer.parseInt(scanner.nextLine());
                PerishableParcel perishableParcel1 = new PerishableParcel(description, weight, address, sendDay, timeToLive);
                isCorrect = Parcel.checkUserEnter(perishableParcel1);
                if (isCorrect) {
                    allParcels.add(perishableParcel1);
                    perishableBox.addParcel(perishableParcel1);
                    break;
                } else {
                    error1();
                    break;
                }

            case 0:

                break;
            default:
                System.out.println("Неверный выбор.");
        }


        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
    }

    private static void sendParcels() {

        for (Parcel thisparcel : allParcels) {
            thisparcel.packageItem();
            thisparcel.deliver();

        }


        // Пройти по allParcels, вызвать packageItem() и deliver()
    }

    private static void calculateCosts() {
        int sum = 0;
        for (Parcel thisparcel : allParcels) {
            sum += thisparcel.calculateDeliveryCost();

        }

        System.out.println("Общая стоимость доставки всех посылок составит: " + sum + " рублей");

        // Посчитать общую стоимость всех доставок и вывести на экран
    }

    public static void reportStatus() {
        String newLocation;
        System.out.println("Введите новое местоположение посылок с трэкингом");
        newLocation = scanner.nextLine();

        for (Trackable thisparcel : trackableParcels) {
            thisparcel.reportStatus(newLocation);


        }


    }

    public static void error1() {
        System.out.println("Ошибка 1. Данные не корректны. Добавление посылки невозможно.");
    }


}

