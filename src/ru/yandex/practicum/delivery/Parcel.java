package ru.yandex.practicum.delivery;

import java.util.Objects;

public abstract class Parcel {
           //добавьте реализацию и другие необходимые классы
    private String description;
    private Double weight;
    private String deliveryAddress;
    private String sendDay;

    public Parcel(String description, Double weight, String deliveryAddress, String sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }
    // Prepare class. Equals, hashcode, get, set methods.
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

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getSendDay() {
        return sendDay;
    }

    public void setSendDay(String sendDay) {
        this.sendDay = sendDay;
    }

    //Methods

    public void packageItem(){}

    public void deliver(){}

    public Double calculateDeliveryCost(){
        return 0.0;
    }





}
