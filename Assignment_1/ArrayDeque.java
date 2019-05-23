/**
 *Kevin Ramos
 * 111019436
 * CSE 214 (1)
 */

import java.util.NoSuchElementException;

public class ArrayDeque implements Deque {

    private int first;
    private int last;
    private int n;
    private int[] deque;

    public ArrayDeque(int num) {
        if(num == 0 ) num = 2;
        deque = new int[num];
        first = 0;
        last = 0;
        n = 0;
    }

    @Override
    public int getFirst() {
        if(n == 0) return -1;
        return deque[first];
    }

    @Override
    public int getLast() {
        if(n == 0) return -1;
        return deque[last];
    }

    @Override
    public int removeFirst() {
        if(n==0){
            throw new NoSuchElementException();
        }
        n --;
        first ++;

        return deque[first-1];
    }

    @Override
    public int removeLast() {
        if(n==0){
            throw new NoSuchElementException();
        }
        n--;
        last --;
        return deque[last + 1];
    }

    @Override
    public boolean addFirst(int x) {
        if(n == 0) {
            deque[first] = x;
            n++;
            return true;
        }

        if(first-1 < 0) {
            resize();
            last--;
        }
        first --;
        deque[first] = x;
        n++;
        return true;
    }

    @Override
    public boolean addLast(int x) {
        if(n == 0) {
            deque[last] = x;
            n++;
            return true;
        }

        if(last+1 > deque.length-1){
            resize();
            deque[last] = x;
            n++;
            return true;
        }

        last++;
        deque[last] = x;
        n++;
        return true;
    }

    public void resize() {
        int[] a = new int[deque.length*2];
        int newFirst = deque.length/2;
        int j= 0;
        for(int i=first; i<=last ; i++){
            a[newFirst + j] = deque[i];
            j++;
        }

        deque = a;
        first = newFirst;
        last = first + n;
    }

}
