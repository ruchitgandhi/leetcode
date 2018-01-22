public class RegularExpressionMatching {
    public static void main(String[] args) {
        String s = "aa";
        String p = "a*ab*";
        System.out.println(isMatch(s, p));
    }

    private static boolean isMatch(String s, String p) {
        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];

        dp[0][0] = true;
        for (int k = 0; k < p.length(); k++) {
            if (p.charAt(k) == '*' && dp[0][k - 1]) {
                dp[0][k + 1] = true;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) == '.' || s.charAt(i) == p.charAt(j - 1)) {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    } else {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
