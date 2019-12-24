public class MyStack<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private int size = 0;
    private T[] array;

    MyStack() {
        array =(T[]) (new Object[DEFAULT_CAPACITY]);
    }

    MyStack(int capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
        } else throw new IllegalArgumentException("Неверное значение для capacity");
        array = (T[]) (new Object[capacity]);
    }

    public int getSize() {
        return size;
    }
// вставка элемента
    public void push(T element) {
        if (!isFull()){
            array[size] = element;
            size++;
        } else {
            capacity = (int)(capacity*1.5);
            T[] arrayNew = (T[])new Object[capacity];
            System.arraycopy(array, 0, arrayNew, 0 , size);
            array = arrayNew;
            array[size] = element;
            size++;
        }
    }
// вставка удаление
    public T pop() {
        size--;
        T value = array[size];
        array[size] = null;
        return value;
    }

    public T peek() {
        return array[size-1];
    }

    public boolean isFull() {
        return (size == capacity);
    }

    public boolean isEmpty() {
        return (size == 0);
    }

}


