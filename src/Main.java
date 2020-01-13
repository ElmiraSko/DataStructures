import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Работа двусвязного списка MyLinkedList ===");
        MyLinkedList<String> list = new MyLinkedList<>();

        list.insertFirst("AA");
        list.insertFirst("BB");
        list.insertFirst("CC");
        list.insertFirst("DD");

        list.insertLast("X");
        list.insertLast("Y");
        list.insertLast("Z");
        System.out.println("Содержимое списка: " + list.toString());

        list.removeFirstElement();

        list.removeLastElement();
        list.removeLastElement();
        System.out.println("После удаления: " + list.toString());

        System.out.println("Индекс элемента Х: " + list.indexOf("X"));
        System.out.println("Есть ли в списке элемент Z: " +  list.isContains("Z"));
        System.out.println("Текущий размер списка: " + list.getSize());

        list.insertElement("i", 3);
        System.out.println("Вставка i по индексу: " + list.toString());

        list.removeElement("i");
        System.out.println("Удаление i:  " + list.toString());
        System.out.println("----------- foreach ------------");

        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }

        System.out.println("\n=============== Работа стека LinkedStack ================");
        LinkedStack<String> st = new LinkedStack<>();
        st.push("111");
        st.push("222");
        st.push("333");
        st.push("444");
        System.out.println(st.toString());
        System.out.println("Удалили первый элемент: " + st.pop());
        System.out.println("Удалили первый элемент: " + st.pop());
        System.out.println("Удалили первый элемент: " + st.pop());
        System.out.println("Удалили первый элемент: " + st.pop());
        System.out.println("Текущий первый элемент: " + st.peek());
        System.out.println(st.toString());

        System.out.println(" ==== Работа односвязанного списка OneLinkedList ===");
        // Список людей
        OneLinkedList<Person> list2 = new OneLinkedList<>();

        Person p1 = new Person("Dasha");
        Person p2 = new Person("Ira");
        list2.insertFirst(p1);
        System.out.println("Есть ли в списке Ira? " + list2.isContains(p2));
        //Удаление объекта Ira
        list2.removeElement(p2);

        Person person = new Person("Ivan");
        list2.insertFirst(person);
        list2.insertFirst(new Person("Nadia"));
        list2.insertFirst(new Person("Petr"));
        list2.insertFirst(new Person("Nikita"));
        list2.insertFirst(new Person("Olga"));
        System.out.println(list2.toString());

        System.out.println("Есть ли в списке Ivan? " + list2.isContains(person));
        System.out.println("Удаление первого элемента списка: " + list2.removeFirstElement());
        System.out.println(list2.toString());
        System.out.println("Индекс элемента Ivan: " + list2.indexOf(person));
        System.out.println("\n Вставка по индексу объекта Person:");

        list2.insert(new Person("Person"), 1);
        System.out.println(list2.toString());

        System.out.println("Удаление объекта Ivan");
        list2.removeElement(person);
        System.out.println(list2.toString());

        System.out.println("Удаление объекта Dasha");
        list2.removeElement(p1);
        System.out.println(list2.toString());
        System.out.println("Удаление несуществующего объекта Nina");
        list2.removeElement(new Person("Nina"));
    }
}
class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    // надо переопределить equels, hashcode
}
