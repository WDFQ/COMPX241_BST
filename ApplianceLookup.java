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

        } catch (Exception e) {
            System.out.println("An error occurred when reading the file: " + e.getMessage());
        }
        
        while(isRunning){
            try {
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
                    System.out.println("Checking if appliance exists...");

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
                    System.out.println("Adding new appliance...");

                    //takes user input to make a new appliance object
                    Appliance newAppliance = applianceCreator(scanner);
                    //insert the appliance
                    applianceTree.insert(newAppliance);
                    System.out.println("------------------------------------");
                    System.out.println("Appliance added");
                }
                //removes an appliance
                else if(input == 3){
                    System.out.println("Removing appliance...");

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
                //Print all appliances in a category
                else if(input == 4){
                    System.out.println("Searching for appliances in a category...");

                    //prompts user for category
                    System.out.print("Enter category: ");
                    String inputCategory = scanner.nextLine().trim();

                    //prints all appliances in the specified category
                    applianceTree.printCategory(inputCategory);
                }
                //prints all within a category within a price range
                else if(input == 5){
                    boolean validInput = true;

                    while(validInput){
                        System.out.println();
                        System.out.println("Price filtering...");
                        System.out.println("Which action would you like to perform? (enter a number and press enter...)");
                        System.out.println("-------------------------------------------------");
                        System.out.println("1. Search within a price range");
                        System.out.println("2. Search below a price");
                        System.out.println("3. Search above a price");
                        System.out.println("4. Go back to main menu");
                        System.out.println("-------------------------------------------------");

                        try {
                            int priceSortingInput = Integer.parseInt(scanner.nextLine());
                            
                            //prints within price range
                            if(priceSortingInput == 1){
                                
                                // Prompts and gets user input for the 3 variables needed to print category with price range
                                System.out.print("Enter category: ");
                                String inputCategory = scanner.nextLine().trim();
                                System.out.print("Enter min price: ");
                                Float minPrice = Float.parseFloat(scanner.nextLine());
                                System.out.print("Enter max price: ");
                                Float maxPrice = Float.parseFloat(scanner.nextLine());

                                System.out.println();
                                System.out.println("Output:");
                                System.out.println("-------------------------------------------------");
                                //prints all appliances in the specified price range
                                applianceTree.printCategoryWithPriceRange(inputCategory, minPrice, maxPrice);
                                System.out.println("-------------------------------------------------");
                                System.out.println();

                            }
                            //prints below price
                            else if(priceSortingInput == 2){
                                
                                //gets uer input
                                System.out.print("Enter category: ");
                                String inputCategory = scanner.nextLine().trim();
                                System.out.print("Enter max price: ");
                                Float maxPrice = Float.parseFloat(scanner.nextLine());
                                
                                
                                System.out.println();
                                System.out.println("Output:");
                                System.out.println("-------------------------------------------------");
                                //prints all appliances in the specified price range
                                applianceTree.printCategoryBelowPrice(inputCategory, maxPrice);
                                System.out.println("-------------------------------------------------");
                                System.out.println();
                                

                            }
                            //prints above price
                            else if(priceSortingInput == 3){
                                System.out.print("Enter category: ");
                                String inputCategory = scanner.nextLine().trim();
                                System.out.print("Enter min price: ");
                                Float minPrice = Float.parseFloat(scanner.nextLine());

                                
                                System.out.println();
                                System.out.println("Output:");
                                System.out.println("-------------------------------------------------");
                                //prints all appliances in the specified price range
                                applianceTree.printCategoryAbovePrice(inputCategory, minPrice);
                                System.out.println("-------------------------------------------------");
                                System.out.println();
                            }
                            //goes back to main menu
                            else if(priceSortingInput == 4){
                                validInput = false;
                                continue;
                            }
                            else{
                                System.out.println("Please enter a valid number (1-3)");
                            }
                        } 
                        catch (Exception e) {
                            System.out.println("An error occurred: " + e.getMessage());
                            try {
                                Thread.sleep(1000);
                            } 
                            catch (InterruptedException ie) {
                                System.out.println("Sleep interrupted: " + ie.getMessage());
                            }
                        }
                    }
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
                    Thread.sleep(2500);
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
                System.out.print("Enter category: ");
                String inputCategory = scanner.nextLine().trim();
                System.out.print("Enter price: ");
                Float inputPrice = Float.parseFloat(scanner.nextLine());
                System.out.print("Enter name: ");
                String inputName = scanner.nextLine().trim();
                
                invalidInput = false;
                //returns a new Appliance object
                return new Appliance(inputCategory, inputPrice, inputName);
            } 
            catch (Exception e) {
                System.out.println("Input error: " + e.getMessage());
            }
        }
        //makes sure the method always returns a value
        return null; 
    }
}
