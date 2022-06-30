import java.util.*;
public class stack<T> implements Iterable<T> {
    //we're going to implement this using a linked list
    int size;
    Node head = null;
    //creates an empty stack 
    public stack(){}
    //creates a stack witht the first element 
    public stack(T firstElement){
        push(firstElement);
    }
    public T peek() {
        //return the first element of the stack without popping the element from the stack
        return this.head.val;
    }
    public void push(T element){
        //place an element on the top of the stack
        Node newNode = new Node(T);
        newNode.next = head;
        this.head = newNode;
        this.size++;
    }
    public T pop(){
        if (this.head == null){
            throw new java.util.EmptyStackException();
        }
        //removes the top the Node and returns it's value
        Node tempPointer = this.head;
        this.head = head.next;
        //derefence the memory, so that the garbage collector picks it up
        tempPointer.next = null;
        return tempPointer.val;
    }

    private class Node<T>{
        T val;
        Node next = null;
        //Functionality that we should define: 
        Node(T val){
            this.val = val;
        }
    }


}
