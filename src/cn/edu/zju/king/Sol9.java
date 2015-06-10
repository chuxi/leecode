package cn.edu.zju.king;

/**
 * Created by king on 2015/5/18.
 */
public class Sol9 {
    public boolean isPalindrome(int x) {
        if ( x < 0 )
            return false;
        if ( x >= 0 && x < 10 )
            return true;
        int sum = 0;
        while (x != 0) {
            sum = sum * 10 + x % 10;
            x = x / 10;
            if ( x == sum || sum / 10 == x )
                return true;

        }
        return false;
    }

    public static void main(String[] args) {
        Sol9 s9 = new Sol9();
        System.out.println(s9.isPalindrome(121));
        System.out.println(s9.isPalindrome(10));
    }


}
