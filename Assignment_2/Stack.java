/**
 * Kevin Ramos
 * 111019436
 * CSE 214 (2)
 */
package datastructures.sequential;

import java.util.EmptyStackException;

/**
 * This class implements the LIFOQueue interface and uses the SNode class to create a stack with
 * a singly linked list implementation. The stack has been created to deal with Objects in general and
 * not specifically with one. This becomes very useful when you have to push tokens, doubles, strings,
 * and chars to the same stack later on.
 * @author Kevin Ramos
 */
public class Stack implements LIFOQueue {

    private SNode top;

    /**
     * A constructor that creates an empty Stack by setting the top node to null.
     *
     */
    public Stack() {
        top = null;
    }


    /**
     * Removes the top node by setting the next node to become the top.
     *
     * @throws EmptyStackException if the stack is empty.
     * @return the data from the top node aka the top of the stack.
     */
    @Override
    public Object pop() {
        Object poppedObjected;
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        poppedObjected = top.getData();
        top = top.getNext();
        return poppedObjected;
    }

    /**
     * Pushes an object to the top of the stack.
     *
     */
    @Override
    public void push(Object element) {
        SNode node = new SNode(element);
        node.setNext(top);
        top = node;
    }

    /**
     * Used to return the object at the top of the stack but does not remove it.
     *
     * @return the object at the top of the stack
     */
    @Override
    public Object peek() {
        Object peekedObject;
        if(top == null) {
            throw new EmptyStackException();
        }
        peekedObject = top.getData();
        return peekedObject;
    }

    /**
     * Used to determine the size of the stack/ the amount of Objects inside the stack.
     *
     * @return the int size of the stack
     */
    @Override
    public int size() {
        int length = 0;
        SNode currentNode = top;
        while(currentNode != null) {
            length ++;
            currentNode = currentNode.getNext();
        }
        return length;
    }

    /**
     * The method used to determine if the stack is empty or not by checking the if the top node is empty
     *
     * @return true/false if the stack is empty
     */
    @Override
    public boolean isEmpty() {
        return (top == null);
    }

}
