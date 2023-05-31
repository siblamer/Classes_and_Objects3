package task;

public class Purchase implements Comparable<Purchase> {
    private String productName;
    private int price;
    private int numberOfUnits;
    private int discountPercent;
    private WeekDay weekDay;

    public Purchase() {
        this.productName = "";
        this.price = 0;
        this.numberOfUnits = 0;
        this.discountPercent = 0;
        this.weekDay = WeekDay.MONDAY;
    }

    public Purchase(String productName, int price, int numberOfUnits, int discountPercent, WeekDay weekDay) {
        this.productName = productName;
        this.price = price;
        this.numberOfUnits = numberOfUnits;
        this.discountPercent = discountPercent;
        this.weekDay = weekDay;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(int numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    public int getCost() {
        return price * numberOfUnits * (100 - discountPercent) / 100;
    }

    @Override
    public String toString() {
        return productName + ";" + price + ";" + numberOfUnits + ";" + discountPercent + ";" + weekDay + ";" + getCost();
    }

    @Override
    public int compareTo(Purchase purchase) {
        return numberOfUnits - purchase.getNumberOfUnits();
    }
}