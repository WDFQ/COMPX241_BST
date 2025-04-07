public class ApplianceBST {

    // root node of the tree
    public Node root;

    public void insert(Appliance a){
        insertSubtree(root, a);
    }

    /**
     * the insert method that inserts a new appliance into the tree
     * 
     * @param currentRoot
     * @param a
     * @return
     */
    public Node insertSubtree(Node currentRoot, Appliance a){
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
     * @param currentRoot
     * @param a
     * @return
     */
    public boolean searchSubtree(Node currentRoot, Appliance a){
        // Checks if the root is null
        if (currentRoot == null){
            return false;
        }

        // Checks if the current root is the appliance we are looking for
        else if (currentRoot.value == a){
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
        // Calls the recursive print method
        printR(root);
    }


    /**
     * the recursive method that prints the tree in order
     * @param currentRoot
     */
    public void printR(Node currentRoot){
        if(currentRoot == null){
            return;
        }
        
        //print the parent node
        

        //print the left child node
        if(currentRoot.left != null){

        }
            
    }


    /**
     * calls the recursive remove method to remove an appliance from the tree
     * @param a
     */
    public void remove(Appliance a){
        Node currentNode = root;
        
        //check to see if node is in the tree
        if(search(a)){

            //while we're not at the goal node
            while(currentNode.value != a){

                //move down to the right subtree if the value is larger than current node
                if (a.compareTo(currentNode.value) > 0){
                    currentNode = currentNode.right;
                }
                //move down to the left subtree if the value is smaller than the current node
                else if(a.compareTo(currentNode.value)< 0){
                    currentNode = currentNode.left;
                }
                
            }

            //if the target node is a leaf node
            if(currentNode.left == null && currentNode.right == null){
                currentNode = null;
            }
            // if the target node has one child
            else if (currentNode.left == null || currentNode.right == null) {
                if (currentNode.left != null){
                    currentNode = currentNode.left;
                }
                else if(currentNode.right != null){
                    currentNode = currentNode.right;
                }
            }
            //if the target node has two children
            else{
                //go to the right subtree and find the left most node of that subtree
                Node leftMostNode = currentNode.right;
                while(leftMostNode.left != null){
                    leftMostNode = leftMostNode.left;
                }

                //replace the target node with the left most node of the right subtree
                currentNode.value = leftMostNode.value;
            }


            
        }
        else{
            System.out.println("Appliance not found in the tree.");
        }
    }

    public int getHeight(){
        return getHeightSubtree(root);
    }

    public int getHeightSubtree(Node currentRoot){
        //if the tree is empty return -1
        if(currentRoot == null){
            return -1;
        }
        //use recursion to count the height from bottom to top
        else{
            return Math.max(getHeightSubtree(currentRoot.left), getHeightSubtree(currentRoot.right)) + 1;
        }
    }


   
}




