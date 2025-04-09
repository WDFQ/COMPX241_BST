public class Appliance {
 
    private String category;
    private Float price;
    private String name;

    public Appliance(String category, Float price, String name) {
        this.category = category;
        this.price = price;
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public Float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }   

    @Override
    public String toString() {
        // Adds padding to the category and name
        String paddedCategory = String.format("%-20s", category); // 15-character padding
        String paddedName = String.format("%-50s", name);         // 20-character padding

        return paddedCategory + "|" + paddedName + "|" + price;
    }

    public int compareTo(Appliance other) {

        
        if ((this.category.compareTo(other.category) < 0) || (this.category.compareTo(other.category) > 0)){
            return  this.category.compareTo(other.category);
        }
        else {

            if (this.price < other.price) {
                return -1;
            } 
            else if (this.price > other.price) {
                return 1;
            } 
            else {
                return this.name.compareTo(other.name);
            }
            
        }
        
        
    }
    
    

}
