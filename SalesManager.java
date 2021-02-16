
/**
 * Manages all the site's customers and sales and gives.
 *
 * @author (Logan Yeubanks)
 * @version (Version 1)
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Random;
public class SalesManager
{
    // instance variables
    private ArrayList<Customer> customers;
    private HashSet<Integer> idNumbers;
    private Random rand;
    private HashMap<String, ArrayList<Integer>> pricingTable;
    

    /**
     * Constructor for objects of class SalesManager
     */
    public SalesManager()
    {
        // initialise instance variables
        customers = new ArrayList<Customer>();
        idNumbers = new HashSet<Integer>();
        rand = new Random();
        pricingTable = new HashMap<String, ArrayList<Integer>>();
        populateTable();
        
    }
    
    /*
     * adds a customer to the ArrayList customers
     */
    public void addCustomer(String lastName, String firstName, String companyName, String address, String city, String state, int zip, String phoneNumber)
    {
        int idNumber = generateIdNumber();
        Customer currentCustomer = new Customer(lastName, firstName, idNumber, companyName, address, city, state, zip, phoneNumber);
        customers.add(currentCustomer);
        System.out.println("Your id number is: " + idNumber);
    }
    
    
    /*
     * generates a random id number that can only be 5 digits in length
     * 
     * @return idNumber
     */
    private int generateIdNumber()
    {   
        int idNumber = 0;
        final int idUpperBound = 100000;
        final int idLowerBound = 10000;
        do
        {
             idNumber = rand.nextInt(idUpperBound - idLowerBound) + idLowerBound;
        } while (idNumbers.contains(idNumber)); 
        
        idNumbers.add(idNumber);
        return idNumber;
    }
    
    
    /*
     * populates the hash map called pricingTable with mappings of base design prices and feature prices
     */
    private void populateTable()
    {
        //Adding base designs and feature prices to the pricing table hash map.
        String design = "Nature";
        ArrayList<Integer> featurePrices = new ArrayList<Integer>();
        //base price for nature design
        featurePrices.add(200);
        //price of features 1-5 for nature design
        featurePrices.add(10);
        featurePrices.add(15);
        featurePrices.add(20);
        featurePrices.add(25);
        featurePrices.add(30);
        //maps design to the list of feature prices shown above
        pricingTable.put(design, featurePrices);
        
        
        design = "Tech";
        featurePrices = new ArrayList<Integer>();
        //base price for tech design
        featurePrices.add(350);
        //price of features 1-5 for tech design
        featurePrices.add(20);
        featurePrices.add(30);
        featurePrices.add(40);
        featurePrices.add(50);
        featurePrices.add(60);
        //maps design to the list of feature prices shown above
        pricingTable.put(design, featurePrices);
        
        
        design = "Business";
        featurePrices = new ArrayList<Integer>();
        //base price for business design
        featurePrices.add(375);
        //prices of features 1-5 for business design
        featurePrices.add(30);
        featurePrices.add(40);
        featurePrices.add(50);
        featurePrices.add(60);
        featurePrices.add(70);
        //maps design to the list of feature prices shown above
        pricingTable.put(design, featurePrices);
        
        
        design = "Music";
        featurePrices = new ArrayList<Integer>();
        //base price for music design
        featurePrices.add(400);
        //prices of features 1-5 for music design
        featurePrices.add(85);
        featurePrices.add(95);
        featurePrices.add(110);
        featurePrices.add(130);
        featurePrices.add(210);
        //maps design to the list of feature prices shown above
        pricingTable.put(design, featurePrices);
        
        
        design = "Naughty";
        featurePrices = new ArrayList<Integer>();
        //base price for naughty design
        featurePrices.add(500);
        //prices of features 1-5 for naughty design
        featurePrices.add(100);
        featurePrices.add(200);
        featurePrices.add(300);
        featurePrices.add(400);
        featurePrices.add(500);
        //maps design to the list of feature prices shown above
        pricingTable.put(design, featurePrices);
        
    }
    
    
    public void placeOrder(int customerID, String design, ArrayList<Integer> features)
    {
        Customer currentCustomer = null;
        //checks if any customers stored have the id number passed in
        for(Customer c : customers)
        {
            if (c.getIdNumber() == customerID)
            {
                currentCustomer = c;
            }
        }
        
        //returns nothing if the customer does not exist
        if(currentCustomer == null) 
        {
            return;   
        }
        
        //returns nothing if the design selection is not valid
        if(!pricingTable.containsKey(design))
        {
            return;
        }
        
        Order currentOrder = new Order(design);
        // gets the base price of whatever design passed in
        int totalPrice = pricingTable.get(design).get(0);
        for(int f : features)
        {
            if (currentOrder.addFeature(f))
            {
                totalPrice += pricingTable.get(design).get(f);
            }
        }
        // takes order and stores in the customer object
        currentCustomer.storeOrder(currentOrder);
        //prints the bill of sale
        printBillOfSale(currentCustomer, currentOrder, totalPrice);
        
        
    }
    
    
    /*
     * method to print all details neccasary on the receipt/bill of sale.
     * 
     */
    private void printBillOfSale(Customer customer, Order chosenFeatures, int finalPrice)
    {
        customer.printCustomerInfo();
        chosenFeatures.printOrderInfo();
        System.out.println("Grand total: " + finalPrice);
    }
}
