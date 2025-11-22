package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Parcel> allParcels = new ArrayList<>();

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
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() { //Создать посылку.

        System.out.println("Укажите описание посылки: ");
        String description = scanner.nextLine();

        System.out.println("Сообщите нам адрес доставки посылки: ");
        String address = scanner.nextLine();

        System.out.println("Укажите вес посылки в кг (целое число): ");
        Integer weight = Integer.parseInt(scanner.nextLine());

        System.out.println("Укажите день отправки посылки (номер дня месяца): ");
        Integer sendDay = Integer.parseInt(scanner.nextLine());


        System.out.println("Укажите тип посылки: 1 - Стандартная; 2 - Хрупкая; 3 - Скоропортящаяся");

        int type = Integer.parseInt(scanner.nextLine());

        switch (type) { //cоздаем и добавляем в ArrayList
            case 1:
                StandartParcel standartParcel1 = new StandartParcel(description, weight, address, sendDay);
                allParcels.add(standartParcel1);
                break;
            case 2:
                FragileParcel fragileParcel1 = new FragileParcel(description, weight, address, sendDay);
                allParcels.add(fragileParcel1);
                break;
            case 3:
                System.out.println("Укажите срок годности вашей послыки в днях: ");
                Integer timeToLive = Integer.parseInt(scanner.nextLine());
                PerishableParcel perishableParcel1 = new PerishableParcel(description, weight, address, sendDay, timeToLive);
                allParcels.add(perishableParcel1);
                break;
            case 0:

                break;
            default:
                System.out.println("Неверный выбор.");
        }



        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
    }

    private static void sendParcels() {

        for (Parcel thisparcel : allParcels){
            thisparcel.packageItem();
            thisparcel.deliver();

        }


        // Пройти по allParcels, вызвать packageItem() и deliver()
    }

    private static void calculateCosts() {
        int sum = 0;
        for(Parcel thisparcel : allParcels){
            sum += thisparcel.calculateDeliveryCost();

        }

        System.out.println("Общая стоимость доставки всех посылок составит: " + sum + " рублей" );

        // Посчитать общую стоимость всех доставок и вывести на экран
    }

}

