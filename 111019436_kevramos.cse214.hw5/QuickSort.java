/**
 *Kevin Ramos
 * 111019436
 * CSE 214 (5)
 */
import java.util.Comparator;
import java.util.List;

public class QuickSort<T extends Comparable<T>> implements NaturalOrderSorting<T> {

    public static void main(String[] args) {
        int[] a = new int[]{1,26,7,8,9,5,34,3,323};
        toString(sort(a));
    }
    
    public void toString(int[] a) {
        for (int arrInt : a) {
            System.out.println(arrInt);
        }
    }

    @Override
    public void sort(List<? extends T> list) {
        quickSort(list, 0, list.size()-1);
    }

    public <E extends T>void quickSort(List<E> list, int firstIndex, int lastIndex){
        if(firstIndex >= lastIndex) return;
        int leftIndex = firstIndex;
        int rightIndex = lastIndex;
        E pivot = list.get((firstIndex + lastIndex)/2);
        while (leftIndex <= rightIndex){
            while(list.get(leftIndex).compareTo(pivot) < 0) {
                leftIndex ++;
            }
            while(list.get(rightIndex).compareTo(pivot) > 0) {
                rightIndex --;
            }
            if(leftIndex <= rightIndex){
                E temp = list.get(leftIndex);
                list.set(leftIndex, list.get(rightIndex));
                list.set(rightIndex, temp);
                leftIndex++;
                rightIndex--;
            }
        }
        quickSort(list, firstIndex, rightIndex);
        quickSort(list, leftIndex, lastIndex);
    }

    public static class Unnatural<E> implements TotalOrderSorting<E> {
        @Override
        public void sort(List<? extends E> list, Comparator<E> c) {
            quickSort(list, 0, list.size()-1, c);
        }

        public <V extends E>void quickSort(List<V> list, int firstIndex, int lastIndex, Comparator<E> c){
            if(firstIndex >= lastIndex) return;
            int leftIndex = firstIndex;
            int rightIndex = lastIndex;
            E pivot = list.get((firstIndex + lastIndex)/2);
            while (leftIndex <= rightIndex){
                while(c.compare(list.get(leftIndex), pivot) < 0) {
                    leftIndex ++;
                }
                while(c.compare(list.get(rightIndex), pivot) > 0) {
                    rightIndex --;
                }
                if(leftIndex <= rightIndex){
                    V temp = list.get(leftIndex);
                    list.set(leftIndex, list.get(rightIndex));
                    list.set(rightIndex, temp);
                    leftIndex++;
                    rightIndex--;
                }
            }
            quickSort(list, firstIndex, rightIndex, c);
            quickSort(list, leftIndex, lastIndex, c);
        }
    }
}