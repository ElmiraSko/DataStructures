import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/*
Дерево двоичного поиска.
Если логика верна, то несбалансированных деревьев в среднем получается 45 % - 50 %
*/
public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        double countFalse = 0; // для подсчета


        List<MyTree> listTree = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            MyTree tree = new MyTree();
            for (int j = 0; j < 64 ; j++) {
                tree.insert(random.nextInt(201) - 100);
            }
            listTree.add(tree);
        }

        for (MyTree tree: listTree) {
            boolean b = tree.isBalance(tree.getRoot());
            if (!b) countFalse++;
            System.out.println(b);
        }

        System.out.println(countFalse/20 + " - доля несбалансированных деревьев");

// Обход деревьев
//        for (MyTree tree: listTree) {
//            tree.allNode(tree.getRoot());
//            System.out.println();
//        }
// Изображение дерева
//        for (MyTree tree: listTree) {
//            tree.displayTree();
//            System.out.println();
//        }


    }
}
