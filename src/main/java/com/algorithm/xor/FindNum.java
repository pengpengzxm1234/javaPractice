package com.algorithm.xor;

/**
 *
 * 数组中，有一种数出现了奇数次，其他数都出现了偶数次，找到并打印这个数
 * 注：最小的空间复杂度
 * 思路：相同的数异或的值为0 即偶数个数的异或的值是0，奇数次的值异或是该值
 */
public class FindNum {
    /**
     * 数组中，有一种数出现了奇数次，其他数都出现了偶数次，找到并打印这个数
     * @param arr
     */
    public static void printOddTimesNum1(int[] arr){
        int eor = 0;
        for(int i=0;i<arr.length;i++){
            eor ^= arr[i];
        }
        System.out.println(eor);
    }


    /**
     * 一个数组中有两组数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这两种数
     * （提取整型数最右侧的1 = a与（a取反加1）=  a取反加1 = -a）
     * 1)eor = a ^ b (数组中的数全部异或后的结果) eor ！= 0
     *
     */
    public static void printOddTimesNum2(int[] arr){
        int eor = 0;
        for(int i=0;i<arr.length;i++){
            eor ^= arr[i];
        }
        //eor = a ^ b
        //eor != 0
        //eor 必然有一个位置上是1
        int rightOne = eor & (~eor + 1);//提取出最右的1
        //int rightOne = eor & (-eor);//提取出最右的1
        int onlyOne = 0;//eor'
        for(int i = 0; i < arr.length; i++){
            if((arr[i] & rightOne) != 0){//有包含最右侧的1数才做异或操作
                onlyOne ^= arr[i];
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }


    /**
     * 一个数组中，有一个数出现了k次，其他数都出现了m次， M > 1, k < m
     * 找到出现了k次的数，
     * 要求:额外空间复杂度O（1），时间复杂度O(N)
     * 任何数都能转换成数组形式的二进制数
     * 将每个数的二进制数的位置上出现1的数进行累加
     */
    public static int OnlyKTimes(int[] arr, int k, int m){
        int[] t = new int[32];
        //t[0] 0位置的1出现了几个
        //t[i] i位置的1出现了几个
        for(int num : arr){
            for(int i = 0;i <= 31; i++){//每次循环都执行了32次，固定次数，因此这个循环是O(N)
               /* if(((num >> i) & 1) != 0){//num在第i位上是1
                    t[i]++;
                }*/
                t[i] += (num >> i) & 1;
            }
        }
        int ans = 0;
        for(int i=0;i<32;i++){
            if(t[i] % m == 0){
                continue;
            }
            if(t[i] % m == k){//在第i位上 有1
                ans |= (1 << i);
            }else {
                return -1;
            }
        }
        if(ans == 0){
            int count = 0;
            for(int num :arr){
                if(num == 0){
                    count++;
                }
            }
            if(count != k){
                return -1;
            }
        }
        return ans;
    }
}
