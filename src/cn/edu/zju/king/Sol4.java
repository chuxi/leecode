package cn.edu.zju.king;

/**
 * Created by king on 2015/5/16.
 */
public class Sol4 {

    public int min(int a, int b) {
        if (a>b)
            return b;
        else
            return a;
    }

    public double findKth(int[] nums1, int s1, int e1, int[] nums2, int s2, int e2, int k) {
        int m = e1 - s1 + 1, n = e2 - s2 + 1;
        if (m > n)
            return findKth(nums2, s2, e2, nums1, s1, e1, k);
        if (m == 0)
            return nums2[k - 1];
        if (k == 1)
            return min(nums1[s1], nums2[s2]);
        int pos1 = min(m, k / 2), pos2 = k - pos1;
        if (nums1[s1 + pos1 - 1] < nums2[s2 + pos2 - 1])
            return findKth(nums1, s1 + pos1, e1, nums2, s2, e2, pos2);
        else if (nums1[s1 + pos1 - 1] > nums2[s2 + pos2 - 1])
            return findKth(nums1, s1, e1, nums2, s2 + pos2, e2, pos1);
        else
            return nums1[s1 + pos1 - 1];
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int total = m + n;
        if( total % 2 == 1) {
            return findKth(nums1,0, m-1, nums2, 0, n-1, total / 2 + 1);
        } else {
            return ((findKth(nums1, 0, m-1, nums2, 0, n-1, total / 2) + findKth(nums1, 0, m-1, nums2, 0, n-1, total / 2 + 1)) / 2);
        }

    }

    public static void main(String[] args) {
        Sol4 s4 = new Sol4();
//        System.out.println(s4.findMedianSortedArrays(new int[]{2, 2, 2}, new int[]{2}));
        System.out.println(s4.findMedianSortedArrays(new int[]{}, new int[]{1}));
        System.out.println(s4.findMedianSortedArrays(new int[]{2, 3, 5}, new int[]{1, 2, 3}));
        System.out.println(s4.findMedianSortedArrays(new int[]{2, 2, 3, 6}, new int[]{1}));
    }

}
