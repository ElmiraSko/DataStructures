import java.util.NoSuchElementException;

public class OneLinkedList<T>{

    private Element firstElement; // указатель на первый элемент
    private int size = 0;

    public OneLinkedList() {
    }

    public void insertFirst(T value) {
        Element e = new Element(value); //  создаем узел-элемент и передаем ему значение
        e.next = firstElement; // ссылке на следующий за ним элемент присваиваем - firstElement (изначально null)
        firstElement = e;  // указатель указывает на новый элемент
        size++;
    }
    public T removeFirstElement() {
        if (isEmpty()){
            return null;
        }
        Element current = firstElement;
        firstElement = firstElement.next;
        size--;
        return current.value;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return firstElement == null;
    }

    private Element getFirstElement() {
        return firstElement;
    }
    // Для стека
    public T getFirstValue() {
        return isEmpty() ? null: getFirstElement().value;
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

    // Вставка нового элемента по указанному индексу
    public void insert(T value, int index) {
        if (isEmpty() || index == 0) { // если список пустой или индекс равен нулю
            insertFirst(value);
        } else { // если список не пустой и индекс меньше количества элементов
            Element newElement = new Element(value);
            int currentInd = 0;
            Element current = firstElement;
            while (current != null && index < size) {
                if (index == currentInd + 1) {
                    newElement.next = current.next;
                    current.next = newElement;
                    size++;
                    break;
                }
                current = current.next;
                currentInd++;
            }
            if (index >= size){ // если указанный индекс больше размера списка
                while (current.next != null) { // дошли до конца списка, получили последний элемент
                    current = current.next;
                }
                newElement.next = null;
                current.next = newElement;
                size++;
            }
        }
    }
    // Удаление указанного элемента
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
            while (current.next!= null) { // сравниваем со следующим
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
    // внутренний класс
    private class Element {
        private T value;
        Element next;
        Element(T value) {
            this.value = value;
        }
    }
}
