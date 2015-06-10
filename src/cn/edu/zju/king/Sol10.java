package cn.edu.zju.king;

/**
 * Created by king on 2015/5/18.
 */
public class Sol10 {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        // p is a letter, no * followed
        if (p.length() == 1 || p.charAt(1) != '*') {
            if (s.isEmpty() || p.charAt(0) != s.charAt(0) && p.charAt(0) != '.')
                return false;
            else
                return isMatch(s.substring(1), p.substring(1));
        }

        // p.length() >= 2
        while(!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) != '.')) {
            if (isMatch(s, p.substring(2)))
                return true;
            s = s.substring(1);
        }

        return isMatch(s, p.substring(2));


    }

    public static void main(String[] args) {
        Sol10 s10 = new Sol10();
        System.out.println(s10.isMatch("a", ".*..a*"));
        System.out.println(s10.isMatch("bbbba", ".*a*a"));
        System.out.println(s10.isMatch("a", "ab*"));
        System.out.println(s10.isMatch("aaa", "aaaa"));
        System.out.println(s10.isMatch("aa", "a*"));
        System.out.println(s10.isMatch("bb", "a*"));

        System.out.println(s10.isMatch("aab", "c*a*b"));
    }

}
