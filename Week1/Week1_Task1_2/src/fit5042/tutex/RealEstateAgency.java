package fit5042.tutex;

import fit5042.tutex.repository.PropertyRepository;
import fit5042.tutex.repository.PropertyRepositoryFactory;
import fit5042.tutex.repository.entities.Property;
import java.util.Scanner;

/**
 *
 * TODO Exercise 1.3 Step 3 Complete this class. Please refer to tutorial instructions.
 * This is the main driver class. This class contains the main method for Exercise 1A
 * 
 * This program can run without the completion of Exercise 1B.
 * 
 * @author Jian
 * @author Zeeshan Khan
 */
public class RealEstateAgency {
    private String name;
    private final PropertyRepository propertyRepository;
    
    public RealEstateAgency(String name) throws Exception {
        this.name = name;
        this.propertyRepository = PropertyRepositoryFactory.getInstance();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    private void generateProperties() {
        try {
            this.propertyRepository.addProperty(new Property(1, "24 Boston Ave, Malvern East VIC 3145, Australia", 2, 150, 420000));
            this.propertyRepository.addProperty(new Property(2, "11 Bettina St, Clayton VIC 3168, Australia", 3, 352, 360000));
            this.propertyRepository.addProperty(new Property(3, "3 Wattle Ave, Glen Huntly VIC 3163", 5, 800, 650000));
            this.propertyRepository.addProperty(new Property(4, "3 Hamilton St, Bentleigh VIC 3204, Australia", 2, 170, 435000));
            this.propertyRepository.addProperty(new Property(5, "82 Spring Rd, Hampton East VIC 3188, Australia", 1, 60, 820000));
            
            System.out.println(this.propertyRepository.getAllProperties().size() + " properties added successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void printProperties() {
        try {
            for (Property property : this.propertyRepository.getAllProperties()) {
                System.out.println(property.toString());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void searchProperty(String message) {
        System.out.print(message + ": ");
        
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        
        try {
            System.out.println(this.propertyRepository.searchPropertyById(id).toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void run() {
        this.generateProperties();
        System.out.println("***********************************************************************************");
        this.printProperties();
        System.out.println("***********************************************************************************");
        this.searchProperty("Enter the ID of the property you want to search");
    }
    
    public static void main(String[] args) {
        try {
            new RealEstateAgency("Monash Real Estate Agency").run();
        } catch (Exception e) {
            System.out.println("Failed to run application: " + e.getMessage());
        }
    }
}
