import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class ApplianceLookup {
    public static void main(String[] args){

        //file path for the appliances
        String filePath = "appliances.csv"; 
        BufferedReader reader = null;
        String line = "";

        //bool to see if application is closed
        boolean isRunning = true;

        //initialise the tree
        ApplianceBST applianceTree = new ApplianceBST();
        
        while(isRunning){
            

            try {
                reader = new BufferedReader(new FileReader(filePath));
                
                //read and print the header line
                reader.readLine();

                //while line has something to read
                while((line = reader.readLine()) != null){
                    //splits the values in the csv and put it into array
                    String[] row = line.split(",");

                    //creates a new appliance where row0 = name, row1 = category, row2 = price
                    Appliance newAppliance = new Appliance(row[1], Float.parseFloat(row[2]), row[0]);
                    applianceTree.insert(newAppliance);
                }

                //formats and outputs what is in the current tree
                System.out.println("----------------------------------------------------");
                System.out.println("Current database: ");
                applianceTree.print();
                System.out.println();

                //creates scanner
                Scanner scanner = new Scanner(System.in);
                
                //main menu
                System.out.println("Main Menu (enter a number and press enter...)");
                System.out.println("-------------------------------------------------");
                System.out.println("1. Check if an appliance exists");
                System.out.println("2. Add a new appliance");
                System.out.println("3. Remove an existing appliance");
                System.out.println("4. Search for all appliances in a specified category");
                System.out.println("5. Search for appliances in a category within a price range");
                System.out.println("6. Exit program");
                System.out.println("-------------------------------------------------");

                //reads user input
                int input = Integer.parseInt(scanner.nextLine());

                //process user input
                if(input == 1){
                    //takes user input to make a new appliance object
                    Appliance newAppliance = applianceCreator(scanner);

                    System.out.println("------------------------------------");
                    //output message whether if appliance exists or not
                    if(applianceTree.search(newAppliance)){
                        System.out.println(newAppliance.toString() + " exists within the database");
                    }
                    else{
                        System.out.println(newAppliance.toString() + " does not exist within the database");
                    }    
                }
                //adds new appliance
                else if(input == 2){
                    //takes user input to make a new appliance object
                    Appliance newAppliance = applianceCreator(scanner);
                    //insert the appliance
                    applianceTree.insert(newAppliance);
                    System.out.println("------------------------------------");
                    System.out.println("Appliance added");
                }
                //removes an appliance
                else if(input == 3){
                    //takes user input to make a new appliance object
                    Appliance newAppliance = applianceCreator(scanner);

                    //check if appliance exists
                    if(applianceTree.search(newAppliance)){
                        //remove the appliance
                        applianceTree.remove(newAppliance);
                        System.out.println("------------------------------------");
                        System.out.println("Appliance removed");
                    }
                    else{
                        System.out.println("Appliance does not exist in the database");
                    }
                }
                else if(input == 4){
                        
                }
                else if(input == 5){
                        
                }
                //stops the program running and skips current iteration
                else if(input == 6){
                    isRunning = false;
                    continue;
                }
                else{
                    System.out.println("Please enter a valid number");
                }

                //lets the reader read any messages outputted before going back to main menu
                System.out.println("Going back to main menu in 3s");
                Thread.sleep(3000);
                
            } 
            catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                System.out.println("Application will restart in 3s");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ie) {
                    System.out.println("Sleep interrupted: " + ie.getMessage());
                }
            } 
        }
    }

    /**
     * Creates appliance based on the user input
     * @param scanner to scan user input
     * @return The appliance that will be used
     */
    private static Appliance applianceCreator(Scanner scanner) {
        boolean invalidInput = true;

        while(invalidInput){
            try {
                
                // Prompts and gets user input for the 3 variables needed to create an appliance object
                System.out.println("Enter category:");
                String inputCategory = scanner.nextLine().trim();
                System.out.println("Enter price:");
                Float inputPrice = Float.parseFloat(scanner.nextLine());
                System.out.println("Enter name:");
                String inputName = scanner.nextLine().trim();
                
                invalidInput = false;
                //returns a new Appliance object
                return new Appliance(inputCategory, inputPrice, inputName);
            } 
            catch (Exception e) {
                System.out.println("Input error: " + e.getMessage());
            }
        }
        //ensures the method always returns a value
        return null; 
    }
}
