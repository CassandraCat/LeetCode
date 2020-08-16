import java.util.ArrayList;

public class Ex5_PalindromicString {
    public static void main(final String[] args) {
        // System.out.println(longestPalindrome("babad"));
        // longestPalindrome("babad");
        // longestPalindrome("bb");
        System.out.println(longestPalindrome4("babad"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1)
            return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static String longestPalindrome2(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (j - i < result.length()) {
                    continue;
                }
                String temp = s.substring(i, j);
                if (isPalindromic(temp)) {
                    result = result.length() > temp.length() ? result : temp;
                }
            }
        }
        return result;
    }

    public static boolean isPalindromic(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static String longestPalindrome3(String s) {
        String result = "";
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i + 1 > result.length()) {
                    result = s.substring(i, j + 1);
                }
            }
        }
        return result;
    }

    public static String longestPalindrome4(String s) {
        String fillingString = fillingString(s);
        int[] p = new int[fillingString.length()];
        int center = 0;
        int radius = 0;
        for (int i = 1; i < fillingString.length() - 1; i++) {
            if (radius > i) {
                p[i] = Math.min(p[2 * center - i], radius - i);
            } else {
                p[i] = 0;
            }
            while (fillingString.charAt(i + 1 + p[i]) == fillingString.charAt(i - 1 - p[i])) {
                p[i]++;
            }
            if (i + p[i] > radius) {
                center = i;
                radius = i + p[i];
            }
        }
        int maxLength = 0;
        int index = 0;
        for (int i = 1; i < fillingString.length() - 1; i++) {
            if (p[i] > maxLength) {
                maxLength = p[i];
                index = i;
            }
        }
        return s.substring((index - maxLength) / 2, (index - maxLength) / 2 + maxLength);
    }

    public static String fillingString(String s) {
        int n = s.length();
        if (n == 0) {
            return "^$";
        }
        String result = "^";
        for (int i = 0; i < n; i++)
            result += "#" + s.charAt(i);
        result += "#$";
        return result;
    }
}