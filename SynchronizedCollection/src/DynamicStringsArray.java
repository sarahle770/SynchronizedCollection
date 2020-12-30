import java.util.Arrays;

/**
 * This file is a part of SynchronizedCollection project.
 *
 * @author Sarah Cynamon
 * @version 1.0.0
 */
public class DynamicStringsArray {
    public String[] data;
    public int size;
    public int strategy;
    public static final int STRATEGY_DOUBLE = 0;
    public static final int STRATEGY_50 = 1;
    public static final int CAPACITY_DEFAULT = 5;

    public DynamicStringsArray(int capacity, int strategy) {
        //capacity describe the length of data
        this.data = new String[capacity];
        this.strategy = strategy;
    }

    public DynamicStringsArray() {
        int size = 6;
        int strategy = 4;
    }

    private String[] copy(String[] dest, int count) {
        dest = new String[data.length];
        for (int i = 0; i < dest.length; i++) {
            dest[i] = data[i];
        }
        return dest;
    }

    private void changeCapacity(int capacity) {
        String[] newArray = Arrays.copyOf (data, capacity);
    }

    private int getGrowCapacity() {
        if (STRATEGY_50 == 1) {
            return (size * 50) / 100;
        } else if (STRATEGY_DOUBLE == 0) {
            return (size * 2);
        }
        return size;
    }

    private void grow() {
        while (strategy == 0) {
            size = data.length * 2;
            data = new String[size];
        }
        while (strategy == 1) {
            size = (data.length * 50) / 100;
            data = new String[size];
        }
    }

    public synchronized void add(String element) {
        data = new String[size + 1];
        for (int i = 0; i < size; i++) {
            data[size] = element;
        }
    }

    public synchronized void remove(int index) throws ArrayIndexOutOfBoundsException {
        if (data == null || index < 0 || index >= data.length) {
            throw new ArrayIndexOutOfBoundsException ("Sorry Invalid index");
        }
        String[] newArray = new String[data.length - 1];
        for (int i = 0, j = 0; i < data.length; i++) {
            if (i != index) {
                continue;
            }
            newArray[j++] = data[i];
        }
    }

    public synchronized int indexOf(String element) {
        if (data == null) {
            return -1;
        }
        int length = data.length;
        int i = 0;
        while (i < length) {
            if (data[i].equals (element)) {
                return i;
            } else {
                i = i + 1;
            }
        }
        return -1;
    }

    public synchronized void remove(String element) {
        int removeIndex = indexOf (element);
        if (data.length - 1 - removeIndex >= 0)
            System.arraycopy (data, removeIndex + 1, data, removeIndex, data.length - 1 - removeIndex);
    }

    public synchronized void clip() {
        int nullCount = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null)
                nullCount++;
        }
        String[] newArray = new String[data.length - nullCount];
        int j = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) newArray[j++] = data[i];
        }
    }

    public synchronized boolean contains(String element) throws NullPointerException {
        if (element == null)
            throw new NullPointerException ("Wrong value");
        return indexOf (element.toString ()) > -1;
    }

    public synchronized boolean isEmpty() {
        return data.length == 0;
    }

    public synchronized void clear() {
        // To fill my complete data array with a particular value (null)
        Arrays.fill (data, null);
    }

    public synchronized void clear(boolean clip) {
        Arrays.fill (data, null);
        if (clip) {
            clip ();
        }
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStrategy() {
        return strategy;
    }

    public void setStrategy(int strategy) {
        this.strategy = strategy;
    }

    public static int getStrategyDouble() {
        return STRATEGY_DOUBLE;
    }

    public static int getStrategy50() {
        return STRATEGY_50;
    }

    public static int getCapacityDefault() {
        return CAPACITY_DEFAULT;
    }

    @Override
    public String toString() {
        return "DynamicStringsArray{" +
                "Data: " + Arrays.toString (data) +
                "Size: " + size +
                "Strategy: " + strategy;
    }
}






