import java.util.*;
public class UnionFind {
    //The number of elements in this union find 
    private int size;
    //Used to track the sizes of each of the components
    private int[] sizes;
    //id[i] points to the parent of i, if id[i] = i then i is a root node
    //this handles our bijection property 
    private int[] id; 
    //then we need the data structure to represent the actual unionfind
    private int numComponents; 

    public UnionFind(int size){
        if (size <= 0) throw new IllegalException("Size less than or equal to 0")
        this.size = numComponents = size;
        sizes = new int[size];
        id = new int[id];

        for (int i = 0; i < size; i++){
            //currently every root is pointing to itself
            id[i] = i;
            //and every component is currently of size 1 
            sizes[i] = 1;
        }
    }
    //Find which component/set 'p' belongs to, takes amortized constant time 
    public int find(int p){
        //first we go up the tree until we find that the root equals itself
        int root = p;
        while (root != id[root])
            root = id[root];
        //next let's compress the path 

        //starting back at p, we loop back over it's parents and point the bijection to the root
        //until we're at the root
        while (p != root){
            int next = id[p];
            id[p] = root;
            p = next;

        }
        return root;
        
    }
    public boolean connected(int p, int q){
        //just calling find on both these nodes will call path compression
        return find(p) == find(q);
    }
    //Return the size of the component/set 'p' belongs to
    public int componentSize(int p){
        return size(find(p)); 
    }
    //Return the number of elements in this UnionFind/Disjoint set
    public int size(){
        return size;
    }
    //Returns the number of remaining components/sets
    public int components(){
        return numComponents;
    }

    //Unify the components/sets containing elements 'p' and 'q'
    public void unify(int p, int q){
        //Start off by finding the 
        int root1 = find(p);
        int root2 = find(q);
        //if the roots are the same, then they are already in the same group
        if (root1 == root2) return;

        //Otherwise, we should merge two component sets together
        //By convention, we'lll merge the smaller into the bigger
        if (sizes[root1] < sizes[root2]){
            sizes[root2] += sizes[root1];
            id[root1] = root2;
            //shouldn't we be deferencing sizes[root1] here?
        }else{
           sizes[root1] += sizes[root2]; 
           id[root2] = root1;
        }
        }




    }


    


    
    
