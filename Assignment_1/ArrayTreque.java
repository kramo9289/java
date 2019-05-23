/**
 *Kevin Ramos
 * 111019436
 * CSE 214 (1)
 */
import java.util.NoSuchElementException;

public class ArrayTreque implements Treque{

    private int[] treque;
    private int n;
    private int first;

    public ArrayTreque(int num) {
        treque = new int[num];
        n = 0;
        first = 0;
    }


    @Override
    public boolean addFirst(int x) {

        if(n >= treque.length) {
            resize();
        }

        for( int i=n+first; i>first; i--) {
            treque[i] = treque[i-1];
        }

        treque[first] = x;
        n++;

        return true;
    }

    @Override
    public boolean addLast(int x) {

        if(n >= treque.length) {
            resize();
        }

        for(int i=first-1; i>n; i++) {
            treque[i] = treque[i+1];
        }

        treque[first + n] = x;
        n++;

        return true;
    }

    @Override
    public boolean addMid(int x) {

        if(n >= treque.length) {
            resize();
        }

        int mid = (first + n)/2;

        for(int i=n+first ; i>mid; i--) {
            treque[i] = treque[i-1];
        }
        treque[mid] = x;
        n++;
        return true;
    }

    @Override
    public int removeFirst() {
        if(n == 0){
            throw new NoSuchElementException();
        }

        int x = treque[first];

        for(int i=1; i<n; i++) {
            treque[i-1]=treque[i];
        }

        n--;

        return x;
    }

    @Override
    public int removeLast() {
        if(n == 0){
            throw new NoSuchElementException();
        }

        int x = treque[first + n -1];
        n--;

        return x;
    }

    @Override
    public int removeMid() {
        int mid = (first + n)/2;

        int x = treque[mid];


        for(int i=mid; i<n-first; i++) {
            treque[i] = treque[i+1];
        }

        n--;
        return x;
    }

    public void resize() {
        int[] a = new int[Math.max(n*2, 1)];

        for(int i=0; i<n; i++) {
            a[i] = treque[i];
        }

        treque = a;
    }
}
