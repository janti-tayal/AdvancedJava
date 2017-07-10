package hacker;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created on 09/07/17 8:07 PM by bhgupta.
 */
public class Solution {

    private static Map<String, Integer> nameCount = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int intCount = Integer.parseInt(in.nextLine());
        for (int i = 0; i < intCount; i++) {
            String[] input = in.nextLine().split(" ");
            if (input[0].equals("add")) {
                addName(input[1]);
            } else if (input[0].equals("find")) {
                System.out.println(findPartial(input[1]));
            }
        }
        in.close();
    }

    private static int findPartial(String partial) {
        return nameCount.getOrDefault(partial, 0);
    }

    private static void addName(String name) {
        for (int i = 1; i <= name.length(); i++) {
            String pattern = name.substring(0, i);
            if (nameCount.containsKey(pattern)) {
                nameCount.put(pattern, nameCount.get(pattern) + 1);
            } else {
                nameCount.put(pattern, 1);
            }
        }
    }
}
