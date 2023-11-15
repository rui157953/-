package com.ryan.algorithm.findmediansortedarrays;

public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m + n];
        int i = 0, j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                nums[k++] = nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                nums[k++] = nums2[j++];
            } else {
                nums[k++] = nums1[i++];
                nums[k++] = nums2[j++];
            }
        }
        while (i < m) {
            nums[k++] = nums1[i++];
        }
        while (j < n) {
            nums[k++] = nums2[j++];
        }
        return k % 2 == 0 ? (nums[k / 2] + nums[k / 2 - 1]) / 2.0 : nums[k / 2];
    }


    /**
     * ai 自动生成
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double aiFindMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                nums[k++] = nums1[i++];
            } else {
                nums[k++] = nums2[j++];
            }
        }
        while (i < m) {
            nums[k++] = nums1[i++];
        }
        while (j < n) {
            nums[k++] = nums2[j++];
        }
        int mid = (m + n) / 2;
        if ((m + n) % 2 == 0) {
            return (nums[mid] + nums[mid - 1]) / 2.0;
        } else {
            return nums[mid] / 1.0;
        }
    }

}
