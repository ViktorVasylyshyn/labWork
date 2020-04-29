package lab4;

public abstract class FreightCarrier {
    int capacity;
    int price;
    String carrierName;

    public void definePriceOfTransportation() {
        System.out.println("Total price of transportation by " + carrierName + " is " + capacity * price + "$");
    }
}
