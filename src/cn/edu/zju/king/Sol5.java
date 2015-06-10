package cn.edu.zju.king;

/**
 * Created by king on 2015/5/17.
 */
public class Sol5 {

    public String longestPalindrome(String s) {
        char[] lps = s.toCharArray();
        int size = lps.length;

        boolean[][] table = new boolean[size][size];

        int maxLen = 1;
        int sindex = 0;
        for (int i=0; i < size; i++) {
            table[i][i] = true;
            if (i < size - 1 && lps[i] == lps[i+1]) {
                table[i][i+1] = true;
                maxLen = 2; sindex = i;
            }
        }


        for (int k=3; k <= size; k++)
            for (int i=0; i <= size-k; i++){
                int j = i + k - 1;
                table[i][j] = table[i+1][j-1] && lps[i] == lps[j];
                if (table[i][j] && k > maxLen) {
                    maxLen = k;
                    sindex = i;
                }
            }

        return s.substring(sindex, sindex + maxLen);

    }

    public static void main(String[] args) {
        Sol5 s5 = new Sol5();
        System.out.println(s5.longestPalindrome("bb"));
        System.out.println(s5.longestPalindrome("abcdeedsss"));
        System.out.println(s5.longestPalindrome("abcdeedsssss"));
    }
}
