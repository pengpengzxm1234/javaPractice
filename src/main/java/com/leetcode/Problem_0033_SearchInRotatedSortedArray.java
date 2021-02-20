package com.leetcode;

/**
 * leetcode高频讲解四
 * 有序数组，可能转过
 * 如何快速找到一个数
 * 思路：条件分类（尽可能二分）
 * L到R位置的中点M，只要这三个数不是都相等，就一定可以二分
 * 1、当三个位置的数都相同，L向右移动，直到L的位置的值和另外两个不同，
 * 在根据现在的L 和 R 找M做二分
 * 2、当L移动到了M位置，用M+1位置和R做二分
 *
 * 升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为[4,5,6,7,0,1,2] ）。
 *
 * 请你在数组中搜索target ，如果数组中存在这个目标值，则返回它的索引，否则返回-1。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：nums = [1], target = 0
 * 输出：-1
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * nums 肯定会在某个点上旋转
 * -10^4 <= target <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem_0033_SearchInRotatedSortedArray {

    public static int search(int[] arr, int num){
        int L = 0;
        int R = arr.length - 1;
        int M = 0;
        while (L <= R){
            M = (L + R)/2;
            //如果中点M的值是num
            if(arr[M] == num){
                return M;
            }
            //arr[M] != num
            if(arr[M] == arr[L] && arr[M] == arr[R]){//L R M 三个点的值相等
                while (L != M && arr[L] == arr[M]){
                    L++;
                }
                if(L == M){
                    L = M + 1;
                    continue;
                }
            }
            //arr[M] != nul
            //[L] [M] [R]不都相等
            if(arr[L] != arr[M]){
                if(arr[M] > arr[L]){//L ~ M 是有序的
                    if(num >= arr[L] && num < arr[M]){
                        R = M - 1;
                    }else {
                        L = M + 1;
                    }
                }else {//M ~ R 是有序的
                    if(num > arr[M] && num <= arr[R]){
                        L = M + 1;
                    }else {
                        R = M - 1;
                    }
                }
            }else {//[L] == [M] -> [M] != [R]
                if(arr[M] < arr[R]){//M ~ R 是有序的
                    if(num > arr[M] && num <= arr[R]){
                        L = M + 1;
                    }else {
                        R = M - 1;
                    }
                }else {//L ~ M 是有序的
                    if(num  >= arr[L] && num < arr[M]){
                        R = M - 1;
                    }else {
                        L = M + 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr =new int[]{15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        System.out.println(search(arr, 5));
    }
}
