public class LinkedQueue<T> {
    // На основе MyLinkedList

    private MyLinkedList<T> list;
    private int size = 0;

    LinkedQueue() {
        list = new MyLinkedList<>();
    }

    public int size() {
        return list.getSize();
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void enqueue(T value) {
        list.insertLast(value);
    }
    public T dequeue() {
        return list.removeFirstElement();
    }
    public T peek() {
        return list.getFirstValue();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
