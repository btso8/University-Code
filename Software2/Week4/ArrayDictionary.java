package University-Code.Software2.Week4;
import java.util.ArrayList;

public class ArrayDictionary {

    int buffer, nextFreeSlot;
    Integer[] keys;
    String[] values;
    public ArrayDictionary(){
        this(100);
    }

    public ArrayDictionary(int size){
        buffer = size;
        nextFreeSlot = 0;
        keys = new Integer[size];
        values = new String[size];
    }

    @Override
    public String toString(){
        StringBuffer output= new StringBuffer("{");
        for (int i = 0; i < nextFreeSlot - 1; i++) {
            output.append(keys[i]+":"+values[i]+", ");
        }
        if(nextFreeSlot - 1 >= 0){
            output.append(keys[nextFreeSlot - 1]+":"+values[nextFreeSlot - 1]);
        }
        output.append("}");
        return output.toString();
    }

    public int size(){
        return nextFreeSlot;
    }

    @Override
    public boolean equals(Object other){
        if(other == this){
            return true;
        } else if(!(other instanceof ArrayDictionary)){
            return false;
        }
        ArrayDictionary dico = (ArrayDictionary) other;
        if(this.size() != dico.size()){
            return false;
        }
        for (int i = 0; i < nextFreeSlot; i++) {
            if(!values[i].equals(dico.get(keys[i]))){
                return false;
            }
        }
        return true;
    }

    public String put(Integer key, String value){
        if(key == null || value == null){
            return null;
        }
        for (int i = 0; i < nextFreeSlot; i++) {
            if(key.equals(keys[i])){
                String old = values[i];
                values[i] = value;
                return old;
            }
        }
        if(nextFreeSlot < keys.length){
            keys[nextFreeSlot] = key;
            values[nextFreeSlot] = value;
            nextFreeSlot++;
            return null;
        } else {
            Integer[] newKeys = new Integer[keys.length + buffer];
            String[] newValues = new String[values.length + buffer];
            for (int i = 0; i < nextFreeSlot; i++) {
                newKeys[i] = keys[i];
                newValues[i] = values[i];
            }  
            newKeys[nextFreeSlot] = key;
            newValues[nextFreeSlot] = value;
            nextFreeSlot++;
            keys = newKeys;
            values = newValues;
            return null;
        }
    }

    public String get(Integer key){
        if(key == null){
            return null;
        }
        for (int i = 0; i < nextFreeSlot; i++) {
            if(key.equals(keys[i])){
                return values[i];
            }
        }
        return null;
    }

    public ArrayList<Integer> keys(){
        ArrayList<Integer> allKeys = new ArrayList<>();
        for (Integer key : keys) {
            allKeys.add(key);
        }
        return allKeys;
    }

    public String remove(Integer key){
        if (key == null){
            return null;
        }
        String old = null;
        int index = -1;
        for (int i = 0; i < nextFreeSlot; i++) {
            if(key.equals(keys[i])){
                old = values[i];
                index = i;
                break;
            }
        }
        if(index < 0){
            return null;
        } else if (index == nextFreeSlot - 1){
            keys[index] = null;
            values[index] = null;
            nextFreeSlot--;
            return old;
        } else { 
            keys[index] = keys[nextFreeSlot - 1];
            values[index] = values[nextFreeSlot - 1];
            keys[nextFreeSlot - 1] = null;
            values[nextFreeSlot - 1] = null;
            nextFreeSlot--;
            return old;
        }

    }

    public ArrayList<String> values(){
        ArrayList<String> allValues = new ArrayList<>();
        for (String value : values) {
            allValues.add(value);
        }
        return allValues;
    }

    public void clear(){
        keys = new Integer[buffer];
        values = new String[buffer];
        nextFreeSlot = 0;
    }

    public static void main(String[] args) {
        ArrayDictionary dico = new ArrayDictionary(4);
        for (int i = 0; i < 12; i++) {
            dico.put(i, Integer.toString(i));
        }
        System.out.println(dico);
        System.out.println(dico.get(11));
        System.out.println(dico.get(12));
        dico.clear();
        System.out.println(dico);
        for (int i = 12; i < 20; i++) {
            dico.put(i, Integer.toString(i));
        }
        System.out.println(dico);
        System.out.println(dico.get(11));
        System.out.println(dico.get(12));
        System.out.println(dico.get(19));
        System.out.println(dico.get(20));
        System.out.println(dico.remove(15));
        System.out.println(dico);
        System.out.println(dico.remove(18));
        System.out.println(dico);
        System.out.println(dico.remove(12));
        System.out.println(dico);
        for (Integer key : dico.keys()) {
            dico.remove(key);
        }
        System.out.println(dico);
        ArrayDictionary other = new ArrayDictionary(7);
        System.out.println(other.equals(dico));
        dico.put(5, "5");
        dico.put(25, "25");
        dico.put(15, "15");
        other.put(25, "25");
        other.put(5, "5");
        other.put(15, "15");
        System.out.println(other.equals(dico));
        other.put(15,"fifteen");
        System.out.println(other.equals(dico));
    }
}
