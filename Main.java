public class Main {
    public static void main(String[] args) {
        // Create an instance of ApplianceBST
        ApplianceBST applianceBST = new ApplianceBST();
        
        // Create some appliances
        Appliance standFreezer = new Appliance("Fridge", 1000.20f, "stand freezer");
        Appliance standerFreezest = new Appliance("Fridge", 300.00f, "stander freezest");
        Appliance candle = new Appliance("Oven", 100.20f, "candle"); 
        Appliance gasStove = new Appliance("Oven", 10200.20f, "Gas stove"); 
        Appliance heatPump = new Appliance("Aircon", 1030.20f, "Heat pump"); 
        Appliance random = new Appliance("Fridge", 1030.20f, "Heat"); 
        
        

        // Insert appliances into the BST
        applianceBST.insert(standFreezer);

        
        applianceBST.insert(standerFreezest);
        applianceBST.insert(candle);
        applianceBST.insert(gasStove);
        applianceBST.insert(heatPump);
        applianceBST.insert(random);
        
        // Search for an appliance
        boolean found = applianceBST.search(standFreezer);
        System.out.println("Appliance found: " + found); // Should print true
        
        // Print the BST in order
        StrBSTPrinter.printNode(applianceBST.root);

        //applianceBST.remove(gasStove);


        applianceBST.getHeight();

        Appliance min = applianceBST.getMinimum();
        Appliance max = applianceBST.getMaximum();

        System.out.println("Minimum appliance: " + min);
        System.out.println("Maximum appliance: " + max);
        System.out.println("Height of the tree: " + applianceBST.getHeight());

        

       
        //applianceBST.printCategory(candle.getCategory());
        applianceBST.printCategoryBelowPrice("Oven", 500000);
        //System.out.println(random.getCategory());
    }
}
