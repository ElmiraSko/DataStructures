import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;

public class Main {
    public static void main(String[] args) {
        // Стек
        int k = 1;
        MyStack<Integer> stack = new MyStack<>(16);
        while (!stack.isFull()){
            stack.push(k*5);
            k++;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();

        // Пример с текстом
        ReverseReading read = new ReverseReading("Reading in reverse order.");
        read.reverse();


        // Очередь
        MyQueue<Integer> queue = new MyQueue<>(7);
        for (int i = 1; i < 5; i++) {
            queue.insert(i);
        }
        System.out.println("\n=========================");
        System.out.println(queue.remove() + " - первый элемент" );
        System.out.println(queue.remove() + " - второй элемент");
        System.out.println(queue.peek());
        System.out.println("=================");

        // Дэк
        MyDeque<Integer> deque = new MyDeque<>(10);

        deque.insertLeft(22);
        deque.insertLeft(44);
        deque.insertLeft(66);

        deque.insertRight(10);
        deque.insertRight(20);
        deque.insertRight(30);
        deque.insertRight(40);
        deque.insertRight(50);
        deque.insertRight(60);
        deque.insertRight(70);
//        deque.insertRight(80); получим Exception


        deque.printAllElementDeque();

        System.out.println(deque.peekLeft() + " - peekLeft()");
        System.out.println(deque.peekRight() + " -  peekRight()");
        System.out.println("----------------------------------");

        System.out.println(deque.removeLeft() + " - deque.removeLeft()");
        System.out.println(deque.removeRight() + " - deque.removeRight()");
        System.out.println("----------------------------------");

        deque.printAllElementDeque();

        System.out.println(deque.peekLeft() + " - peekLeft()");
        System.out.println(deque.peekRight() + " -  peekRight()");



    }
}

