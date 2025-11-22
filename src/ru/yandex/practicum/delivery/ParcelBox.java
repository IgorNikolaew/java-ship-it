package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ParcelBox <T extends Parcel>{
    private String  nameOfBox;
    private Integer currentWeight;
    private Integer maxWeight;
    private List<T> box;



    public String getNameOfBox() {
        return nameOfBox;
    }

    public void setNameOfBox(String nameOfBox) {
        this.nameOfBox = nameOfBox;
    }

    public Integer getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(Integer currentWeight) {
        this.currentWeight = currentWeight;
    }

    public Integer getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Integer maxWeight) {
        this.maxWeight = maxWeight;
    }

    public List<T> getBox() {
        return box;
    }

    public void setBox(List<T> box) {
        this.box = box;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ParcelBox<?> parcelBox = (ParcelBox<?>) o;
        return Objects.equals(nameOfBox, parcelBox.nameOfBox) && Objects.equals(currentWeight, parcelBox.currentWeight) && Objects.equals(maxWeight, parcelBox.maxWeight) && Objects.equals(box, parcelBox.box);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfBox, currentWeight, maxWeight, box);
    }

    public ParcelBox(String nameOfBox, Integer currentWeight, Integer maxWeight) {
        this.nameOfBox = nameOfBox;
        this.currentWeight = currentWeight;
        this.maxWeight = maxWeight;
        this.box = new ArrayList<>();
    }

    public void addParcel(T parcel){

        if ((currentWeight + parcel.getWeight()) < maxWeight ) {
            box.add(parcel);
            System.out.println("Посылка" + parcel.getDescription() + " добавлена в коробку " + getNameOfBox());
        }
        else {System.out.println("X - Добавление посылки в коробку невозможно, так как будет превышен максимальный вес коробки");
        }

    }

    public void getAllParcels(){ // достает ВСЕ посылки из коробки и оставляет её пустой
        System.out.println("Из коробки " + getNameOfBox()+ " получены посылки: " );

        for(T thisparcel : box){
            System.out.println("Послыка " + thisparcel.getDescription() + " получена из коробки");
            box.remove(thisparcel);
                    }

        System.out.println("Теперь коробка " + getNameOfBox() + " пустая." );

    }

    public void viewAllParcelsInBox(){ //показывает посылки, находящиеся в коробке

        System.out.println("В коробке " + getNameOfBox() + " находится " + box.size() + " посылок: "  );

        for(T thisparcel : box){
            System.out.println("Послыка " + thisparcel.getDescription() );

        }


    }




}
