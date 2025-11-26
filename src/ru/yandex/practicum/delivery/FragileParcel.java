package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel implements Trackable {

    static final Integer coastFragile = 4; //стоимость хрупкой посылки // Исправлено по замечанию ревьюера

    public FragileParcel(String description, Integer weight, String deliveryAddress, Integer sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }


    @Override
    public void reportStatus(String location) {

        System.out.println("Хрупкая посылка " + getDescription() + " изменила положение на " + location);

    }

    @Override   // Переопределил по замечанию ревьюера. Так гораздо лучше стало!
    public void packageItem() {
        System.out.println("Хрупкая посылка " + getDescription() + " упакована");
        System.out.println("Хрупкая посылка " + getDescription() + " упакована в защитную плёнку");
    }

    @Override  //Переопределил по замечанию ревьюера. Стало лучше.
    public Integer calculateDeliveryCost() {
        return getWeight() * coastFragile;
    }

    public static Integer getCoastFragile() {
        return coastFragile;
    }



}
