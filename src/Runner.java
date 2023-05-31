import task.Purchase;
import task.WeekDay;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Runner {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("src/in.txt"));

        final int PURCHASES_NUMBER = Integer.parseInt(reader.readLine());
        Purchase[] purchases = new Purchase[PURCHASES_NUMBER];

        for (int i = 0; i < PURCHASES_NUMBER; i++) {
            String[] line = reader.readLine().split(" ");
            String productName = line[0];
            int price = Integer.parseInt(line[1]);
            int numberOfUnits = Integer.parseInt(line[2]);
            int discountPercent = Integer.parseInt(line[3]);
            WeekDay weekDay = WeekDay.values()[Integer.parseInt(line[4])];

            purchases[i] = new Purchase(productName, price, numberOfUnits, discountPercent, weekDay);
        }

        reader.close();

        System.out.println("class constants");
        Arrays.stream(purchases).forEach(System.out::println);

        double totalCost = Arrays.stream(purchases)
                .mapToDouble(Purchase::getCost)
                .sum();
        double averageCost = totalCost / PURCHASES_NUMBER;
        double totalCostOnMonday = Arrays.stream(purchases)
                .filter(purchase -> purchase.getWeekDay() == WeekDay.MONDAY)
                .mapToDouble(Purchase::getCost)
                .sum();

        System.out.printf("Average cost of all purchases: %.3f\n", averageCost);
        System.out.printf("Total cost of all purchases on Monday: %.2f\n", totalCostOnMonday);

        Purchase mostExpensivePurchase = Arrays.stream(purchases)
                .max(Comparator.comparingInt(Purchase::getCost))
                .get();
        System.out.println("Day with the maximum purchase cost: " + mostExpensivePurchase.getWeekDay());

        Arrays.sort(purchases);

        System.out.println("class constants");
        Arrays.stream(purchases).forEach(System.out::println);

        Purchase purchaseWithFiveUnits = new Purchase("", 0, 5, 0, WeekDay.MONDAY);
        int index = Arrays.binarySearch(purchases, purchaseWithFiveUnits);

        if (index >= 0) {
            System.out.println("Found purchase with 5 units: " + purchases[index]);
        } else {
            System.out.println("Purchase with 5 units not found");
        }
    }
}
