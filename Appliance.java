/**
 * The class that represents an appliance object
 */
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
    /**
     * Returns a string representation of the appliance.
     */
    @Override
    public String toString(){
        // Adds padding to the category and name
        String paddedCategory = String.format("%-15s", category); //15 character padding
        String paddedName = String.format("%-50s", name); //20 character padding
        return paddedCategory + "|" + paddedName + "|" + price;
    }

    /**
     * * Compares this appliance with another appliance for ordering.
     * @param other the other appliance to compare to
     * @return a negative integer, zero, or a positive integer as this appliance is less than, equal to, or greater than the specified appliance
     */
    public int compareTo(Appliance other) {
        // Compare by category first, then by price, and finally by name
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
