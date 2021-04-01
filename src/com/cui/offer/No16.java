package com.cui.offer;

//数值的整数次方
public class No16 {

    public static void main(String[] args) {
        System.out.println(myPow(2.00000,10));
        System.out.println(myPow(2.10000,3));
        System.out.println(myPow(2.00000,-2));
    }

    public static double myPow(double x, int n) {
        long exponent = n;
        if(x == 0)
            return 0.0;
        if(exponent == 0)
            return 1.0;
        double result = 1.0;
        boolean negative = false;
        if(exponent < 0) {
            exponent = -exponent;
            negative = true;
        }
        do {
            if ((exponent & 1) == 1)
                result *= x;
            exponent >>= 1;
            x *= x;
        } while (exponent != 0);
        if(negative)
            result = 1.0 / result;
        return result;
    }

}
