package com.ats;

import java.util.Comparator;

/*This class is an implementation of the quicksort algorithm.
 * For sort this class uses quick sort.
 * This method of sort includes some steps:
 * 1.Choose an element from an array;
 * 2.Rearrange the elements in the array in such a way
 * that elements less than the chosen element are placed before it
 * and those greater than or equal to it are placed after it;
 * 3.Recursively apply the first two steps to the two subarrays
 * to the left and right of the chosen element.
 */
public class QuickSorter <E>{

    /* This method takes an array list and comparator
     * for rules of sort. If length of an array is equal one, then sorting ends.
     */
    public void sort(MyArrayNewList<E> sortMyArrayList, Comparator<E> comparator) {

        int number = sortMyArrayList.size();
        if(number > 1)
        {

            algorithmQuickSort(sortMyArrayList, 0, number-1, comparator);

        }
    }

    /* This method takes an  array list and comparator.
     * This method choose element from an array
     * and compares the other elements with this element. Less - to left,
     *  greater - to right. Thus, two subarrays are formed.
     *  Then everything is repeated with subarrays.
     */
    private void algorithmQuickSort(MyArrayNewList<E> myArrayNewList, int first, int last, Comparator<E> comparator)
    {
        if (first < last)
        {
            int left = first, right = last;
            E middleElement = (E) myArrayNewList.get((left + right) / 2);
            do
            {
                while (comparator.compare(myArrayNewList.get(left),middleElement) < 0)
                {
                    left++;
                }
                while (comparator.compare(myArrayNewList.get(right),middleElement) > 0)
                {

                    right--;
                }
                if (left <= right)
                {
                    Object tmp = myArrayNewList.get(left);
                    myArrayNewList.set(myArrayNewList.get(right),left);
                    myArrayNewList.set(tmp,right);
                    left++;
                    right--;
                }
            }
            while (left <= right);
            algorithmQuickSort(myArrayNewList, first, right, comparator);
            algorithmQuickSort(myArrayNewList, left, last, comparator);
        }
    }
}
