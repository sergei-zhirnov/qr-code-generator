import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    private static void printMode( int[] map) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : map) {
            if (hashMap.containsKey(i)) {
                hashMap.put(i, hashMap.get(i) + 1);
            } else {
                hashMap.put(i, 1);
            }
        }

        int maxKey = Collections.max(hashMap.entrySet(), Map.Entry.comparingByValue()).getKey();
        int maxValue = hashMap.get(maxKey);

        System.out.println(maxKey + " " + maxValue);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] map = new int [n];
        for (int i = 0; i < n; ++i) { 
            map[i] = scanner.nextInt();
        }

        printMode(map);
    }
}