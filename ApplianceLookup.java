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
            System.out.println("Current table: ");
            applianceTree.print();

            //user input variable
            String input = "";
            Scanner scanner = new Scanner(System.in)
            
            while (isRunning) {
                System.out.println("What would you like to do? Please enter the corresponding number:");
                System.out.println("1. search for an appliance");
                System.out.println("2. Add a new appliance");
                System.out.println("3. Remove an existing appliance");
                System.out.println("4. Search for all appliances in a specified category");
                System.out.println("5. Search for appliances in a category within a price range");
                System.out.println("6. Exit program");
                //reads user input
                input = scanner.nextLine();

                //process user input
                if(input == "1"){
                    
                }
                else if(input == "2"){

                }
                else if(input == "3"){

                }
                else if(input == "4"){
                    
                }
                else if(input == "5"){
                    
                }
                else if(input == "6"){
                    isRunning = false;
                }
            }


           

            
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } 
    }
}
