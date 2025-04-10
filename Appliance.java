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

    /**
     * compares two objects decides which comes before the other
     * @param other the other object to compare to
     * @return the number returned to decide if this object is before or after
     */
    public int compareTo(Appliance other) {

        //compare this category with the other object's category
        if (this.category.compareTo(other.category) != 0){
            //compare by category if theyre not the same
            return this.category.compareTo(other.category);
        }
        else {
            //comparing by price if category is the same
            if (this.price < other.price) {
                return -1;
            } 
            else if (this.price > other.price) {
                return 1;
            } 
            else {
                //comparing by name if price is the same
                return this.name.compareTo(other.name);
            }
            
        }
        
        
    }
    
    

}
