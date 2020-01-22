
public class MyTree {
    private Node root; // ссылка на корневой элемент
    private boolean bal = true; // изначально сбалансированное


    public boolean isEmpty() { // true - если пустое дерево
        return root == null;
    }

// Поиск узла по ключу
    public Node find(int key) {
        if (isEmpty()) return null;
        Node current = root;
        while (current != null) {
            if (current.key == key) {
                return current;
            } else if (current.key > key) {
                current = current.leftChild;
            } else
                current = current.rightChild;
        }
        return current;
    }
// Вставка узла
    public void insert(int key) {
        Node newNode = new Node(key);
        if (isEmpty()){
            root = newNode;
            root.level = 0;
        }
        else {
            Node current = root;
            Node parent;
            while (current.level < 5) {
                parent = current;
                if (current.key > key) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        newNode.level = parent.level + 1;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        newNode.level = parent.level + 1;
                        return;
                    }
                }
            }
        }
    }

    public Node getRoot() {
        return root;
    }

    // Обход дерева
    public void allNode(Node node) {
        if (node != null) {
            allNode(node.leftChild);
            System.out.print(node.key + ",level = " + node.level + "; ");
            allNode(node.rightChild);
        }
    }

// Для проверки сбалансированности, вспомогательные методы leftNodeLevel, rightNodeLevel
private int leftNodeLevel(Node current) {
    while (current.leftChild != null) {
        current = current.leftChild;
    }
    return current.level;
}
    private int rightNodeLevel(Node current) {
        while (current.rightChild != null) {
            current = current.rightChild;
        }
        return current.level;
    }
// Разность уровней
    private int balance(Node current) {
        if (current != null) {
            return Math.abs(leftNodeLevel(current) - rightNodeLevel(current));
        }
        return 0;
    }
  // Логическое значение. Если balance(node) < 2, т.е. разн. == 1, то несбалан-х 95 проц.
public boolean isBalance(Node node) {
    if (node!= null){ // если проверяемый узел не null, проверяем разность уровней слева и справа.
        if (balance(node) < 2){ // если разн. взять = 2, то получается 55 - 70 проц. несбалансированных деревьев
            isBalance(node.leftChild);
            isBalance(node.rightChild);
        }
        else {
            bal = false;
        }
    }
    return bal;
}

    // Нахождение минимального ключа (дерево не пустое)
    public int getMin() {
        Node current = root;
        Node parent = root;
        while (current != null) {
            parent = current;
            current = current.leftChild;
        }
        return parent.key;
    }

    //Нахождение миним. рекурсией
    public int getMinRec(Node current) {
        if (current.leftChild == null)
            return current.key;
        else
            return getMinRec(current.leftChild);
    }

    // Нахождение максимального ключа, (дерево не пустое)
    public int getMax() {
        Node current = root;
        Node parent = root;
        while (current != null) {
            parent = current;
            current = current.rightChild;
        }
        return parent.key;
    }

    // Нахождение максимального ключа рекурсией
    public int getMaxRec(Node current) {
        if (isEmpty()) return 0;
        if (current.rightChild == null) return current.key;
        else return getMaxRec(current.rightChild);
    }


    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeft = true;
        while (current.key != key) {
            parent = current;
            if (current.key > key) {
                current = current.leftChild;
                isLeft = true;
            } else {
                isLeft = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) root = null;
            else if (isLeft) parent.leftChild = null;
            else parent.rightChild = null;
            return true;
        } else if (current.rightChild == null)
            if (current == root) root = current.leftChild;
            else if (isLeft) parent.leftChild = current.leftChild;
            else parent.leftChild = current.leftChild;
        else if (current.leftChild == null)
            if (current == root) root = current.rightChild;
            else if (isLeft) parent.leftChild = current.rightChild;
            else parent.rightChild = current.rightChild;
        else {
            Node successor = getSuccessor(current);
            // Родитель current связывается с посредником
            if (current == root)
                root = successor;
            else if (isLeft)
                parent.leftChild = successor;
            else
                parent.rightChild = successor;
        }
        return true;
    }

    public Node getSuccessor(Node node) {
        Node successorParent = node;
        Node successor = node;
        Node current = node.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != node.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = node.rightChild;
        }

        return successor;
    }

    private class Node {
        int key; // ключ
        int level = 0; // уровень узла

        Node leftChild;
        Node rightChild;

        // Конструктор узла
        Node(int key) {
            this.key = key;
        }


        public void display() {
            System.out.print(key);
        }
    }

    void displayTree() {
        MStack stack = new MStack(400);
        stack.push(root);
        int nBlanks = 64;
        boolean isRowEmpty = false;
        System.out.println(".................................................................................................");
        while (!isRowEmpty) {
            MStack localStack = new MStack(400);
            isRowEmpty = true;

            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }
            while (!stack.isEmpty()) {
                Node temp = stack.pop();
                if (temp != null) {
                    temp.display();
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if (temp.leftChild != null || temp.rightChild != null)
                        isRowEmpty = false;

                } else {
                    System.out.print("||");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println(" ");
            nBlanks = nBlanks / 2;
            while (!localStack.isEmpty())
                stack.push(localStack.pop());
        }
        System.out.println("...............................................................................................");

    }

    class MStack{
        private int maxSize;
        private Node[] stack;
        private int top;

        public MStack(int size){
            this.maxSize = size;
            this.stack = new Node[this.maxSize];
            this.top = -1;
        }

        public void push(Node node){
            this.stack[++this.top] = node;
        }

        public Node pop(){
            return this.stack[this.top--];
        }

        public Node peek(){
            return this.stack[this.top];
        }

        public boolean isEmpty(){
            return (this.top == -1);
        }

        public boolean isFull(){
            return (this.top == this.maxSize-1);
        }
    }

}
