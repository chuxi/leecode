package cn.edu.zju.king;

/**
 * Created by king on 2015/5/17.
 */
public class Sol7 {

    public int reverse(int x) {
        boolean flag = true;
        if (x < 0) {
            flag = false;
            x = -x;
        }

        long rev = 0;
        while (x != 0) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        if (flag == false)
            rev = -rev;
        if (rev > 0x7fffffff)
            rev = 0;
        else if(rev < 0x80000000)
            rev = 0;

        return (int)rev;
    }

    public static void main(String[] args) {
        Sol7 s7 = new Sol7();
        System.out.println(s7.reverse(123));
        System.out.println(s7.reverse(1534236469));
        System.out.println(s7.reverse(-2147483648));
    }
}
