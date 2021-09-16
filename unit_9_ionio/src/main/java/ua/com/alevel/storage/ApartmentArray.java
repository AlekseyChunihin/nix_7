package ua.com.alevel.storage;

import ua.com.alevel.entity.Apartment;

public class ApartmentArray {

    private static final int SIZE = 10;
    int current;
    Apartment[] apartments;

    public ApartmentArray() {
        current = 0;
        apartments = new Apartment[SIZE];
    }

    public void add(Apartment apartment) {
        if (current == apartments.length - 1) {
            Apartment[] tmp = new Apartment[apartments.length + SIZE];
            for (int i = 0; i < apartments.length; i++) {
                tmp[i] = apartments[i];
            }
            apartments = tmp;
        }
        apartments[current] = apartment;
        current++;
    }

    public void delete(String id) {
        int i;
        for (i = 0; i < current; i++) {
            if (apartments[i].getId().equals(id)) {
                break;
            }
        }
        for (int j = i; j < current; j++) {
            apartments[j] = apartments[j + 1];
        }
        current--;
    }

    public Apartment get(int i) {
        return apartments[i];
    }

    public int size() {
        return current;
    }
}
