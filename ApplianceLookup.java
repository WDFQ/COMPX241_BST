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
                String header = reader.readLine();
                System.out.println(header);

                //while line has something to read
                while((line = reader.readLine()) != null){
                    //splits the values in the csv and put it into array
                    String[] row = line.split(",");

                    //creates a new appliance where row0 = name, row1 = category, row2 = price
                    Appliance newAppliance = new Appliance(row[1], Float.parseFloat(row[2]), row[0]);
                    applianceTree.insert(newAppliance);

                    //print the inserted line
                    System.out.println("inserted: " + line);

                }

                //formats and outputs the current tree
                System.out.println("----------------------------------------------------");
                System.out.println("Current database: ");
                applianceTree.print();

                //user input variable
                int input = 0;
                Scanner scanner = new Scanner(System.in);
                
                System.out.println("What would you like to do? Please enter the corresponding number:");
                    System.out.println("1. Check if an appliance exists");
                    System.out.println("2. Add a new appliance");
                    System.out.println("3. Remove an existing appliance");
                    System.out.println("4. Search for all appliances in a specified category");
                    System.out.println("5. Search for appliances in a category within a price range");
                    System.out.println("6. Exit program");
                    System.out.println("-------------------------------------------------");
                    //reads user input
                    input = Integer.parseInt(scanner.nextLine());

                    //process user input1
                    if(input == 1){
                        //prompts and gets user input for the 3 variabels needed to create an appliance object
                        System.out.println("Enter category:");
                        String inputcategory = scanner.nextLine();
                        inputcategory = inputcategory.trim();
                        System.out.println("Enter price:");
                        Float inputPrice = Float.parseFloat(scanner.nextLine());
                        System.out.println("Enter name");
                        String inputName = scanner.nextLine();
                        inputName = inputName.trim();
                        
                        //uses user inputs to make a new category
                        Appliance newAppliance = new Appliance(inputcategory, inputPrice, inputName);

                        System.out.println("------------------------------------");

                        //output message whether if appliance exists or not
                        if(applianceTree.search(newAppliance)){
                            System.out.println(newAppliance.toString() + " exists within the database");
                        }
                        else{
                            System.out.println(newAppliance.toString() + " does not exist within the database");
                        }
                        
                        System.out.println("Press any key to go back to main menu");
                        
                        System.in.read();
                    
                        





                        
                    }
                    else if(input == 2){

                    }
                    else if(input == 3){

                    }
                    else if(input == 4){
                        
                    }
                    else if(input == 5){
                        
                    }
                    else if(input == 6){
                        isRunning = false;
                    }
                    else{
                        System.out.println("Please enter a valid number");
                        System.in.read();
                    }

            

                
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                System.out.println("Application will restart in 5s");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ie) {
                    System.out.println("Sleep interrupted: " + ie.getMessage());
                }
            } 
        }
       
    }
}
