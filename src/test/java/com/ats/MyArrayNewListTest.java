package com.ats;


import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class MyArrayNewListTest {

    private final Integer [] array = new Integer[]{5,8,3,7,5};
    private final String [] array1 = new String[]{"hello", "hi","java","world", "hi"};
    @Test
    public void testAddElement() {
        MyArrayNewList<String> myArrayNewList1 = new MyArrayNewList<>();
        myArrayNewList1.addElement("hello");
        myArrayNewList1.addElement("hi");
        myArrayNewList1.addElement("java");
        myArrayNewList1.addElement("world");
        myArrayNewList1.addElement("hi");
        MyArrayNewList <Integer> myArrayNewList = new MyArrayNewList<>();
        myArrayNewList.addElement(5);
        myArrayNewList.addElement(8);
        myArrayNewList.addElement(3);
        myArrayNewList.addElement(7);
        myArrayNewList.addElement(5);

        MyArrayNewList<Object> objectMyArrayNewList = new MyArrayNewList<>();
        for (int i = 0; i < 1000; i++) {
            objectMyArrayNewList.addElement(new Object());
        }


        for (int i = 0; i < 5;i++) {
            assertEquals(array[i],myArrayNewList.get(i));
            assertEquals(array1[i], myArrayNewList1.get(i));
        }


    }

    @Test
    public void testAddElementByIndex() {
        MyArrayNewList<String> myArrayNewList1 = new MyArrayNewList<>();
        myArrayNewList1.addElement("hello");
        myArrayNewList1.addElement("hi");
        myArrayNewList1.addElement("world");
        myArrayNewList1.addElement("hi");
        MyArrayNewList <Integer> myArrayNewList = new MyArrayNewList<>();
        myArrayNewList.addElement(8);
        myArrayNewList.addElement(3);
        myArrayNewList.addElement(7);
        myArrayNewList.addElement(5);

        myArrayNewList1.addElement("java",2);
        myArrayNewList.addElement(5,0);

        for (int i = 0; i < 5;i++) {
            assertEquals(array[i],myArrayNewList.get(i));
            assertEquals(array1[i], myArrayNewList1.get(i));
        }


    }

    @Test
    public void testGetElementByIndex() {
        MyArrayNewList<String> myArrayNewList1 = new MyArrayNewList<>();
        myArrayNewList1.addElement("hello");
        myArrayNewList1.addElement("hi");
        myArrayNewList1.addElement("java");
        myArrayNewList1.addElement("world");
        myArrayNewList1.addElement("hi");
        MyArrayNewList <Integer> myArrayNewList = new MyArrayNewList<>();
        myArrayNewList.addElement(5);
        myArrayNewList.addElement(8);
        myArrayNewList.addElement(3);
        myArrayNewList.addElement(7);
        myArrayNewList.addElement(5);


        String string = "world";
        Integer integer = 8;
        assertEquals(string,myArrayNewList1.get(3));
        assertEquals(integer,myArrayNewList.get(1));



    }

    @Test
    public void testSize() {
        MyArrayNewList<String> myArrayNewList1 = new MyArrayNewList<>();
        myArrayNewList1.addElement("hello");
        myArrayNewList1.addElement("hi");
        myArrayNewList1.addElement("java");
        myArrayNewList1.addElement("world");
        myArrayNewList1.addElement("hi");
        MyArrayNewList <Integer> myArrayNewList = new MyArrayNewList<>();
        myArrayNewList.addElement(5);
        myArrayNewList.addElement(8);
        myArrayNewList.addElement(3);
        myArrayNewList.addElement(7);


        assertEquals(5,myArrayNewList1.size());
        assertEquals(4,myArrayNewList.size());



    }
    @Test
    public void testRemoveElementByIndex() {
        MyArrayNewList<String> myArrayNewList1 = new MyArrayNewList<>(List.of(array1));
        MyArrayNewList<Integer> myArrayNewListInteger = new MyArrayNewList<>();
        myArrayNewListInteger.addElement(7);
        myArrayNewList1.removeElement(2);
        myArrayNewListInteger.removeElement(0);
        assertNull(myArrayNewListInteger.get(0));
        String [] array11 = {"hello", "hi","world", "hi"};
        for (int i = 0; i < myArrayNewList1.size();i++) {
            assertEquals(array11[i], myArrayNewList1.get(i));
        }



    }

    @Test
    public void testRemoveAllElements() {
        MyArrayNewList<String> myArrayNewList1 = new MyArrayNewList<>(List.of(array1));
        myArrayNewList1.removeAll();
        assertNull(myArrayNewList1.get(0));
        assertEquals(myArrayNewList1.size(),0);
    }

    @Test
    public void testSet() {
        MyArrayNewList<String> myArrayNewList1 = new MyArrayNewList<>(List.of(array1));
        MyArrayNewList<Integer> myArrayNewListInteger = new MyArrayNewList<>(List.of(array));
        myArrayNewList1.set("qwerty",3);
        myArrayNewListInteger.set(22,1);
        Integer [] checkArrInt = new Integer[]{5,22,3,7,5};
        String [] checkArrStr = new String[]{"hello", "hi","java","qwerty", "hi"};
        for (int i = 0; i < 5;i++) {
            assertEquals(checkArrStr[i],myArrayNewList1.get(i));
            assertEquals(checkArrInt[i], myArrayNewListInteger.get(i));
        }

    }

    @Test
    public void testSort() {
        MyArrayNewList<String> myArrayNewList1 = new MyArrayNewList<>(List.of(array1));
        MyArrayNewList<Integer> myArrayNewListInteger = new MyArrayNewList<>(List.of(array));
        Comparator<String> comparatorStr = new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        Comparator<Integer> comparatorInt = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        myArrayNewList1.sort(comparatorStr);
        myArrayNewListInteger.sort(comparatorInt);
        Integer [] checkArrInt = new Integer[]{3,5,5,7,8};
        String [] checkArrStr = new String[]{"hello","hi","hi","java","world"};
        for (int i = 0; i < 5;i++) {
            assertEquals(checkArrStr[i],myArrayNewList1.get(i));
            assertEquals(checkArrInt[i], myArrayNewListInteger.get(i));
        }

    }



}
