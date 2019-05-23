 /**
 *Kevin Ramos
 * 111019436
 * CSE 214 (5)
 */
import java.util.Comparator;
import java.util.List;

public interface TotalOrderSorting<E> {
    public void sort(List<? extends E> list, Comparator<E> c);
}
