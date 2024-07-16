import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)) return 0;

        Queue<String> queue = new LinkedList<>();
        Queue<Integer> countQueue = new LinkedList<>();
        queue.offer(begin);
        countQueue.offer(0);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            int count = countQueue.poll();

            if (current.equals(target)) {
                return count;
            }

            for (String word : words) {
                if (canConvert(current, word)) {
                    queue.offer(word);
                    countQueue.offer(count + 1);
                }
            }
        }
        return 0;
    }

    private boolean canConvert(String word1, String word2) {
        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
            }
            if (diffCount > 1) {
                return false;
            }
        }
        return diffCount == 1;
    }
}
