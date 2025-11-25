package ru.yandex.practicum.delivery;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParcelTest {

    @Test
    void checkUserEnter_ValidParcel_ReturnsTrue() {
        StandartParcel parcel = new StandartParcel("Valid", 5, "Address", 1);
        assertTrue(Parcel.checkUserEnter(parcel));
    }

    @Test
    void checkUserEnter_EmptyDescription_ReturnsFalse() {
        StandartParcel parcel = new StandartParcel("", 5, "Address", 1);
        assertFalse(Parcel.checkUserEnter(parcel));
    }

    @Test
    void checkUserEnter_NullAddress_ReturnsFalse() {
        StandartParcel parcel = new StandartParcel("Valid", 5, null, 1);
        assertFalse(Parcel.checkUserEnter(parcel));
    }

    @Test
    void checkUserEnter_ZeroWeight_ReturnsFalse() {
        StandartParcel parcel = new StandartParcel("Valid", 0, "Address", 1);
        assertFalse(Parcel.checkUserEnter(parcel));
    }
}


class PerishableParcelTest {

    @Test
    void isExpired_NotExpired_ReturnsFalse() {
        PerishableParcel parcel = new PerishableParcel("Test", 1, "Address", 1, 5);
        // sendDay=1, TTL=5, expires on day 6
        assertFalse(parcel.isExpired(5)); // day 5 < 6 - не испортилась
    }

    @Test
    void isExpired_Expired_ReturnsTrue() {
        PerishableParcel parcel = new PerishableParcel("Test", 1, "Address", 1, 5);
        // sendDay=1, TTL=5, expires on day 6
        assertTrue(parcel.isExpired(6)); // day 6 >= 6 - испортилась
    }

    @Test
    void isExpired_ExpiredNextDay_ReturnsTrue() {
        PerishableParcel parcel = new PerishableParcel("Test", 1, "Address", 1, 5);
        assertTrue(parcel.isExpired(7)); // day 7 > 6 - испортилась
    }
}

class DeliveryCostTest {

    @Test
    void calculateDeliveryCost_StandardParcel_ReturnsCorrectCost() {
        StandartParcel parcel = new StandartParcel("Test", 10, "Address", 1);
        assertEquals(20, parcel.calculateDeliveryCost()); // 10 * 2 = 20
    }

    @Test
    void calculateDeliveryCost_PerishableParcel_ReturnsCorrectCost() {
        PerishableParcel parcel = new PerishableParcel("Test", 10, "Address", 1, 5);
        assertEquals(30, parcel.calculateDeliveryCost()); // 10 * 3 = 30
    }

    @Test
    void calculateDeliveryCost_FragileParcel_ReturnsCorrectCost() {
        FragileParcel parcel = new FragileParcel("Test", 10, "Address", 1);
        assertEquals(40, parcel.calculateDeliveryCost()); // 10 * 4 = 40
    }
}








