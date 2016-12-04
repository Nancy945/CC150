/**
 * 有两个32位整数n和m，请编写算法将m的二进制数位插入到n的二进制的第j到第i位,其中二进制的位数从低位数到高位且以0开始。
 *  给定两个数int n和int m，同时给定int j和int i，意义如题所述，请返回操作后的数，保证n的第j到第i位均为零，
 *  且m的二进制位数小于等于i-j+1。
 *   测试样例：
 *    1024，19，2，6
 *     返回：1100
 */
public class EX5_1 {
    private int binInsert(int n,int m,int j,int i){
        String a = Integer.toBinaryString(n);
        String b = Integer.toBinaryString(m);
        String t = i-j+1 == b.length() ? a.substring(0,a.length()-i-1) : a.substring(0, a.length()-j-b.length());
        String s = t + b + a.substring(a.length()-j,a.length());
        return Integer.parseInt(s,2);
    }

    private int binInsert1(int n,int m,int j,int i){
        m <<= j;
        return m|n;
    }
}
