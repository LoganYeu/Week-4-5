
/**
 * Defines what a order is and allows user to add features to order .
 *
 * @author (Logan Yeubanks)
 * @version (Version 1)
 */
import java.util.ArrayList;
public class Order
{
    // instance variables - replace the example below with your own
    private String design;
    private ArrayList<Integer> features;

    /**
     * Constructor for objects of class Order
     */
    public Order(String design)
    {
        // initialise instance variables
        this.design = design;
        features = new ArrayList<Integer>();
    }
    
    
    /*
     * adds feature to the order
     */
    public boolean addFeature(int feature)
    {
        if(!features.contains(feature) && feature <= 5 && feature >= 1)
        {
            features.add(feature);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /*
     * prints order information such as design and features
     */
    public void printOrderInfo()
    {
        System.out.println("Design chosen: " + design);
        System.out.println("Features chosen: " + features.toString());
        
    }
}