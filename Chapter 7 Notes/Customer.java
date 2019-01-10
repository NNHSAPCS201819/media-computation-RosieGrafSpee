
/**
 * Write a description of class Customer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Customer
{
    // instance variables - replace the example below with your own
    private int value;
    private String name;
    
    /**
     * Constructor for objects of class Customer
     */
    public Customer(String name)
    {
        // initialise instance variables
        this.name = name;
    }
    
    public Customer (String name, int price)
    {
        this(name);
        this.addPurchase(price);
    }
    
    public void addPurchase(int price)
    {
        this.value += price;
    }
    
    public String toString()
    {
        return this.name + ": " + this.value + " ";
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public int getAmount()
    {
        return this.value;
    }
}
