/**
利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。
比如，字符串“aabcccccaaa”经压缩会变成“a2b1c5a3”。若压缩后的字符串没有变短，则返回原先的字符串。
给定一个string iniString为待压缩的串(长度小于等于10000)，
保证串内字符均由大小写英文字母组成，返回一个string，为所求的压缩后或未变化的串。
测试样例
"aabcccccaaa"
返回："a2b1c5a3"
"welcometonowcoderrrrr"
返回："welcometonowcoderrrrr"
*/


public class Ex1_5 {
    public String zipString(String iniString) {
        // write code here
        if (iniString == null) {
            return null;
        }
        String res = "";
        res += iniString.charAt(0);
        int num = 1;
        char pers = iniString.charAt(0);
        boolean flag = false;
        for (int i = 1; i < iniString.length(); i++) {
            char temp = iniString.charAt(i);
            if (temp == pers) {
                num++;
                if (i < iniString.length() - 1) {
                    continue;
                }
                flag = true;
            }
            res += num;
            num = 1;
            pers = temp;
            if (!flag) {
                res += pers;
                if (i == iniString.length() - 1) {
                    res += num;
                }
            }
        }
         
        return res.length() < iniString.length() ? res : iniString;
    }
}