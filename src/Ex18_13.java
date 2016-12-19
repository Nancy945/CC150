/**
 * 有一个单词清单，请设计一个高效算法，计算由清单中单词组成的最大子矩阵，
 * 要求矩阵中的行和列都是清单中的单词。
 * 给定一个string数组dic，代表单词清单，同时给定清单的大小n，请返回最大子矩阵的面积。
 * 保证单词清单的大小小于等于50，且某一长度的串的数量小于等于12。
 * 测试样例：
 * ["aaa","aaa","aaa","bb","bb"]
 * 返回：9
 */

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 1、建立一个数组rows[n]，存放每个字符串的长度
 * 2、从1--n-1,判断相邻两个字符串是否相等,若相等，更新rows[i]=rows[i-1]+rows[i],
 * 否则，rows[i]为该字串的长度，不变
 * 3、最大字母矩阵面积即为max（rows[i]）(i=0,,,n-1);
 */
public class Ex18_13 {
    public static void main(String[] args) {
        String[] test = new String[]{"vvvv","vvvv","vvvv","vvvv","t"};
        System.out.println(findAlphaMatrix(test, 5));
    }
    public static int findAlphaMatrix(String[] dic, int n) {
        // write code here
        int[] rows = new int[n];//记录所有字符串的长度
        for (int i = 0; i < n; i++) {
            rows[i] = dic[i].length();
        }
        Arrays.sort(rows);//对字符串的长度进行排序
        int index = 0;//记录字符串一共有多少个长度
        int[] res = new int[n];//记录字符串每个长度的总和(面积)
        res[0] = rows[0];
        for (int i = 1; i < n; i++) {
            if (rows[i] == rows[i - 1]) {
                res[index] += rows[i];
            } else {
                res[++index] += rows[i];
            }
        }

        int max = res[0];//求取最长的值(面积最大)//也可以直接使用Arrays.sort()返回最后一个
        for (int i = 0; i <= index; i++) {
            if (max < res[i]) {
                max = res[index];
            }
        }
        return max;
    }
}
