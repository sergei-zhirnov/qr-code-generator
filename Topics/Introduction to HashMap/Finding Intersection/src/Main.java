import java.util.HashMap;
import java.util.Scanner;

class Main {
    private static void printCommon(int[] firstArray, int[] secondArray) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i :firstArray) {
            hashMap.put(i, 1);
        }

        for (int i : secondArray) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }

        for (int i : hashMap.keySet()) {
            if (hashMap.get(i) > 1) {
                System.out.print(i + " ");
            }
        }


    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] firstArray = new int [n];
//        int[] secondArray = new int [n];
//        for (int i = 0; i < n; ++i) {
//            firstArray[i] = scanner.nextInt();
//        }
//        for (int i = 0; i < n; ++i) {
//            secondArray[i] = scanner.nextInt();
//        }
//
//        printCommon(firstArray,secondArray);

        HashMap<String, Integer> myMap = new HashMap<>();
        myMap.put("apple", 5);
        myMap.put("banana", 3);
        myMap.put("cherry", 10);
        myMap.put("apple", 7);
        myMap.put("orange", null);
        myMap.remove("apple");
        myMap.getOrDefault("apple", 1);
        System.out.println(myMap.get("apple"));
    }

}