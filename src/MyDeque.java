import java.util.Deque;

public class MyDeque<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private int size = 0;
    private T[] array;
    private int first; // указатель начала
    private int last;  // указатель конца

    MyDeque() {
        array =(T[]) (new Object[DEFAULT_CAPACITY]);
    }

    MyDeque(int capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
            first = this.capacity/2;
            last = first+1;
        } else throw new IllegalArgumentException("Неверное значение для capacity");
        array = (T[]) (new Object[capacity]);
    }

    public int getSize() {
        return size;
    }

    public int getFirstIndex() {
        return first;
    }
    public int getLastIndex() {
        return last;
    }

    public void  insertLeft(T element) {
        if (isFull()){
            throw new ArrayIndexOutOfBoundsException("Переполнение!");
        } else {
            array[first] = element;
            size++;
            if (first-1 < 0) {
                first = array.length-1;
            } else first--;
        }
    }

    public void  insertRight(T element) {
        if (isFull()){
            throw new ArrayIndexOutOfBoundsException("Переполнение!");
        } else {
            array[last] = element;
            size++;
            if (last + 1 > array.length-1) {
                last = 0;
            } else last++;
        }
    }

    public T removeLeft() {
        first++;
        T value = array[first];
        array[first] = null;
        size--;
        return value;
    }

    public T removeRight() {
        T value;
        if (last == 0){
            value = array[array.length-1];
        } else {
            last--;
            value = array[last];
            array[last] = null;
            size--;
        }
        return value;
    }

    public T peekLeft() {
        return array[first + 1];
    }

    public T peekRight() {
        if (last == 0){
            return array[array.length-1];
        } else return array[last - 1];
    }

    public boolean isFull() {
        return (size == capacity);
    }
    public boolean isEmpty() {
        return (size == 0);
    }

    public void printAllElementDeque() {
        for (int i = 0; i < array.length; i++){
            if (array[i] != null) {
                    System.out.print(array[i] + ", ");
            }
        }
        System.out.println();
    }


}
