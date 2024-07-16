import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)) return 0;

        Set<String> visited = new HashSet<>();
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

            List<String> nextWords = Arrays.stream(words)
                                           .filter(word -> canConvert(current, word) && !visited.contains(word))
                                           .collect(Collectors.toList());

            for (String word : nextWords) {
                queue.offer(word);
                countQueue.offer(count + 1);
                visited.add(word);
            }
        }
        return 0;
    }

    private boolean canConvert(String word1, String word2) {
        long diffCount = IntStream.range(0, word1.length())
                                  .filter(i -> word1.charAt(i) != word2.charAt(i))
                                  .count();
        return diffCount == 1;
    }
}
