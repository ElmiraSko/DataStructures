public class MyQueue<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private int size = 0;
    private T[] array;
    private int first = 0; // указатель начала
    private int last = 0;  // указатель конца

    MyQueue() {
        array =(T[]) (new Object[DEFAULT_CAPACITY]);
    }

    MyQueue(int capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
        } else throw new IllegalArgumentException("Неверное значение для capacity");
        array = (T[]) (new Object[capacity]);
    }

    public void insert(T element) {
        if (isFull()){
            throw new ArrayIndexOutOfBoundsException("Переполнение");
        } else {
            array[last] = element;
            size++;
            last = nextIndex(last);
        }
    }

    private int nextIndex(int index){
        return (index+1) % array.length;
    }

    public T remove() {
        T value = array[first];
        array[first] = null;
        size--;
        first = nextIndex(first);
        return value;
    }

    public T peek() {
        return array[first];
    }

    public boolean isFull() {
        return (size == capacity);
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int getSize() {
        return size;
    }



}

