import javax.xml.soap.Node;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class ChainingHashMap<Key, Value> {
    private int capacity;
    private int size = 0; // количество объектов в карте

    private LinkedList<Node>[] st;

    public ChainingHashMap() { // конструктор класса-карты
        capacity = 7;
        st = new LinkedList[capacity]; // массив из связанных списков, размер массива =7,
        for (int i = 0; i < st.length; i++) {
            st[i] = new LinkedList<>(); // заполняем массив связанными списками, элементами списка будут узлы- node
        }
    }
    // ========== класс node ========
    private class Node {
        Key key;
        Value value;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }
    //=================================================
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public final int hash(Key key) { // хешфункция, находит индекс массива для вставки
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    private void isKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key == null");
        }
    }

    public void put(Key key, Value value) {
        isKeyNotNull(key);
        int i = hash(key);
        for (Node node : st[i]) {
            if (key.equals(node.key)) {
                node.value = value;
                return;
            }
        }
        st[i].addLast(new Node(key, value));
        size++;
    }

    public Value get(Key key) {
        isKeyNotNull(key);
        int i = hash(key);
        for (Node node : st[i]) {
            if (key.equals(node.key)) {
                return node.value;
            }
        }
        return null;
    }
// удаление по ключу
    public void remove(Key key) {
        isKeyNotNull(key);
        int i = hash(key);
        for (int j = 0; j < st[i].size(); j++) {
            Node current = st[i].get(j);
            if (current.key.equals(key)) {
                st[i].remove(current);
                size--;
                return;
            }
        }
        throw new NoSuchElementException("Нет такого элемента!");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < capacity; i++) {
            for (Node node : st[i]) {
                sb.append(node.key).append(", ");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
