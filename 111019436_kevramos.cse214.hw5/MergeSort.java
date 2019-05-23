 /**
 *Kevin Ramos
 * 111019436
 * CSE 214 (5)
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Ritwik Banerjee
 */
public class MergeSort<T extends Comparable<T>> implements NaturalOrderSorting<T> {
    @Override
    public void sort(List<? extends T> list) {
            mergeSort(list, 0, list.size());
    }


    private <E extends T>void mergeSort(List<E> list, int firstIndex, int listSize){
        if(listSize > 1) {
            int firstHalf = listSize / 2;
            int secondHalf = listSize - firstHalf;

            mergeSort(list, firstIndex, firstHalf);
            mergeSort(list, firstIndex+firstHalf, secondHalf);

            merge(list, firstIndex, firstHalf, secondHalf);
        }

    }

    private <E extends T>void merge(List<E> list, int firstIndex, int firstHalf, int secondHalf) {
        int secondIndex = firstIndex + firstHalf;
        List<E> tempList = new ArrayList<>();

        int i=firstIndex;
        int j=secondIndex;

        while(i < firstHalf+firstIndex && j < secondIndex + secondHalf){
            if(list.get(i).compareTo(list.get(j)) >= 0){
                tempList.add(list.get(j));
                j++;
            }
            else {
                tempList.add(list.get(i));
                i++;
            }
        }
        while(i< firstHalf + firstIndex){
            tempList.add(list.get(i));
            i++;
        }
        while(j< secondHalf + secondIndex) {
            tempList.add(list.get(j));
            j++;
        }

        for(int k=0; k<tempList.size(); k++){
            list.set(k+firstIndex, tempList.get(k));
        }
    }

    public static class Unnatural<E> implements TotalOrderSorting<E> {
        @Override
        public void sort(List<? extends E> list, Comparator<E> c) {
            mergeSort(list, 0, list.size(), c);
        }

        private <T extends E>void mergeSort(List<T> list, int firstIndex, int listSize, Comparator<E> c){
            if(listSize > 1) {
                int firstHalf = listSize / 2;
                int secondHalf = listSize - firstHalf;

                mergeSort(list, firstIndex, firstHalf, c);
                mergeSort(list, firstIndex+firstHalf, secondHalf, c);

                merge(list, firstIndex, firstHalf, secondHalf, c);
            }

        }

        private <T extends E>void merge(List<T> list, int firstIndex, int firstHalf, int secondHalf, Comparator<E> c) {
            int secondIndex = firstIndex + firstHalf;
            List<T> tempList = new ArrayList<>();

            int i=firstIndex;
            int j=secondIndex;

            while(i < firstHalf+firstIndex && j < secondIndex + secondHalf){
                if(c.compare(list.get(i),list.get(j)) >= 0){
                    tempList.add(list.get(j));
                    j++;
                }
                else {
                    tempList.add(list.get(i));
                    i++;
                }
            }
            while(i< firstHalf + firstIndex){
                tempList.add(list.get(i));
                i++;
            }
            while(j< secondHalf + secondIndex) {
                tempList.add(list.get(j));
                j++;
            }

            for(int k=0; k<tempList.size(); k++){
                list.set(k+firstIndex, tempList.get(k));
            }
        }
    }
}