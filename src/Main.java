import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/*
Двоичное дерево поиска.
Метод isBalance: несбалансированных деревьев получается 95 - 100 проц.,
если оценивать строго, balance(node) < 2.
*/
public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        int countTree = 20; // кол-во деревьев
        int countNode = 64; // кол-во добавляемых узлов в каждое дерево
        double countFalse = 0; // для подсчета несбалансированных деревьев


        List<MyTree> listTree = new ArrayList<>();

        for (int i = 0; i < countTree; i++) {
            MyTree tree = new MyTree();
            for (int j = 0; j < countNode ; j++) {
                tree.insert(random.nextInt(201) - 100);
            }
            listTree.add(tree);
        }


        for (MyTree tree: listTree) {
            boolean b = tree.isBalance(tree.getRoot());
            if (!b) countFalse++;
            System.out.println(b);
        }

        System.out.println(countFalse/countTree + " - доля несбалансированных деревьев");

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
