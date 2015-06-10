package cn.edu.zju.king;

/**
 * Created by king on 2015/5/17.
 */
public class Sol6 {

    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        char[] sc = s.toCharArray();
        int len = s.length();
        int z = numRows * 2 - 2;
        int x = len % z;
        int y = 0;
        if (x > 0 && x <= numRows)
            y = 1;
        else if (x > numRows)
            y = x - numRows + 1;
        int col = len / z * (numRows - 1) + y;
        char[][] table = new char[numRows][col];


        int i=0, j=0, count = 0;
        boolean zig = false;
        for (int k = 0; k < len; k++){
            table[i][j] = sc[k];
            if (zig) {
                if (i == 0) {
                    zig = false;
                    i++;
                }
                else {
                    i--; j++;
                }
            } else {
                if (i == numRows - 1) {
                    zig = true;
                    i--; j++;
                }
                else
                    i++;
            }
        }
        char[] result = new char[len];
        int t = 0;
        for (int p=0; p<numRows; p++) {
            for (int q=0; q<col; q++) {
                if (table[p][q] != 0) {
                    result[t] = table[p][q];
                    t++;
                }
            }
        }
        return new String(result);
    }


    public static void main(String[] args) {
        Sol6 s6 = new Sol6();
//        System.out.println(s6.convert("PAYPALISHIRING", 3));
//        System.out.println(s6.convert("PAYPALISHIRING", 2));
        System.out.println(s6.convert("ABCDE", 4));
    }
}
