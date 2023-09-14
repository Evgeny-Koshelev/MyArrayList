package com.ats;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickSorterTest {

    private final Integer [] array = new Integer[]{5,8,3,7,5};
    private final String [] array1 = new String[]{"hello", "hi","java","world", "hi"};

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
        QuickSorter<String> quickSorter = new QuickSorter<>();
        quickSorter.sort(myArrayNewList1,comparatorStr);
        QuickSorter<Integer> quickSorterInt = new QuickSorter<>();
        quickSorterInt.sort(myArrayNewListInteger,comparatorInt);

        Integer [] checkArrInt = new Integer[]{3,5,5,7,8};
        String [] checkArrStr = new String[]{"hello","hi","hi","java","world"};
        for (int i = 0; i < 5;i++) {
            assertEquals(checkArrStr[i],myArrayNewList1.get(i));
            assertEquals(checkArrInt[i], myArrayNewListInteger.get(i));
        }

    }

}
