import java.util.*;

public class Main {
    public static void main(String[] args) {
// Возведение в степень
        System.out.println(exponent(-2, 6));
        System.out.println();

// Задача о рюкзаке

        Item[] arr = new Item[5];
        arr[0] = new Item("item1", 7, 12);
        arr[1] = new Item("item2", 6, 14);
        arr[2] = new Item("item3", 3, 6);
        arr[3] = new Item("item4", 11, 20);
        arr[4] = new Item("item5", 8, 18);

        Rucksack bag = new Rucksack(20);
        bag.bestCase(arr, 0);
        System.out.println(bag.getBestPrice() + " getBestPrice()");
        bag.getBestItems();

    }
// Возведение в степень
    static int exponent(int number, int n) {
        int temp = number;
        if (n < 0 && number != 0) throw new IllegalArgumentException("Отрицательный показатель!");
        if (n == 0 && number != 0) return 1;
        if (n == 1) return number;
        number = number * number;
        if (n % 2 == 0) {
            n = n / 2;
            return exponent(number, n);
        } else {
            n = n / 2;
            return exponent(number, n) * temp;
        }
    }

}

class Rucksack {
    private int massR; // масса рюкзака
    private int bestPrice; // лучшая стоимость предметов
    private String[] bestItems = null;

    Rucksack(int massR) {
        this.massR = massR;
    }


    void bestCase(Item[] arr, int startIndex){
        if (startIndex == arr.length) {return;}
        if (bestPrice == 0) { startIndex = 0;}

        if (arr[startIndex].getWeight() < massR){
            bestItems = new String[arr.length];
            int sumP = 0;
            sumP += arr[startIndex].getPrice();
            int k = startIndex + 1;
            while (k < arr.length) {
                for (int i = k; i < arr.length; i++) {
                    if (arr[i].getWeight() < massR) {
                        sumP += arr[i].getPrice();
                        massR = massR - arr[i].getWeight();
                        bestItems[i]  = arr[i].getName();
                    } else return;
                    if (sumP > bestPrice) {
                        bestPrice = sumP;
                    }
                }
                k++;

            }
        }
        bestCase(arr, startIndex + 1);
    }

    int getBestPrice(){
        return bestPrice;
    }

    void getBestItems() {
        for (String s : bestItems){
            if (s != null) {
                System.out.print(s + " ");
            }
        }
    }
}

class Item {
    private String name;
    private int weight;
    private int price;

    Item (String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    int getWeight() {
        return weight;
    }

    int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}

