package Vehicle;

public class Main {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Maruti", "Red");
        Vehicle v2 = new Car("BMW","Black", "Petrol");
        Vehicle v3 = new Ev("BENz", "WHITE", "Diesel",6500);

        v1.getInfo();
        v2.getInfo();
        v3.getInfo();
    }
    
}
class Vehicle {
    private String brand;
    private String color;

    public Vehicle(String brand, String color){
        this.brand=brand;
        this.color=color;
    }

    public String getBrand(){
        return brand;
    }
    public String getColor(){
        return color;
    }

    public void getInfo(){
        System.err.println("Brand: "+ brand+", Color:"+color);
    }

}

class Car extends Vehicle{
    private String variant;

    public Car(String brand, String color, String variant){
        super(brand,color);
        this.variant= variant;
    }

    @Override
    public void getInfo(){
        System.err.println("This is a car of"+getBrand()+" brand,"+variant+" variant,"+getColor()+" color Car");
    }
}
class Ev extends Car{
    private int Volt;

    public Ev(String brand, String color, String variant, int Volt){
        super(brand,color,variant);
        this.Volt= Volt;
    }

    @Override
    public void getInfo(){
        System.err.println("This is a car of"+getBrand()+" brand,"+Volt+" Volt,"+getColor()+" color Car");
    }
}