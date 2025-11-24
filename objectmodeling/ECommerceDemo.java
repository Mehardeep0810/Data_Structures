package Assignment.objectmodeling;

import java.util.*;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}

class Order {
    private int orderId;
    private Customer customer; 
    private List<Product> products;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void showOrderDetails() {
        System.out.println("Order ID: " + orderId + " placed by " + customer.getName());
        if (products.isEmpty()) {
            System.out.println("  No products in this order.");
        } else {
            double total = 0;
            for (Product p : products) {
                System.out.println("  - " + p);
                total += p.getPrice();
            }
            System.out.println("Total Amount: $" + total);
        }
    }
}

class Customer {
    private String name;
    private List<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public String getName() { return name; }

    public Order placeOrder(int orderId) {
        Order newOrder = new Order(orderId, this);
        orders.add(newOrder);
        System.out.println(name + " placed Order ID " + orderId);
        return newOrder;
    }

    public void showOrders() {
        System.out.println("Orders for Customer: " + name);
        if (orders.isEmpty()) {
            System.out.println("  No orders placed.");
        } else {
            for (Order o : orders) {
                o.showOrderDetails();
            }
        }
    }
}

public class ECommerceDemo {
    public static void main(String[] args) {

        Product p1 = new Product("Laptop", 800.0);
        Product p2 = new Product("Smartphone", 500.0);
        Product p3 = new Product("Headphones", 100.0);

        Customer c1 = new Customer("Mehardeep");

        Order o1 = c1.placeOrder(101);
        o1.addProduct(p1);
        o1.addProduct(p3);

        Order o2 = c1.placeOrder(102);
        o2.addProduct(p2);
        
        c1.showOrders();
    }
}

