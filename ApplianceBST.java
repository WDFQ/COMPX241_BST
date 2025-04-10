import java.util.ArrayList;

public class ApplianceBST {

    // root node of the tree
    public Node root;


    //enum to keep track of the type of search we are doing
    private enum recursiveIds{
        CATEGORYONLY, PRICERANGE, ABOVEPRICE, BELOWPRICE;
    }
    recursiveIds recursiveId = recursiveIds.CATEGORYONLY;


    /**
     * insert method that inserts a new appliance into the tree
     *
     * @param a the appliance to be inserted
     */
    public void insert(Appliance a){
       // If the root is null, set the root to a new node
        if (root == null) {
            root = new Node(a);
        } 
        else {
            insertSubtree(root, a);
        }
    }

    /**
     * the recursive method that insert method calls
     * 
     * @param currentRoot the current root of the tree
     * @param a the appliance to be inserted
     * @return the current root of the tree
     */
    private Node insertSubtree(Node currentRoot, Appliance a){
        // When the tree is null
        if (currentRoot == null){
            currentRoot = new Node(a);
        }

        // If the value is smaller then add it to the left subtree
        else if (a.compareTo(currentRoot.value) < 0){
            currentRoot.left = insertSubtree(currentRoot.left, a);
        }

        // If the value is greater then add it to the right subtree
        else if (a.compareTo(currentRoot.value) > 0){
            currentRoot.right = insertSubtree(currentRoot.right, a);
        }

        return currentRoot;
    }


    /**
     * calls recursive method to search for an appliance in the tree
     * 
     * @param a
     */
    public boolean search(Appliance a){
        // Calls the recursive search method
        return searchSubtree(root, a);
    }

    /**
     * the recursive method that searches the subtrees for the appliance
     * 
     * @param currentRoot the current root of the tree
     * @param a the appliance to be searched for
     * @return true if the appliance is found, false otherwise
     */
    private boolean searchSubtree(Node currentRoot, Appliance a){
        // Checks if the root is null
        if (currentRoot == null){
            return false;
        }

        // Checks if the current root is the appliance we are looking for
        else if (a.compareTo(currentRoot.value) == 0){
            return true;
        }
        // Do recursive search in the left subtree
        else if (a.compareTo(currentRoot.value) < 0){
            return searchSubtree(currentRoot.left, a);
        }
        // Do recursive search in the right subtree
        else if (a.compareTo(currentRoot.value) > 0){
            return searchSubtree(currentRoot.right, a);
        }
        return false;
    }


    /**
     * calls the recursive print method to print the tree in order
     */
    public void print(){
        printR(root);

    }

    /**
     * the recursive method that prints the tree in order
     * @param currentRoot the current root of the tree
     * @return the current root of the tree
     */
    private void printR(Node currentNode){
        if(currentNode == null){
            return;
        }
        
        //traverse left subtree
        printR(currentNode.left); 
        //print the current node
        System.out.println(currentNode.value); 
        //traverse right subtree
        printR(currentNode.right); 

    }


    /**
     * calls the recursive remove method to remove an appliance from the tree
     * @param a The appliance to be removed
     */
    public void remove(Appliance a){
        Node currentNode = root;
        Node previousNode = null;

        // 0 = left, 1 = right
        int leftRightIndicator = 0; 
        
        //check to see if node is in the tree
        if(search(a)){

            //while we're not at the goal node
            while(a.compareTo(currentNode.value) != 0){

                //move down to the right subtree if the value is larger than current node
                if (a.compareTo(currentNode.value) > 0){
                    previousNode = currentNode;
                    currentNode = currentNode.right;
                    leftRightIndicator = 0;
                }
                //move down to the left subtree if the value is smaller than the current node
                else if(a.compareTo(currentNode.value)< 0){
                    previousNode = currentNode;
                    currentNode = currentNode.left;
                    leftRightIndicator = 1;
                }
            }

            //if the target node is a leaf node
            if(currentNode.left == null && currentNode.right == null){
                if(currentNode == root){
                    root = null;
                }
                //if we came from the right subtree of the parent node set the right child of the previous node to null
                if (leftRightIndicator == 0){
                    previousNode.right = null;
                }
                //if we came from the left subtree of the parent node set the left child of the previous node to null
                else if(leftRightIndicator == 1){
                    previousNode.left = null;
                }
            }
            // if the target node has one child
            else if (currentNode.left == null ^ currentNode.right == null) {
                //if the current node came from the right subtree of its parent
                if (leftRightIndicator == 0) {
                    //if the current node has a left child, set the right child of the parent to the left child of the current node
                    if (currentNode.left != null){
                        previousNode.right = currentNode.left;
                    }
                    //if the current node has a right child, set the right child of the parent to the right child of the current node
                    else if(currentNode.right != null){
                        previousNode.right = currentNode.right;
                    }
                }
                else if (leftRightIndicator == 1) {
                    if (currentNode.left != null){
                        previousNode.left = currentNode.left;
                    }
                    else if(currentNode.right != null){
                        previousNode.left = currentNode.right;
                    }
                }
                
            }
            //if the target node has two  children
            else {
                //Go to the right subtree and find the leftmost node of that subtree
                previousNode = currentNode; // Track the parent of the leftmost node
                Node leftMostNode = currentNode.right;
            
                while (leftMostNode.left != null) {
                    previousNode = leftMostNode;
                    leftMostNode = leftMostNode.left;
                }

                // Replace the target node's value with the leftmost node's value
                currentNode.value = leftMostNode.value;
            
                // Remove the leftmost node from its original position
                if (previousNode.left == leftMostNode) {
                    //if the leftmost node is a left child, relink its parent's left pointer to the right child of the leftmost node
                    previousNode.left = leftMostNode.right;
                } 
                else {
                    //if the leftmost node is the immediate right child of the current node
                    previousNode.right = leftMostNode.right;
                }
            }
        }
        else{
            System.out.println("Appliance not found in the tree.");
        }
    }


    /**
     * calls the recursive method to get the height of the tree
     * @return the height of the tree
     */
    public int getHeight(){
        return getHeightSubtree(root);
    }

    /**
     * the recursive method that gets the height of the tree
     * @param currentRoot the current root of the tree
     * @return the height of the tree
     */
    private int getHeightSubtree(Node currentRoot){
        //if the tree is empty return -1
        if(currentRoot == null){
            return 0;
        }
        //use recursion to count the height from bottom to top
        else{
            return Math.max(getHeightSubtree(currentRoot.left), getHeightSubtree(currentRoot.right)) + 1;
        }
    }


    /**
     * finds the minimum value in the tree
     * @return the minimum value in the tree
     */
    public Appliance getMinimum(){
        if(root == null){
            return null;
        }
        else{
            Node currentNode = root;
            while (currentNode.left != null){
                currentNode = currentNode.left;
            }
            return currentNode.value;
        }
    }

    /**
     * finds the maximum value in the tree
     * @return the maximum value in the tree
     */
    public Appliance getMaximum(){
        if(root == null){
            return null;
        }
        else{
            Node currentNode = root;
            while (currentNode.right != null){
                currentNode = currentNode.right;
            }
            return currentNode.value;
        }
    }


    /**
     * prints all appliances in the tree that belong to a specific category in order of price
     * @param category the category to search for
     */
    public void printCategory(String category){
        //print category = 1, print category with price = 2, print category above price = 3, print category below price = 4
        recursiveId = recursiveIds.CATEGORYONLY;
        printCategorySubtree(root, category, -1, -1);
    }

     /**
     * prints all appliances in the tree that iis within a category that is within a price range
     * @param c the category to search for
     * @param min the minimum price
     * @param max the maximum price
     */
    public void printCategoryWithPriceRange(String c, float min, float max){
        
        recursiveId = recursiveIds.PRICERANGE;
        printCategorySubtree(root, c, min, max);
    }

    /**
     * prints all appliances in the tree that belong to a specific category that is above a given price
     * @param c the category to search for
     * @param min the minimum price
     */
    public void printCategoryAbovePrice(String c, float min){
        recursiveId = recursiveIds.ABOVEPRICE;
        printCategorySubtree(root, c, min, -1);
    }

    /**
     * prints all appliances in the tree that belong to a specific category that is below a given price
     * @param c the category to search for
     * @param max the maximum price
     */
    public void printCategoryBelowPrice(String c, float max){
        recursiveId = recursiveIds.BELOWPRICE;
        printCategorySubtree(root, c, -1, max);
    }
    

    /**
     * the recursive method that prints all appliances in the tree that belong to a specific category in order of price
     * @param currentNode the current node of the tree
     * @param category the category to search for
     */
    private void printCategorySubtree(Node currentNode, String category, float min, float max){
        //if the tree is empty return
        if (currentNode == null){
            return;
        }

        //compare with current node 
        if(currentNode.value.getCategory().equals(category)){
            //checking to see which kind of filter we need
            if(recursiveId == recursiveIds.CATEGORYONLY){
                //process left subtree first, then print current node, then process right subtree
                printCategorySubtree(currentNode.left, category, min, max);
                System.out.println(currentNode.value);
                printCategorySubtree(currentNode.right, category, min, max);
            }
            else if (recursiveId == recursiveIds.PRICERANGE) {
                //check for the items within the current category that is between the given min and max price
                if(currentNode.value.getPrice() > min && currentNode.value.getPrice() < max){
                    printCategorySubtree(currentNode.left, category, min, max);
                    System.out.println(currentNode.value);
                    printCategorySubtree(currentNode.right, category, min, max);
                }
                else if(currentNode.value.getPrice() > max){
                    //if the current node's price is greater than the max price, go to the left subtree
                    printCategorySubtree(currentNode.left, category, min, max);
                }
                else{
                    //if the current node's price is less than the min price, go to the right subtree
                    printCategorySubtree(currentNode.right, category, min, max);
                }
            }
            else if (recursiveId == recursiveIds.ABOVEPRICE) {
                //check for items that is above the given price
                if(currentNode.value.getPrice() > min){
                    printCategorySubtree(currentNode.left, category, min, max);
                    System.out.println(currentNode.value);
                    printCategorySubtree(currentNode.right, category, min, max);
                }
                else{
                    //if current node is less than target category, go to the right subtree
                    printCategorySubtree(currentNode.right, category, min, max);
                }
            }
            else if (recursiveId == recursiveIds.BELOWPRICE){
                //check for items that is below the given price
                if(currentNode.value.getPrice() < max){
                    printCategorySubtree(currentNode.left, category, min, max);
                    System.out.println(currentNode.value);
                    printCategorySubtree(currentNode.right, category, min, max);
                }
                else{
                    //if current node is greater than target category, go to the left subtree
                    printCategorySubtree(currentNode.left, category, min, max);
                }
            }
        }
        else if(currentNode.value.getCategory().compareTo(category) < 0){
            //if current node is less than target category, go to the right subtree
            printCategorySubtree(currentNode.right, category, min, max);
        }
        else{
            //if current node is greater than target category, go to the left subtree
            printCategorySubtree(currentNode.left, category, min, max);
        }
    }
}




