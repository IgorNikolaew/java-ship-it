package ru.yandex.practicum.delivery;

public class StandartParcel extends Parcel {

   private static final Integer coastStandart = 2; //стоимость стандартной посылки // Исправлено по замечанию ревьюера

    public StandartParcel(String description, Integer weight, String deliveryAddress, Integer sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    public static Integer getCoastStandart() {
        return coastStandart;
    }

    @Override   // Переопределил по замечанию ревьюера. Так гораздо лучше стало!
    public void packageItem() {
        System.out.println("Посылка стандартная " + getDescription() + " упакована");

    }

    @Override  //Переопределил по замечанию ревьюера. Стало лучше.
    public Integer calculateDeliveryCost() {
        return getWeight() * coastStandart;
    }
}
