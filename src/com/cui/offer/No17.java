package com.cui.offer;

import java.util.Arrays;

// 打印从1到最大的n位数（要考虑大数问题）
public class No17 {

    public static char[] number;
    public static String[] result;
    public static int count = -1;      // 用于记录当前存入多少数据到String数组

    public static void main(String[] args) {
        for(String i : printNumbers(3)) {
            System.out.print(i);
            System.out.print(",");
        }
    }

    public static String[] printNumbers(int n) {

        number = new char[n];
        result = new String[(int) Math.pow(10 ,n) - 1];
        dfs(0, n);
        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < n; j++) {
                if(result[i].charAt(j) != '0') {
                    result[i] = result[i].substring(j);      // 除去前面多余的0
                    break;
                }
            }
        }
        return result;
    }

    public static void dfs(int index, int n) {

        if(index == n) {
            if(count == -1)             // 除去第一个数
                count++;
            else {
                result[count] = new String(number);   // 将字符数组变为字符串方法
                count++;
            }
            return ;
        }

        for(int i = 0; i < 10; i++) {
            number[index] = (char) (i + 48);      // int和char转换规律
            dfs(index + 1, n);
        }
    }
}
