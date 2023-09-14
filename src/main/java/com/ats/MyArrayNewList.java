package com.ats;


import java.util.*;


//This class is an implementation of the ArrayList class
public class MyArrayNewList<E>
{

    //This field is array of objects
    private Object[] myArrayList;

    //This field - the number of elements this array contains
    private int size =0;

    //This field is the default number of elements in this array
    private static final int DEFAULT_SIZE = 10;

    //Constructs an empty list with an initial capacity of ten.
    public MyArrayNewList() {
        this.myArrayList = new Object[DEFAULT_SIZE];


    }

    /*Constructs an empty list with the specified initial capacity,
    numberElements – the initial capacity of the list*/
    public MyArrayNewList(int numberElements) {
        this.myArrayList = new Object[numberElements];


    }

   /* Constructs a list containing the elements of the specified collection.
    c – the collection whose elements are to be placed into this list*/
    public MyArrayNewList(Collection<? extends E> c) {
        Object[] tempArray = c.toArray();
        if ((tempArray.length) != 0) {
            myArrayList = tempArray;
            size = tempArray.length;
        }
        else {
            myArrayList = new Object[DEFAULT_SIZE];
        }


    }
    /*
     * 	This method returns the element corresponding to the index.
     */
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if(checkedElement(index)) {
            return (E) myArrayList[index];

        }
        else {
            System.out.println("Index out of list");
            return  null;
        }
    }

    //This method adds an element to the end of the list
    public void addElement(E e) {
        addElement(e,size);
    }

    //This method returns the number of elements in this array
    public int size() {
        return size;
    }

    /*This method adds element at the specified index
    and shifts the next elements one to the right*/
    public void addElement(E e, int index) {
        if(checkedElement(index)) {
           Object [] tempMyArrayList = myArrayList;
           int count = size;
           if(count ==tempMyArrayList.length)
               tempMyArrayList = grow();
           System.arraycopy(myArrayList,index,tempMyArrayList,index+1,count-index);
           tempMyArrayList[index] = e;
           size++;

        }
        else {
            System.out.println("Index out of list");
        }

    }

    /*this method removes the element at the specified index,
    shifts all following elements one to the left*/
    public void removeElement(int index) {
        if(checkedElement(index)) {
            if(size>1) {
                Object[] tempMyArrayList = myArrayList;
                int count = size;
                System.arraycopy(myArrayList, index + 1, tempMyArrayList, index, count - (index + 1));
                size--;
            }
            else
                removeAll();
        }
        else
            System.out.println("Index out of list");

    }

    /*This method removes all elements of the list.
    Creates a new list of size 10 */
    public void removeAll() {
        myArrayList = new Object[DEFAULT_SIZE];
        size =0;

    }

    //This method sorts the list using the standard array method
    @SuppressWarnings("unchecked")
    public  void sort(Comparator<? super E> c) {
        Arrays.sort((E[]) myArrayList, 0, size, c);

    }

    //This method replaces an element by index. The old element is overwritten
    public void set(Object e, int index) {
        if(checkedElement(index)) {
            Object [] tempMyArrayList = myArrayList;
            tempMyArrayList[index] = e;

        }
        else {
            System.out.println("Index out of list");
        }

    }
    //This method doubles the length of the list
    private Object[] grow() {
        return myArrayList = Arrays.copyOf(myArrayList,myArrayList.length*2);

    }

    //This method checks if the index is within the length range of the list
    private boolean checkedElement(int index) {
        if(index < myArrayList.length && index > -1)
            return true;
        else
            return false;
    }
}
