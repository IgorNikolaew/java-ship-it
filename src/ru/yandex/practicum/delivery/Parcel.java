package ru.yandex.practicum.delivery;

import java.util.Objects;

public abstract class Parcel {
    //добавьте реализацию и другие необходимые классы
    private String description;
    private Integer weight;
    private String deliveryAddress;
    private Integer sendDay;

    private static final Integer coastStandart = 2;
    private static final Integer coastPerishable = 3;
    private static final Integer coastFragile = 4;

    public Parcel(String description, Integer weight, String deliveryAddress, Integer sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }
    // Prepare class. Equals, hashcode, get, set methods.***

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Parcel parcel = (Parcel) o;
        return Objects.equals(description, parcel.description) && Objects.equals(weight, parcel.weight) && Objects.equals(deliveryAddress, parcel.deliveryAddress) && Objects.equals(sendDay, parcel.sendDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, weight, deliveryAddress, sendDay);
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Integer getSendDay() {
        return sendDay;
    }

    public void setSendDay(Integer sendDay) {
        this.sendDay = sendDay;
    }

    //Methods ***


    public void packageItem() { // напечатает разное для разного имени класса объекта
        // потому, что в задании просили избежать дублирования кода

        switch ((getClass().getSimpleName())) { // getClass().getSimpleName() метод возвращает строку только с именем класса
            case "StandartParcel":
                System.out.println("Посылка " + description + " упакована");
                break;
            case "FragileParcel":
                System.out.println("Посылка " + description + " упакована");
                System.out.println("Посылка " + description + " упакована в защитную плёнку");
                break;
            case "PerishableParcel":
                System.out.println("Посылка " + description + " упакована");
                break;
            default:
                System.out.println("Тип посылки неизвестен, упаковка стандартная. " + description + " ");
                break;
        }
    }

    public void deliver() { //Доставка
        System.out.println("Посылка " + description + " доставлена по адресу " + deliveryAddress);

    }

    public Integer calculateDeliveryCost() { //посчитает стоимость согласно имени класса объекта
        if (getClass().getSimpleName().equals("StandartParcel")) {
            return weight * coastStandart;
        }
        if (getClass().getSimpleName().equals("PerishableParcel")) {
            return weight * coastPerishable;
        }
        if (getClass().getSimpleName().equals("FragileParcel")) {
            return weight * coastFragile;
        }

        return 0;
    }

    public static boolean checkUserEnter(Parcel obj){ // метод проверки введенных данных
        if (obj.getDescription() == null ||
             obj.getDescription().isEmpty()   ||
                obj.getDeliveryAddress() == null ||
                obj.getDeliveryAddress().isEmpty() ||
                obj.getWeight() <=0 ||
                obj.getSendDay() <=0) {
            return false;
        }   else {return true;}
    }


};







