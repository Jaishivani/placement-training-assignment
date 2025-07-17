import java.util.*;

public class Solution {
    private Map<Character, List<Integer>> charToIndices = new HashMap<>();
    private String ring;
    private String key;
    private int ringLength;
    private Integer[][] memo;

    public int findRotateSteps(String ring, String key) {
        this.ring = ring;
        this.key = key;
        this.ringLength = ring.length();

        for (int i = 0; i < ringLength; i++) {
            char c = ring.charAt(i);
            charToIndices.computeIfAbsent(c, x -> new ArrayList<>()).add(i);
        }

        memo = new Integer[ringLength][key.length()];
        return dfs(0, 0);
    }

    private int dfs(int currentPos, int keyIndex) {
        if (keyIndex == key.length()) {
            return 0;
        }

        // If cached result exists, return it
        if (memo[currentPos][keyIndex] != null) {
            return memo[currentPos][keyIndex];
        }

        int minSteps = Integer.MAX_VALUE;
        char targetChar = key.charAt(keyIndex);

        for (int pos : charToIndices.get(targetChar)) {
            int diff = Math.abs(pos - currentPos);
            int step = Math.min(diff, ringLength - diff);

            int totalSteps = step + 1 + dfs(pos, keyIndex + 1);

            minSteps = Math.min(minSteps, totalSteps);
        }

        memo[currentPos][keyIndex] = minSteps;
        return minSteps;
    }
}
