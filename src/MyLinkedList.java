import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T>  implements Iterable<T>{

    private Element firstElement; // указатель на первый элемент
    private Element lastElement; // указатель на последний элемент
    private int size = 0;

    public MyLinkedList() {
    }

    public int getSize() {
        return size;
    }

    private Element getFirstElement() {
        return firstElement;
    }
    // Для очереди
    public T getFirstValue() {
        return isEmpty() ? null: getFirstElement().value;
    }

// Вставка в начало
    public void insertFirst(T value) {
        Element e = new Element(value);
        if (isEmpty()) {
            firstElement = e;
            lastElement = e;
            size++;
        } else {
            firstElement.previous = e;
            e.next = firstElement;
            firstElement = e;
            size++;
        }
    }
// Вставка в конец
    public void insertLast(T value) {
        Element e = new Element(value);
        if (isEmpty()) {
            firstElement = e;
            lastElement = e;
            size++;
        } else {
            lastElement.next = e;
            e.previous = lastElement;
            lastElement = e;
            size++;
        }
    }

    // Вставка элемента по индексу
    public void insertElement(T value, int index) {
        if (index >= size) { // если индекс больше количества элементов
            insertLast(value);
        } else if (index >= size/2) {
            Element newElement = new Element(value);
            Element current = lastElement;
            int ind = size-1;
            while (ind >= size/2) {
                if (index == ind) {
                    newElement.next = current;
                    newElement.previous = current.previous;
                    current.previous.next = newElement;
                    size++;
                    break;
                }
                current = current.previous;
                ind--;
            }
        } else if (index > 0) {
            Element newElement = new Element(value);
            Element current = firstElement;
            int ind = 0;
            while (ind <= size/2) {
                if (index == ind) {
                    newElement.next = current;
                    newElement.previous = current.previous;
                    current.previous.next = newElement;
                    size++;
                    break;
                }
                current = current.next;
                ind++;
            }
        } else  if (index == 0) {
            insertFirst(value);
        } else throw new IndexOutOfBoundsException("Отрицательный индекс!");
    }

    // Удаление первого элемента
    public T removeFirstElement() {
        if (isEmpty()){
            return null;
        }
        Element current = firstElement;
        firstElement = firstElement.next;
        if (isEmpty()) {
            lastElement = null;
        } else
            firstElement.previous = null;
        size--;
        return current.value;
    }
    // Удаление последнего элемента
    public T removeLastElement() {
        if (isEmpty()){
            return null;
        }
        Element current = lastElement;
        lastElement = lastElement.previous;
        if (lastElement == null) {
            firstElement = null;
        } else
            lastElement.next = null;
        size--;
        return current.value;
    }

// Удаление элемента по значению
    public void removeElement(T value) {
        if (isEmpty()) {
            throw new NoSuchElementException(" No elements!");
        }
        if (firstElement.value.equals(value)) {
            removeFirstElement();
        } else {
            Element current = firstElement; // текущий элемент - первый
            if (current.next == null) { // если current - последний элемент, значит совпадений нет
//                throw new NoSuchElementException(" No such element " + value);
                System.out.println("No such element - " + value);
            }
            while (current.next != null) { // сравниваем со следующим
                if (current.next.value.equals(value)) {
                    current.next = current.next.next;
                    size--;
                    break;
                }
                current = current.next;
                if (current.next == null) { // если current - последний элемент, значит совпадений нет
//                throw new NoSuchElementException(" No such element " + value);
                    System.out.println("No such element - " + value);
                }
            }
        }
    }


    public boolean isEmpty() {
        return firstElement == null;
    }

    public int indexOf(T value) { // индекс элемента
        int index = 0;
        Element current = firstElement;
        while (current != null) {
            if (current.value.equals(value))
                return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean isContains(T val) {
        return indexOf(val) > -1;
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "[ ]";
        StringBuilder sb = new StringBuilder("[ ");
        Element current = firstElement; // текущий
        while (current.next != null) {
            sb.append(current.value.toString()).append(", ");
            current = current.next;
        }
        sb.append(current.value.toString()).append(" ]");
        return sb.toString();
    }

    // Метод возвращает итератор MyIterator
    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    // Метод возвращает итератор ListIterator
    public ListIterator listIterator() {
        return new MyListIterator(this);
    }

    // Внутренние классы
    private class MyIterator  implements Iterator<T>{
        Element current = new Element(null);

        MyIterator() {
            current.next = firstElement;
        }

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public T next() {
            current = current.next;
            return current.value;
        }
    }

    private class MyListIterator  implements ListIterator<T> {

        Element current = new Element(null);
        MyLinkedList myList;
        MyListIterator(MyLinkedList list) {
            current.next = firstElement;
            myList = list;
        }

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public T next() {
            current = current.next;
            return current.value;
        }

        @Override
        public boolean hasPrevious() {
            return current.previous != null;
        }

        @Override
        public T previous() {
            current = current.previous;
            return current.value;
        }

        public Element nextElement() {
            return current = current.next;
        }
        public Element prevElement() {
            return current = current.previous;
        }


        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(T t) {

        }

        @Override
        public void add(T t) {
            Element newEl = new Element(t);
            if (current.next == null) {
                insertFirst(t);
                current = current.previous;
            } else {
                newEl.previous = current.previous;
                newEl.next = current.next;
                current.previous = newEl;
                current = current.next;
                size++;
            }
        }
    }

        private class Element {
        private T value;
        Element next;
        Element previous;

        Element(T value) {
            this.value = value;
        }
    }
}

