package com.cui.offer;

import java.util.HashMap;
import java.util.Map;

//表示数值的字符串
public class No20 {

    public static void main(String[] args) {
        String s = "1a3.14";
        System.out.print(isNumber(s));
    }

    //解法一：有限状态机
    public static boolean isNumber(String s) {
        Map<CharType, Integer>[] states = new Map[10];
        states[0] = new HashMap<>();
        states[0].put(CharType.CHAR_SPACE, 0);
        states[0].put(CharType.CHAR_NUMBER, 2);
        states[0].put(CharType.CHAR_SIGN, 1);
        states[0].put(CharType.CHAR_PIONT, 4);
        states[1] = new HashMap<>();
        states[1].put(CharType.CHAR_NUMBER, 2);
        states[1].put(CharType.CHAR_PIONT, 4);
        states[2] = new HashMap<>();
        states[2].put(CharType.CHAR_NUMBER, 2);
        states[2].put(CharType.CHAR_E, 6);
        states[2].put(CharType.CHAR_PIONT, 3);
        states[2].put(CharType.CHAR_SPACE, 9);
        states[3] = new HashMap<>();
        states[3].put(CharType.CHAR_E, 6);
        states[3].put(CharType.CHAR_NUMBER, 5);
        states[3].put(CharType.CHAR_SPACE, 9);
        states[4] = new HashMap<>();
        states[4].put(CharType.CHAR_NUMBER, 5);
        states[5] = new HashMap<>();
        states[5].put(CharType.CHAR_NUMBER, 5);
        states[5].put(CharType.CHAR_E, 6);
        states[5].put(CharType.CHAR_SPACE, 9);
        states[6] = new HashMap<>();
        states[6].put(CharType.CHAR_SIGN, 7);
        states[6].put(CharType.CHAR_NUMBER, 8);
        states[7] = new HashMap<>();
        states[7].put(CharType.CHAR_NUMBER, 8);
        states[8] = new HashMap<>();
        states[8].put(CharType.CHAR_NUMBER, 8);
        states[8].put(CharType.CHAR_SPACE, 9);
        states[9] = new HashMap<>();
        states[9].put(CharType.CHAR_SPACE, 9);

        int state = 0;
        for(char c: s.toCharArray()) {
            CharType charType = toCharType(c);
            if(states[state].containsKey(charType)) {        //如果当前状态可以转换到下一状态
                state = states[state].get(charType);
            }
            else {                       //如果当前状态没有下一状态可以转换且字符串还没遍历结束，则一定不是字符
                return false;
            }
        }
        return state == 2 || state == 3 || state == 5 || state == 8 || state == 9; //字符串遍历结束，判断是否在终止状态
    }

    public static CharType toCharType(char c) {
        if(c >= '0' && c <= '9')
            return CharType.CHAR_NUMBER;
        if(c == 'e' || c == 'E')
            return CharType.CHAR_E;
        if(c == '+' || c == '-')
            return CharType.CHAR_SIGN;
        if(c == ' ')
            return CharType.CHAR_SPACE;
        if(c == '.')
            return CharType.CHAR_PIONT;
        return CharType.CHAR_ILLEGAL;
    }

    enum CharType {
        CHAR_NUMBER,
        CHAR_PIONT,
        CHAR_SPACE,
        CHAR_E,
        CHAR_SIGN,
        CHAR_ILLEGAL,
    }
}
