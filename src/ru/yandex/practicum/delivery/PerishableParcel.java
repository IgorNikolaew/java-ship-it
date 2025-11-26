package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {
    private Integer timeToLive;
    static final Integer coastPerishable = 3; //стоимость посылки со сроком годности // Исправлено по замечанию ревьюера

    public PerishableParcel(String description, Integer weight, String deliveryAddress, Integer sendDay, Integer timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    public static Integer getCoastPerishable() {
        return coastPerishable;
    }

    @Override   // Переопределил по замечанию ревьюера. Так гораздо лучше стало!
    public void packageItem() {
        System.out.println("Посылка со сроком годности " + getDescription() + " упакована");

    }

    @Override  //Переопределил по замечанию ревьюера. Стало лучше.
    public Integer calculateDeliveryCost() {
        return getWeight() * coastPerishable;
    }

    //Метод только у скоропортящихся посылок

    public Integer getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(Integer timeToLive) {
        this.timeToLive = timeToLive;
    }

    public boolean isExpired(Integer currentDay) {
        return (getSendDay() + timeToLive <= currentDay); //false - посылка не испортилась
        // true - испортилась


    }


}
