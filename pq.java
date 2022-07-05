/*A min priority queue implemetation using a binary heap
 * @author Alvin Liang, alvin.liang@mail.utoronto.ca
 */
import java.util.*;
public class pq<T extends Comparable<T>>{
    //T has to implement the comparable interface or we can't set the priority
    //The number of elements currently inside the heap
    private int heapSize = 0;
    //The internal capacity of the heap
    private int heapCapacity = 0;
    //A dynamic list to track the elements inside the heap 
    //this will represent the actual heap
    private List<T> heap = null;
    //possible indicies of a particular node value
    //which allows us to have 0(log(n)) removals and 0(1) element check
    //at the cost of some additional space and minor overhead
    private Map <T, TreeSet<Integer>> map = new HashMap<>();
    public pq(int size){
        heap = new ArrayList<>(size);
    }
    public pq(){
        //this is constructor overloading 
        this(1);
    }
    public pq(Collection <T> elements){
        this(elements.size());
        for (T element : elements) add(element);

    }
    public boolean isEmpty(){
        return heapSize == 0;
    }
    public void clear(){
        for(int i = 0; i < heapCapacity; i++){
            heap.set(i, null);
        }
        heapSize = 0;
        map.clear();
    }
    public int size(){
        return heapSize;
    }
    public T peek(){
        if (isEmpty()) return null;
        return heap.get(0);
    }
    public T poll(){
        return removeAt(0);
    }
    public boolean contains(T element){
        if(element == null)return false;
        return map.contains(element);
    }
    //Adds an element to the pQueue, 
    //the element must not be null, 0(log(n))

    public void add(T element){
        if(element == null) throw new IllegalArgumentException();
        if (heapSize < heapCapacity){
            heap.set(heapSize, element);
        }else{
            heap.add(element);
            heapCapacity++;
        }
        mapAdd(element,heapSize);
        //we have to swim a node up as we append it to the very end of our list 
        //so we need to adjust the size of our heap 
        swim(heapSize);
        heapSize++;
    }
    private boolean less(int i, int j){
        T node1 = heap.get(i);
        T node2 = heap.get(j);
        return ndoe1.compareTo(node2) <= 0;
    }
    private void swim(int k){
        //Grab the index of the next parent node WRT to k
        int parent = (k-1) / 2;
        //this is just the inverse function of the left/right child formula`
        while (k >0 && less(k, parent)){
            swap (parent, k);
            k = parent;
            //grab the index of the next parent ndoe WRT to k
            parent = (k-1) / 2;
        }
    }
    private void sink(int k){
        while(true){
            int leftChild = 2 * k + 1;
            int rightChild = 2 * k +2;
            int smallest = leftChild; //we're going to make the assumption that the smallest is currently the left child
            if (rightChild < heapSize && less(rightChild,leftChild)){
                //right < heapSize: remember that rightchild is only the index of the rightChild, this means that if the rightChild is outside the bounds of the heapSize, then that means there are no more elements left
                //less(rightChild, leftChild) sees if the first arg is less than second arg
                smallest = rightChild;
            }
            if (left >= heapSize || less(k,smallest)) break;
            //checks if the index of the leftChild is greater than the heapsize implying we're out of bounds
            //checks if the current value of k is less than the smallest child
            //this implies that we can't sink K anymore
            swap(smallest, k);
            //swap handles the representation in the hashmap and ArrayList
            k = smallest;//this isn't the smallest value, it's the smallest index
        }
    }
    private void swap (int i, int j){
        //grab both elements
        T i_elem = heap.get(i);
        T j_elem = heap.get(j);

        heap.set(i, j_elem);
        heap.set(j, i_elem);
        
        mapSwap (i_elem, j_elem, i, j);
    }
    //Removes a particular element in the heap, 0(log(n))
    //remember it doesn't matter which element you remove as long as you abide to the heap invariant
    public boolean remove(T element){
        //this method calls removeAt
        if (element == null) return false;
        //get the index of the element we're trying to remove
        Integer index = mapGet(element);
        if (index != null) removeAt(index);
        return index != null;
    }

    //Removes a particular element at an index
    public T removeAt(int index){
        

    }







    
}
