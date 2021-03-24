package com.cui.offer;


//替换空格
public class No5 {

    public static void main(String[] args) {

        String s = "We are happy.";
        System.out.println(replaceSpace(s));
        System.out.println(replaceSpace2(s));
    }

    //使用字符数组
    public static String replaceSpace(String s) {

        if(s == null)
            return null;
        if(s.equals(""))
            return "";
        char[] str = s.toCharArray();
        int spaceNums = 0;
        for (char c : str) {
            if (c == ' ')
                spaceNums++;
        }
        if(spaceNums == 0)
            return s;
        int newStrLength = str.length+2*spaceNums;
        char[] newStr = new char[newStrLength];
        int indexOfPre = str.length - 1;
        int indexOfNew = newStrLength-1;
        while(indexOfNew >= 0 ) {
            if (str[indexOfPre] != ' ') {
                newStr[indexOfNew] = str[indexOfPre];
                indexOfPre--;
                indexOfNew--;
            }
            else {
                newStr[indexOfNew--]='0';
                newStr[indexOfNew--]='2';
                newStr[indexOfNew--]='%';
                indexOfPre--;
            }
        }
        return String.valueOf(newStr);
    }

    //使用StringBuilder
    public static String replaceSpace2(String s) {
        if(s == null)
            return null;
        if(s.equals(""))
            return "";
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            }
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
