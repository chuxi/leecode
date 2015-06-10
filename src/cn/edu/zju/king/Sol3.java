package cn.edu.zju.king;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by king on 2015/3/26.
 */
public class Sol3 {
    public int lengthOfLongestSubstring(String s) {
//        if (s.length() == 0)
//            return 0;
//        return findMaxSub(s, 0, s.length() - 1)[0];
        int posl = 0, posr = -1;
        int maxl = 0;

        String tmps = "";

        char[] is = s.toCharArray();

        boolean flag = true;
        for ( int i = 0; i < s.length(); i++) {
            int t = -1;

            if ( (t=tmps.indexOf(is[i])) == -1) {
                tmps = tmps + is[i];
                posr++;
                if (flag)
                    maxl++;
            } else {
                tmps = tmps.substring(t+1);
                tmps += is[i];
                posr++;
                posl += t+1;
                flag = false;
            }
            if (posr - posl + 1 >= maxl) {
                maxl = posr - posl + 1;
                flag = true;
            }
        }
        return maxl;
    }

//    public int[] findMaxSub(String s, int left, int right) {
//        int center, maxLeft[], maxRight[];
//        if (left == right)
//            return new int[]{1, left, right};
////        if (s.charAt(left) == s.charAt(right))
////            return right - left;
//        center = (left + right) / 2;
//        String lefts, rights;
//        lefts = s.substring(left, center + 1);
//        rights = s.substring(center+1, right + 1);
//        maxLeft = findMaxSub(s, left, center);
//        maxRight = findMaxSub(s, center+1, right);
//
//        int[] maxSub;
//        if (maxLeft[0] > maxRight[0])
//            maxSub = Arrays.copyOf(maxLeft, 3);
//        else
//            maxSub = Arrays.copyOf(maxRight, 3);
//
//        if (maxLeft[2] + 1 < maxRight[1])
//            return maxSub;
//        else {
//            // 合并两个子串，从右往左与从左往右
//            for (int i = center - left; i >= 0; i--) {
//                if (rights.indexOf(lefts.charAt(i)) == -1)
//                {
//                    maxRight[0] ++;
//                    maxRight[1] --;
//                    rights = lefts.charAt(i) + rights;
//                }
//                else
//                {
//                    maxRight[1] --;
//                    maxRight[2] --;
//                    break;
//                }
//            }
//            if (maxRight[0] > maxSub[0])
//                maxSub = maxRight;
//
//            for (int i = 0; i <= right - center -1; i++) {
//                if (lefts.indexOf(rights.charAt(i)) == -1)
//                {
//                    maxLeft[0] ++;
//                    maxLeft[2] ++;
//                    lefts = lefts + rights.charAt(i);
//                }
//                else
//                    break;
//
//            }
//            if (maxLeft[0] > maxSub[0])
//                maxSub = maxLeft;
//        }
//
//        return maxSub;
//    }


    public static void main(String[] args) {
        Sol3 s3 = new Sol3();
        System.out.println(s3.lengthOfLongestSubstring("tmmzuxt"));
        System.out.println(s3.lengthOfLongestSubstring("abba"));
        System.out.println(s3.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(s3.lengthOfLongestSubstring(""));
        System.out.println(s3.lengthOfLongestSubstring("bbbbbbbb"));
        System.out.println(s3.lengthOfLongestSubstring("aab"));
        System.out.println(s3.lengthOfLongestSubstring("abcb"));
        System.out.println(s3.lengthOfLongestSubstring("ohomm"));
    }


}
