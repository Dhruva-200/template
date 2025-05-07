import java.util.*;

class Item {
    int weight;
    int value;
    Item(int w, int v) {
        weight = w;
        value = v;
    }
}

public class FractionalKnapsack {
    public static void main(String[] args) {
        int W = 50;
        Item[] items = {
            new Item(10, 60),
            new Item(20, 100),
            new Item(30, 120)
        };

        double maxValue = getMaxValue(items, W);
        System.out.println("Maximum value: " + maxValue);
    }

    static double getMaxValue(Item[] items, int capacity) {
        Arrays.sort(items, (a, b) -> Double.compare(b.value * 1.0 / b.weight, a.value * 1.0 / a.weight));

        double totalValue = 0;
        for (Item item : items) {
            if (capacity >= item.weight) {
                totalValue += item.value;
                capacity -= item.weight;
            } else {
                totalValue += item.value * ((double)capacity / item.weight);
                break;
            }
        }
        return totalValue;
    }
}
