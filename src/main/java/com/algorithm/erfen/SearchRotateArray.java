package com.algorithm.erfen;

/**
 *
 * 搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。
 * 请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。若有多个相同元素，返回索引值最小的一个。
 *
 * 示例1:
 *
 *  输入: arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 5
 *  输出: 8（元素5在该数组中的索引）
 * 示例2:
 *
 *  输入：arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 11
 *  输出：-1 （没有找到）
 * 提示:
 *
 * arr 长度范围在[1, 1000000]之间
 *
 * arr = [15, 16, 25, 1, 3, 4, 5, 19, 20, 7, 10, 14]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-rotate-array-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchRotateArray {

    public static int searchRotateArrayIndex(int[] arr, int target){
        if(arr == null || arr.length == 0){
            return -1;
        }
        return process(arr, 0, arr.length - 1, target);
    }

    public static int process(int[] arr, int left, int right, int target){
        if(arr[left] == target){
            return getMinIndex(arr, left, target);
        }
        if(arr[right] == target){
            return getMinIndex(arr, right, target);
        }
        left += 1;
        right -= 1;
        int mid = left + ((right - left) >> 1);

        if(arr[mid] == target){
            return getMinIndex(arr, mid, target);
        }

        int leftIndex =-1;
        int rightIndex = -1;
        if(mid >= left){
            leftIndex =  process(arr, left, mid - 1, target);
        }
        if(right >= mid){
            rightIndex = process(arr, mid + 1, right, target);
        }
        if(leftIndex > 0){
            return leftIndex;
        }else if(rightIndex > 0){
            return rightIndex;
        }else {
            return -1;
        }

    }

    public static int getMinIndex(int[] arr, int index, int target){
        while (index-1 >= 0 && arr[index-1] == target){
            index--;
        }
        return index;
    }

    /**
     * 非递归调用
     */
    public static int search(int[] arr, int target){
        if(arr == null || arr.length == 0){
            return -1;
        }
        if(arr[0] == target){
            return 0;
        }
        int left = 1;
        int right = arr.length - 1;
        int mid = 0;
        while (left <= right){
            mid = (left + right) / 2;
            if(arr[mid] == target){
                if(arr[mid] == arr[left]){
                    return left;
                }else {
                    return getMinIndex(arr, mid, target);
                }
            }
            //arr[mid] != target
            if(arr[mid] == arr[left] && arr[mid] == arr[right]){
                while (left != mid && arr[mid] == arr[left]){
                    left++;
                }
                if(left == mid){
                    left = mid + 1;
                    continue;
                }
            }
            //arr[mid] != arr[left]
            //arr[mid] != arr[right]
            if(arr[left] != arr[mid]){
                if(arr[left] <arr[mid]){//left~mid有序
                    if(target >= arr[left] && target < arr[mid]){
                        right = mid - 1;
                    }else {
                        left = mid + 1;
                    }
                }else {//mid - right 有序
                    if(target > arr[mid] && target <= arr[right]){
                        left = mid + 1;
                    }else {
                        right = mid - 1;
                    }
                }
            }else {//arr[left] == arr[mid] => arr[mid] != arr[right]
                if(arr[mid] < arr[right]){//mid - right 有序
                    if(target > arr[mid] && target <= arr[right]){
                        left = mid + 1;
                    }else {
                        right = mid - 1;
                    }
                }else {//left~mid有序
                    if(target >=arr[left] && target < arr[mid]){
                        right = mid - 1;
                    }else {
                        left = mid + 1;
                    }
                }
            }
        }
        return -1;
    }



    public static void main(String[] args){
        int[] arr =new int[]{1, 4, 4, 5, 5, 12, 17, 17, 20, 20, 21, 22, 22, 24, 24, 27, 29, 30, 32, 41, 41,
                45, 45, 46, 47, 49, 53, 57, 57, 63, 63, -63, -63, -62, -56, -52, -48, -47, -44, -43, -43,
                -42, -41, -39, -39, -37, -34, -33, -32, -32, -29, -26, -25, -23, -16, -13, -11, -8, -7, -7, -6, -4, -2, -2};

        System.out.println(search(arr, -23));
    }

}
