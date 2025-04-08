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
        return  category + "  |  " + name + "  |  " + price;
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
