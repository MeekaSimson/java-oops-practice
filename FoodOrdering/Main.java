package FoodOrdering;

import java.util.*;

public class Main {
   public static void main(String[] args) {
      FoodItem f1 = new VegItem(0, "Panneer", 250, 12);
      FoodItem f2 = new NonVegItem(2, "Chicken Biryani", 300, 50);

      Order order = new Order();
      order.addItem(f1);
      order.addItem(f2);
      order.calculateTotal();
   }

}

abstract class FoodItem{
   private int id;
   private String name;
   protected double price;

   FoodItem(int id, String name, double price){
      this.id=id;
      this.name=name;
      this.price = price;
   }
   public abstract double getFinalPrice();
   
}
class VegItem extends FoodItem{
   private int discount;
   
   VegItem(int id, String name, double price,int discount){
      super(id, name, price);
      this.discount=discount;
   }
   @Override
   public double getFinalPrice(){
      return price - (price * discount/100);
   }
}
class NonVegItem extends FoodItem{
   private double extraCharge;

   NonVegItem(int id, String name, double price,double extraCharge){
      super(id, name, price);
      this.extraCharge=extraCharge;
   }
   @Override
   public double getFinalPrice(){
      return price + extraCharge;
   }
}
class Order{
   private List<FoodItem> items = new ArrayList<>();

   public void addItem(FoodItem item){
      items.add(item);
   }
   public void calculateTotal (){
      double total = 0;
      for(FoodItem item : items){
         total += item.getFinalPrice();
      }
      System.out.println("Total Price "+total);
   }
   }
