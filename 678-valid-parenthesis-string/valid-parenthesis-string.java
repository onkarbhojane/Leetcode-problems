class Solution {
   private String str;
    private int[][] dp; // -1: unset, 0: false, 1: true

    public boolean checkValidString(String s) {
        this.str = s;
        // dp[ind][balance + str.length()] to account for negative balance values
        this.dp = new int[s.length()][2 * s.length() + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return isValid(0, 0) == 1;
    }

    private int isValid(int ind, int balance) {
        if (balance < 0) return 0; // Invalid if more closing brackets
        if (ind == str.length()) return balance == 0 ? 1 : 0; // Valid iff balance is zero at the end

        if (dp[ind][balance + str.length()] != -1) return dp[ind][balance + str.length()];

        char ch = str.charAt(ind);
        if (ch == '(') {
            return dp[ind][balance + str.length()] = isValid(ind + 1, balance + 1);
        } else if (ch == ')') {
            return dp[ind][balance + str.length()] = isValid(ind + 1, balance - 1);
        } else { // ch == '*'
            // Try '*' as '(', as ')' or ignoring it
            int takeAsOpen = isValid(ind + 1, balance + 1);
            int takeAsClose = isValid(ind + 1, balance - 1);
            int ignore = isValid(ind + 1, balance);
            return dp[ind][balance + str.length()] = (takeAsOpen | takeAsClose | ignore);
        }
    }
}