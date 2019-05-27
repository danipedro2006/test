package main.advanced.lambda;

public class Product {

    private String name;
    private int warranty;
    private float price;

    public Product(String name, int warranty, float price) {

        this.name = name;
        this.warranty = warranty;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getWarranty() {
        return warranty;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s - warranty: %s; price: %s",
                name, warranty, price);
    }
}
