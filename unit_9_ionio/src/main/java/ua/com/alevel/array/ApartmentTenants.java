package ua.com.alevel.array;

public class ApartmentTenants {

    int current;
    String[] tenantsId;

    public ApartmentTenants(int size) {
        tenantsId = new String[size + 1];
        current = 0;
    }

    public void add(String tenantId) {
        tenantsId[current] = tenantId;
        current++;
    }

    public void delete(String tenantId) {
        int i;
        if (current == 0) {
            System.out.println("This apartment is empty.");
        } else {
            for (i = 0; i < current; i++) {
                if (tenantsId[i].equals(tenantId)) {
                    break;
                }
            }
            if (i == current) {
                System.out.println("This apartment does not have a tenant with this id");
                return;
            }
            for (int j = i; j < current; j++) {
                tenantsId[i] = tenantsId[i + 1];
            }
            current--;
        }
    }

    public boolean find(String tenantId) {
        if (current == 0) {
            return false;
        }
        for (int i = 0; i < current; i++) {
            if (tenantsId[i].equals(tenantId)) {
                return true;
            }
        }
        return false;
    }

    public int amountOfTenants() {
        return current;
    }

    public int amountOfFreeSpaceInApartment() {
        return (tenantsId.length - 1) - amountOfTenants();
    }
}
