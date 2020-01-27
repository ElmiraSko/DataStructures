import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("========== ChainingHashMap =============");
        ChainingHashMap<Integer, String> map = new ChainingHashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");

        System.out.println(map.contains(2));
        System.out.println(map.get(4));
        map.put(4,"four4");
        System.out.println(map.get(4));

        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            map.put(random.nextInt(1000), "");
        }
        System.out.println(map);
        String s = map.remove(1);
        System.out.println("Удалили " + s);
        map.remove(3);
        map.remove(5);
        System.out.println("После удаления 1, 3 и 5");
        System.out.println(map);

        System.out.println("========== LinearProbingHashMap =================");
        LinearProbingHashMap<Integer, String> map2 = new LinearProbingHashMap<>();

        map2.put(1, "one");
        map2.put(2, "two");
        map2.put(3, "three");
        map2.put(4, "four");
        map2.put(5, "five");

        System.out.println(map2.contains(2) + " - содержит ли ключ 2");
        System.out.println(map2.get(4));
        map2.put(4, "four4");
        System.out.println(map2.get(4));

        Random random2 = new Random();
        for (int i = 0; i < 30; i++) {
            map2.put(random2.nextInt(1000), "");
        }
        System.out.println(map2);

// удалили элементы с ключами 3 и 5
        map2.remove(3);
        String str = map2.remove(5);
        System.out.println("Удалили " + str);
        System.out.println(map2);

// пытаемся получить элемент с ключом 5
        System.out.println(map2.get(5));

        map2.put(97, "A");
        map2.put(98, "B");
        map2.put(99, "C");
        System.out.println(map2);


//        LinkedList ls = new LinkedList();
//        ls.removeIf(x -> x.equals("java"));

    }


}
