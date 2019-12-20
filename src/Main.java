public class Main {

    static int[] myArr = new int[1000000];

    public static void main(String[] args) {

        fillTheArray(-20, 20, myArr);
        bubbleSorted(myArr);

        fillTheArray(-25, 10, myArr);
        selectSorted(myArr);

        fillTheArray(-10, 45, myArr);
        insertSorted(myArr);
    }

    // вспомогательный метод
    private static void change(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
    // сортировка пузырьком
    private static void bubbleSorted(int[] array) {
        long startTime = System.currentTimeMillis();
        int length = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < length; j++) {
                if (array[j] > array[j + 1]) {
                    change(array, j, j+1);
                }
            }
            length--;
        }
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime-startTime);
    }
    // сортировка выбором
    private static void selectSorted(int[] array) {
        long startTime = System.currentTimeMillis();
        int index; // индекс наименьшего элемента в одной итерации
        int length = array.length;
        for (int i = 0; i < length; i++) {
            index = i;
            for (int j = i+1; j < length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            change(array, index, i);
        }
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime-startTime);
    }
    // сортировка вставкой
    private static void insertSorted(int[] array) {
        long startTime = System.currentTimeMillis();
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i;
            for (;j > 0 && array[j-1] > tmp; j--) {
                array[j] = array[j-1];
            }
            array[j] = tmp;
        }
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime-startTime);
    }


    // заполняем массив числами
    private static void fillTheArray(int min, int max, int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random()*((max - min) + 1)) + min;
        }
    }


    //методы удаления, добавления, поиска элемента массива

    static void deleteElement(int index) { // без сдвига
        myArr[index] = 0;
    }
    static void deleteElement2(int element) { //со сдвигом
        int m = -1;
        for (int i = 0; i < myArr.length; i++) {
            if (myArr[i] == element) {
                m = i;
                break;
            }
        }
        if (m > 0) {
            for (int i = m; i < myArr.length - 1; i++) {
                myArr[i] = myArr[i + 1];
            }
            myArr[myArr.length-1] = 0;
        }
    }

    static void addElement(int index, int element) {
        myArr[index] = element;
    }

    static int findElement(int element) {
        int i;
        for (i = 0; i < myArr.length; i++) {
            if (myArr[i] == element) {
                System.out.println(myArr[i]);
                return myArr[i];
            }
        }
        System.out.println("Элемент равный " + element + " не найден");
        return -1;
    }
    static void printArray() {
        for (int m : myArr) {
            System.out.print(m + " ");
        }
        System.out.println();
    }
}
