
/**
 * Defines what a customer is and gives method to print them.
 *
 * @author (Logan Yeubanks)
 * @version (Version 1)
 */
import java.util.ArrayList;
public class Customer
{
    // instance variables
    private ArrayList<Order> orders;
    private String lastName;
    private String firstName;
    private int idNumber;
    private String companyName; 
    private String address;
    private String city;
    private String state;
    private int zip;
    private String phoneNumber;
    
    /**
     * Constructor for objects of class Customer
     */
    public Customer(String lastName, String firstName, int idNumber, String companyName, String address, String city, String state, int zip, String phoneNumber)
    {
    // initialise instance variables
    orders = new ArrayList<Order>();
    this.lastName = lastName;
    this.firstName = firstName;
    this.idNumber = idNumber;
    this.companyName = companyName;
    this.address = address;
    this.city = city;
    this.state = state;
    this.zip = zip;
    this.phoneNumber = phoneNumber;
    }
    
    
    /*
     * adds a order to a list 
     */
    public void storeOrder(Order order)
    {
        orders.add(order);
    }
    
    
    /*
     * returns idNumber
     * 
     * @return idNumber
     */
    public int getIdNumber()
    {
        return idNumber;
    }
    
    
    /*
     * prints a series of print statements related to a recipet/bill of sale
     */
    public void printCustomerInfo()
    {
        System.out.println("Customer Id number: " + idNumber);
        System.out.println("Last name: " + lastName);
        System.out.println("First name: " + firstName);
        System.out.println("Company name: " + companyName);
        System.out.println("Address: " + address);
        System.out.println("City: " + city + ", State: " + state + ", Zip Code: " + zip);
        System.out.println("Phone number: " + phoneNumber);
    }
}
