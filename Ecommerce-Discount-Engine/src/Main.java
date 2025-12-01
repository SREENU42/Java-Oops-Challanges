// 8️⃣ E-commerce Discount Engine
// Base class Product:
// •	name, price
// Subclasses:
// •	Electronics → 15% discount
// •	Clothing → 10% discount
// •	Grocery → 5% discount
// Method:
// •	getDiscountedPrice() (override in each)
// Task:
// Given a cart of mixed products → print final bill using polymorphism.


import java.util.*;
import java.lang.*;

class Product{
    String name;
    double price;

    Product(String name, double price){
        this. name = name;
        this. price = price;
    }

    double getDiscountedPrice() {
        return price;
    }
}
class Electronics extends Product {
    Electronics (String name, double price) {
        super(name, price);
    }

    @Override
    double getDiscountedPrice(){
        return price - (price * 0.15);
    }
}

class Clothing extends Product {
    Clothing (String name, double price) {
        super(name, price);
    }

    @Override
     double getDiscountedPrice() {
        return price - (price * 0.10);
    }
}

class Grocery extends Product {
    Grocery(String name, double price) {
        super(name, price);
    }

    @Override
    double getDiscountedPrice() {
        return price-(price*0.05);
    }

}

public class Main{
    public static void main (String[] args) {

        List <Product> cart= new ArrayList<>();

        cart.add(new Electronics("Mouse", 200.0));
        cart.add(new Clothing("Jeans Pant", 1000.0));
        cart.add(new Grocery("Tooth Brush &Paste", 100.0));

        double total = 0;

        for(Product p: cart) {
            System.out.println("===========================");
            System.out.println("Product Name: "+p.name);
            System.out.println("Product price: "+p.price);
            System.out.println("Discounted Price: "+p.getDiscountedPrice());

            total += p.getDiscountedPrice();
        }

        System.out.println("===============================");
        System.out.println("Finall Bill Amount: "+ total);

    }
}
