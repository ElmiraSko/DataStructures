import java.util.ListIterator;

public class ListIteratorApp {
    public static void main(String[] args) {

        MyLinkedList<String> list = new MyLinkedList<>();
        list.insertLast("A");
//        list.insertLast("B");
//        list.insertLast("C");
//        list.insertLast("D");
        System.out.println(list.toString());


        System.out.println();
        ListIterator iter = list.listIterator();
        System.out.println(iter.hasNext());

        System.out.println(iter.hasPrevious());



        iter.add("h");
        System.out.println(list.toString());

    }
}
