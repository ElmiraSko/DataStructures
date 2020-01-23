import java.util.LinkedList;

public class BreadthFirstPath {
    private boolean[] marked;
    private int[] edgeTo; // смежный родитель
    private String source;
    private MyGraph g;

    public BreadthFirstPath(MyGraph g, String source) {
        this.source = source;
        marked = new boolean[g.getVertexCount()];
        edgeTo = new int[g.getVertexCount()];
        this.g = g;
        bfs(g, source);
    }

    private void bfs(MyGraph g, String source) {
        int indSource = g.getIndexOfValue(source); // получили соответствующий индекс
        LinkedList<String> queue = new LinkedList<>();
        queue.addLast(source);
        marked[indSource] = true;

        while (!queue.isEmpty()) {
            String vertex = queue.removeFirst(); // вернули сам объект
            int ind = g.getIndexOfValue(vertex); // получили его индекс
            for (int w : g.getAdjList(vertex)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = ind; // присваиваем индекс родителя
                    queue.addLast(g.getVertexArr()[w].getValue());
                }
            }
        }
    }

    public boolean hasPathTo(String value) {
        int dist = g.getIndexOfValue(value);
        return marked[dist];
    }

    public LinkedList<String> pathTo(String value) {
        if (!hasPathTo(value)) {
            return null;
        }
        LinkedList<String> stack = new LinkedList<>();
        String vertex = value;
        while (!vertex.equals(source)){
            stack.push(vertex);
            int i = edgeTo[g.getIndexOfValue(vertex)];
            vertex = g.getVertexArr()[i].getValue();
        }
        return stack;
    }
}

