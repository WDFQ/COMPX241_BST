public class ApplianceBST {

    // root node of the tree
    public Node root;

    /**
     * the insert method that inserts a new appliance into the tree
     * 
     * @param currentRoot
     * @param a
     * @return
     */
    public Node insert(Node currentRoot, Appliance a){
        // When the tree is null
        if (currentRoot == null){
            currentRoot = new Node(a);
        }

        // If the value is smaller then add it to the left subtree
        else if (a.compareTo(currentRoot.value) < 0){
            currentRoot.left = insert(currentRoot.left, a);
        }

        // If the value is greater then add it to the right subtree
        else if (a.compareTo(currentRoot.value) > 0){
            currentRoot.right = insert(currentRoot.right, a);
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



    public void print(){
        // Calls the recursive print method
        printR(root);
    }




    public void printR(Node currentRoot){
        if(currentRoot == null){
            return;
        }
        
        //print the parent node
        

        //print the left child node
        if(currentRoot.left != null){

        }
            
    }


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


            
        }
        else{
            System.out.println("Appliance not found in the tree.");
        }
    }


   
}




