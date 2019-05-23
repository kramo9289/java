/**
 *Kevin Ramos
 * 111019436
 * CSE 214 (1)
 */
public class ArrayUtils {

    static void rotate(int[] a, int r) {
       for(int i=0; i<r%a.length; i++) {
           for(int j=a.length-1; j>0; j--){
               int tmp = a[j];
               a[j] = a[j-1];
               a[j-1] = tmp;
           }
       }
    }

    static void rotate(char[] a, int r) {
        for(int i=0; i<r%a.length; i++) {
            for(int j=a.length-1; j>0; j--){
                char tmp = a[j];
                a[j] = a[j-1];
                a[j-1] = tmp;
            }
        }
    }

    static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        for(int i=0; i<a.length; i++) {
            c[i] = a[i];
        }
        for(int i=0; i<b.length; i++) {
            c[i+a.length] = b[i];
        }
        return c;

    }
}
