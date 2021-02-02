package com.algorithm.factorial;

/**
 * n的阶乘，前提：不适用大数据的对象，
 * 需要考虑溢出，
 */
public class NFactorial {
    public static String nFactorial(int n){
        int[] arr = new int[n * 4];
        int p = 0;//记录当前位置
        arr[0] = 1;
        for(int i = 1;i<=n;i++){
            int t = 0;
            for(int j = 0; j < p; j++){
                arr[j] = arr[j] * i + t;
                if(arr[j] >= 10){
                    t = arr[j] / 10;
                    arr[j] = arr[j] % 10;
                }
            }
           int cur = arr[p] * i + t;
           if(cur >= 10){
               arr[p+1] = cur / 10;
               cur = cur % 10;
               arr[p] = cur;
               p++;
           }else {
               arr[p] = cur;
           }
        }
        StringBuffer ans = new StringBuffer();
        for(int i =p;i>=0;i--){
            ans.append(arr[i]);
        }
        return ans.toString();
    }

    public static void main(String[] args){
        System.out.println(nFactorial(5));
    }
}
