package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {
    private Integer timeToLive;

    public PerishableParcel(String description, Integer weight, String deliveryAddress, Integer sendDay, Integer timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    //Метод только у скоропортящихся посылок

    public Integer getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(Integer timeToLive) {
        this.timeToLive = timeToLive;
    }

    public boolean isExpired(Integer currentDay) {
        return (getSendDay() + timeToLive > currentDay); //false - посылка не испортилась
        // true - испортилась


    }


}
