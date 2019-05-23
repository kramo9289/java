import java.util.ArrayList;

/**
 *Kevin Ramos
 * 111019436
 * CSE 214 (4)
 */

public class DirectAddressTable<V extends Hashable> implements Dictionary<V> {

    private ArrayList<V> addressTable;
    private int itemsInList;

    public DirectAddressTable() {
        addressTable = new ArrayList<>();
        for(int i=0; i<26; i++) addressTable.add(null);
        itemsInList = 0;
    }

    @Override
    public boolean isEmpty() {
        return (itemsInList==0) ? true : false;
    }

    @Override
    public void insert(V value) {

        if(value != null) {
            itemsInList++;
            addressTable.set(value.hash(), value);
        }else {
            throw new NullPointerException("The value is null");
        }
    }

    @Override
    public V delete(V value) {
        if(value != null) {
            if(addressTable.get(value.hash()) != null) {
                itemsInList--;
                addressTable.set(value.hash(), null);
                return value;
            }else {
                return null;
            }
        }
        else throw new NullPointerException("The value is null");
    }

    @Override
    public V find(int key) {
        return (addressTable.get(key) != null) ? addressTable.get(key) : null;
    }

    @Override
    public String toString() {
        String s = "";
        for(int i=0; i<addressTable.size(); i++){
            if(addressTable.get(i) != null)
            s+= (i + " -- " + addressTable.get(i).toString() + "\n");
            else
                s+= (i + " -- null \n");
        }
        return s;
    }
}
