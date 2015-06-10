package cn.edu.zju.king;

import java.util.Arrays;

public class Sol1 {

    public int findIndex(int[] nums, int value, int a) {
        int key = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == value && i != a) {
                key = i;
                break;
            }
        }
        return key;
    }

    public int[] twoSum(int[] numbers, int target) {

        int[] rs = new int[2];
        boolean flag = false;
        int[] nums = numbers.clone();
        Arrays.sort(numbers);



//        Collections.sort(nums);
//        for (Integer e: nums)
//            System.out.println(e);
        for (int i = 0; i < numbers.length; ++i) {
            int j = Arrays.binarySearch(numbers, target - numbers[i]);
            if (j > 0) {
                int a  = findIndex(nums, numbers[i], -2);
                int b  = findIndex(nums, numbers[j], a);
                if (a < b) {
                        rs[0] = a+1; rs[1] = b+1;
                    } else {
                        rs[1] = a+1; rs[0] = b+1;
                    }
                break;
            }
        }

        return rs;
    }


    public static void main(String[] args) {
	// write your code here
        int[] rs = new int[2];
        int[] num = {0,4,3,0};
        Sol1 m = new Sol1();
        rs = m.twoSum(num, 0);
        for (int i : rs)
            System.out.println(i);
        rs = m.twoSum(new int[]{3,2,4}, 6);
        for (int i : rs)
            System.out.println(i);
        rs = m.twoSum(new int[]{-3,4,3,90}, 0);
        for (int i : rs)
            System.out.println(i);
        rs = m.twoSum(new int[]{-1,-2,-3,-4,-5}, -8);
        for (int i : rs)
            System.out.println(i);
    }
}
