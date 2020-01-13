public class LinkedStack<T> {
    // Стек на основе OneLinkedList
    private OneLinkedList<T> list;

    LinkedStack() {
        list = new OneLinkedList<>();
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.getSize();
    }

    public void push(T value) {
        list.insertFirst(value);
    }

    public T pop() {
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

