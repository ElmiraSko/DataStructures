
public class Main {
    public static void main(String[] args) {
        MyGraph graph = new MyGraph(10);

        graph.insertV("A");
        graph.insertV("B");
        graph.insertV("C");
        graph.insertV("D");
        graph.insertV("E");
        graph.insertV("I");
        graph.insertV("G");
        graph.insertV("K");
        graph.insertV("P");
        graph.insertV("M");
//        graph.insertV("S");


        graph.edge("A", "B");
        graph.edge("A", "I");     //         B - C - E ------ K
        graph.edge("A", "D");     //       /         |         \
        graph.edge("B", "C");     //     A --- I --- G ---------P
        graph.edge("C", "E");     //      \          |        /
        graph.edge("E", "K");    //         ---------D-------
        graph.edge("E", "G");
        graph.edge("I", "G");
        graph.edge("G", "P");
        graph.edge("G", "D");
        graph.edge("D", "P");
        graph.edge("K", "P");
        graph.edge("M", "M");

        System.out.println("Вершины графа:");
        graph.printVertex();
        System.out.println("-------------------------------");

//        graph.printMatrix();
//        System.out.println();

        System.out.println(graph.getVertexCount() + " - количество вершин");

        System.out.println(graph.getAdj("A").toString() + " - смежные для А");
        System.out.println(graph.getAdj("G").toString() + " - смежные для G");

        BreadthFirstPath bfs = new BreadthFirstPath(graph, "A");
        System.out.println(bfs.hasPathTo("K") + " - есть ли путь до К");
        System.out.println(bfs.hasPathTo("M") + " - есть ли путь до M");
        System.out.println(bfs.pathTo("K") + " - кратчайший путь от А до К");

    }
}

