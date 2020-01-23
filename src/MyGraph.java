import java.util.LinkedList;

public class MyGraph {

    private Vertex[] vertexArr;
    private int maxVertexCount;
    private int vertexCount;
    private int[][] adjMat;
    private int top = -1; // используется как указатель на послед добавл. элемент


    public MyGraph(int maxVertexCount) {
        this.maxVertexCount = maxVertexCount;
        this.vertexArr = new Vertex[maxVertexCount];
        adjMat = new int[maxVertexCount][maxVertexCount];
// заполнение матрицы нулями
        for (int i = 0; i < maxVertexCount; i++) {
            for (int j = 0; j < maxVertexCount; j++) {
                adjMat[i][j] = 0;
            }
        }
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public Vertex[] getVertexArr() {
        return vertexArr;
    }

    // добавление вершины в граф
    public void insertV(String value) {
        if (vertexCount < maxVertexCount) {
            Vertex v = new Vertex(value); // создание вершины
            vertexArr[++top] = v; // помещение его в массив
            v.setId(top); // присвоение вершине индекс размещения в массиве
            vertexCount++;
        }
        else throw new IndexOutOfBoundsException("Граф переполнен!");

    }
    // получение индекса по значению
    public int getIndexOfValue(String val) {
        for (int i = 0; i < vertexArr.length; i++) {
            if (val.equals(vertexArr[i].getValue())){
                return i;
            }
        }
        return -1;
    }
    // заполнение матрицы смежности
    public void edge(String v1, String v2) {
        int a = getIndexOfValue(v1);
        int b = getIndexOfValue(v2);
        if (a >= 0 && b >= 0 && a < maxVertexCount && b < maxVertexCount){
            if (a == b)
                adjMat[a][b] = 1;
            else {
                adjMat[a][b] = 1;
                adjMat[b][a] = 1;
            }
        }
        else throw new NullPointerException("Нет такой вершины!");
    }
    // возвращает значения смежных вершин для данной вершины
    LinkedList<String> getAdj(String value) {
        int x = getIndexOfValue(value);  // получили индекс вершины со значением value
        LinkedList<String> listAdjV = new LinkedList<>();
        for (int i = 0; i < adjMat.length; i++) {
            if (x >=0 && adjMat[x][i] == 1) {
                listAdjV.add(vertexArr[i].getValue());
            }
        }
        return  listAdjV;
    }

    // возвращает индексы смежных вершин для данной вершины
    LinkedList<Integer> getAdjList(String value) {
        int x = getIndexOfValue(value);  // получили индекс вершины со значением value
        LinkedList<Integer> listAdjV = new LinkedList<>();
        for (int i = 0; i < adjMat.length; i++) {
            if (adjMat[x][i] == 1) {
                listAdjV.add(vertexArr[i].getId());
            }
        }
        return  listAdjV;
    }

    // вывод всех вершин графа
    public void printVertex() {
        for (Vertex v : vertexArr) {
            if (v != null)
                v.print();
        }
    }
    // вывод матрицы
    public void printMatrix() {
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                System.out.print(adjMat[i][j] + "  ");
            }
            System.out.println();
        }
    }

}

// класс вершин графа
class Vertex {
    private String value;
    private int id = -1;
    private boolean isVisited;

    Vertex(String value) {
        this.value = value;
        this.isVisited = false;
    }

    public String getValue() {
        return value;
    }

    public int getId() {
        return id;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    void setId(int id) {
        this.id = id;
    }

    // хранимые данные
    public void print() {
        System.out.println("Вершина: " + value + "  (" + isVisited + "), ind = " + id);
    }

}

