package drugstore;

import drugstore.components.Penicillin;
import drugstore.components.Salt;
import drugstore.components.Water;

import java.util.*;


public class MainApp {
    public static void main(String[] args) {
        Pharmacy helpirin = new Pharmacy("helpirin");
        Pharmacy safirin = new Pharmacy("safirin");
        Pharmacy curin = new Pharmacy("curin");

        helpirin
                .addComponent(new Penicillin("PenicillinH", 10, 100))
                .addComponent(new Water("WaterH", 20, 15))
                .addComponent(new Salt("SaltH", 50, 50));

        safirin
                .addComponent(new Penicillin("PenicillinS", 5, 80))
                .addComponent(new Water("WaterS", 10, 10))
                .addComponent(new Salt("SaltS", 3, 300));
        curin
                .addComponent(new Penicillin("PenicillinS", 25, 120))
                .addComponent(new Water("WaterS", 30, 25))
                .addComponent(new Salt("SaltS", 7, 70));

        List<Pharmacy> pharmacies = new ArrayList<>();
        pharmacies.add(helpirin);
        pharmacies.add(safirin);
        pharmacies.add(curin);

        getPharmaciesSortedByInterPower(pharmacies);

        getPharmaciesSortedByTotalPower(pharmacies);

        getPharmaciesSortedByTotalWeight(pharmacies, new PharmacyComparator());

        // Можно избавиться от статики в клиентском коде, например с помощью интерфейса
        System.out.println("\nSort via interface\n");

        final Sorter sorter = ph -> {
            Collections.sort(ph);
            System.out.println(ph);
        };

        sorter.getPharmaciesSortedByInterPower(pharmacies);
        sorter.getPharmaciesSortedByTotalPower(pharmacies);
        sorter.getPharmaciesSortedByTotalWeight(pharmacies);
    }

    private static void getPharmaciesSortedByInterPower(List<Pharmacy> pharmacies) {
        Collections.sort(pharmacies);
        System.out.println(pharmacies);
    }

    private static void getPharmaciesSortedByTotalPower(List<Pharmacy> pharmacies) {
//        pharmacies.sort((ph1, ph2) -> Integer.compare(ph1.getTotalPower(), ph2.getTotalPower()));
        pharmacies.sort(Comparator.comparingInt(Pharmacy::getTotalPower));
        System.out.println(pharmacies);
    }

    private static void getPharmaciesSortedByTotalWeight(List<Pharmacy> pharmacies, Comparator<Pharmacy> comparator) {
        pharmacies.sort(comparator);
        System.out.println(pharmacies);
    }
}