public class BST <T extends Comparable<T>> {

    //Tracks the number of nodes in this BST
    private int nodeCount = 0;
    
    //THis BST is a rooted tree so we maintain a handle on the root node
    private Node root = null;

    //Internal node containing node references and it's data
    private class Node {
        T data;
        Node left, right;
        public Node (Node left, Node right, T data){
            this.left = left;
            this.right = right;
            this.data = data;
        }
        public Node (T data){
            left = null;
            this.right = null;
            this.data = data;
        }
    }
    public boolean isEmpty(){
         return size() == 0;
    }
    //we're going to create an acess modifier here so that the information is more private
    public int size(){
        return nodeCount;
    }
    //Add an element, return tree if we sucessfully perform an insertion
    //we don't allow for duplicates

    public boolean add(T element){
        //it already contains the element so there is no point in adding it 
        if(contains(element)) return false;
        //define the base case
        if(root.data.compareTo(element) < 0 && root.right == null){
            //set the root.right to a new node and return to our caller that the node has been inserted
            root.right = new Node(element);
            return true;
        }else if ((root.data.compareTo(element) > 0) && root.left == null){
            //set the root.left to a new node and return true
            node.left = new Node(element);
            return true;
        }
        //we just gotta do a DFS in order to insert our element
        //this is also the case where it will strictly be < or > never equal
        //we should go searching for the leaf in the right tree 
        if(root.data.compareTo(element) < 0){
            return root.left.add(element);
        }else{
            //we should go seraching for the left in the left tree
            return root.right.add(element); 
        }
        
    }
    //we can do this recursively and O(log(n))
    public boolean contains(T element){
        //define the base case
        if (root.data == element) return true; 
        //if we reach a leaf this means that we didn't find the value
        if(root.data == null) return false;
        //now we need to check which branch to search
        //this is the case where it will strictly be < or > never equal
        if(root.data.compareTo(element) < 0){
            return root.right.contains(element);
        }else{
            return root.left.contains(element);
        }
    }



    
}
