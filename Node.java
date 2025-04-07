public class Node {
    //appliance object and left and right child nodes
    public Appliance appliance;
    public Node left, right;

    //constructor to create a new node with the given appliance
    public Node(Appliance appliance) {
        this.appliance = appliance;
        this.left = null;
        this.right = null;
    }
}
