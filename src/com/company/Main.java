package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }
        int n = words.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                boolean verified = false;
                String w1 = words[i], w2 = words[j];
                int w = 0;
                for ( ; w < Math.min(w1.length(), w2.length()); w++) {
                    if (w1.charAt(w) == w2.charAt(w)) {
                        continue;
                    }

                    if (orderMap.get(w2.charAt(w)) < orderMap.get(w1.charAt(w))) {
                        return false;

                    } else {
                        verified = true;
                        break;
                    }
                }
                if (!verified && w < w1.length()) {
                    return false;
                }
            }
        }
        return true;
    }
}