import java.util.LinkedList;
public class queue {
    //let's implement this using a singly linked list
    Node head = null;
    Node tail = null; 
    int size;
    
    //create an empty Queue
    public queue(){}

    public queue(T firstElement){
        this.enqueue(firstElement);
    }
    public void enqueue(T element){
        //we have to manage the pointer mangement while appending
        Node newNode = new Node(element);
        if (this.isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        }else{
            //in the case that the queue is not empty
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }
    public T dequeue(){
        //we don't need to check whether or not list is empty
        //first we should store a reference to head node for derefencing and value return
        Node temp = this.head;
        //if they are the same element than they are about to empty the list 
        //which means that we should change the tail too 
        if (this.head == this.tail){
           this.head = null; 
           this.tail = null;
        }
        this.head = this.head.next;
        this.size--;
        return temp.val;
    }
    public boolean isEmpty(){
        if (head == null){
            return true;
        }
        return false;
    }
    public class Node<T>{
        Node next = null;
        T val;
        public node(T value){
            this.val = value;
        }
    }

    
}
