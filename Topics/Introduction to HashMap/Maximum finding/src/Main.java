import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    private static void printMaxKey(HashMap<Integer, Integer> map) {
        int maxKey = Collections.max(map.keySet());
        System.out.println(map.get(maxKey));

    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; ++i) {
            map.put(scanner.nextInt(), scanner.nextInt());
        }

        printMaxKey(map);
    }
}