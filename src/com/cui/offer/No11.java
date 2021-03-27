package com.cui.offer;

//旋转数组的最小数字
public class No11 {
    public static void main(String[] args) {
        int[] a = {3 ,4 ,6 ,1 ,2 ,2};

        System.out.println(minArray(a));
    }

    public static int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;

        while(low < high) {
            int mid = (low + high) / 2;
            if(numbers[mid] > numbers[high])
                low = mid + 1;
            else if(numbers[mid] < numbers[high])
                high = mid;
            else {
                return findMin(low, high, numbers);
            }
        }
        return numbers[low];
    }

    public static int findMin(int low, int high, int[] numbers) {
        int result = numbers[low];
        for(int i = low + 1; i <= high; i++) {
            if(numbers[i] < result)
                result = numbers[i];
        }
        return result;
    }

}
