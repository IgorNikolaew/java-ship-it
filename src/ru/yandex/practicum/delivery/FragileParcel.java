package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel implements Trackable {
    public FragileParcel(String description, Integer weight, String deliveryAddress, Integer sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }


    @Override
    public void reportStatus(String location) {

        System.out.println("Хрупкая посылка "+ getDescription() + " изменила положение на " + location);
    }
}
