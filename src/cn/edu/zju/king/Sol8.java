package cn.edu.zju.king;

/**
 * Created by king on 2015/5/18.
 */
public class Sol8 {

    public int myAtoi(String str) {
        long r = 0;
        boolean flag = true;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ( i == 0 && c == '-') {
                flag = false;
                continue;
            } else if ( i == 0 && c == '+')
                continue;
            if (c == ' ')
                continue;
            if (c >= '0' && c <='9')
                r = r * 10 + c - '0';
            else
                return 0;
        }

        if (flag)
            if (r < 0x7fffffff)
                return (int)r;
            else
                return 0;
        else
            if (-r > 0x80000000)
                return -(int)r;
            else
                return 0;
    }

    public static void main(String[] args) {
        Sol8 s8 = new Sol8();
        System.out.println(s8.myAtoi("+-2"));
        System.out.println(s8.myAtoi("    010"));
        System.out.println(s8.myAtoi("-21474836480"));
    }

}
