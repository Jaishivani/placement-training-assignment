class Solution {
    public int mySqrt(int x) {
        int i = 0;
        while ((long)i * i <= x) {
            i++;
        }
        return i - 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int testInput = 8;
        int result = sol.mySqrt(testInput);
        System.out.println("Sqrt(" + testInput + ") = " + result);
    }
}
