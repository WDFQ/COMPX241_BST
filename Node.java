public class Node {
    //appliance object and left and right child nodes
    public Appliance value;
    public Node left, right;

    //constructor to create a new node with the given appliance
    public Node(Appliance value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
