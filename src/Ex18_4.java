/**
 * 请编写一个方法，输出0到n(包括n)中数字2出现了几次。
 * 给定一个正整数n，请返回0到n的数字中2出现了几次。
 * 测试样例：
 * 10
 * 返回：1
 * Created by Nancy on 2016/12/17.
 * Url:https://github.com/Nancy945/CC150
 */
public class Ex18_4 {
    //方法 面试金典
    public int countNumberOf2s(int number) {
        //超时
//        if (n < 2) return 0;
//        int count = 0;
//        for (int i = 2; i <= n; i += 10) {
//            while (i != 0) {
//                if (i % 10 == 2) count++;
//                i /= 10;
//            }
//        }
//        return count;

        int count = 0;
        int len = String.valueOf(number).length();
        for (int digit = 0; digit < len; digit++) {
            count += count2sInRangeAtDigit(number, digit);
        }
        return count;
    }

    private int count2sInRangeAtDigit(int number, int d) {
        //例如number = 61532 d =3
        int powerOf10 = (int) Math.pow(10, d);//1000
        int nextPowerOf10 = powerOf10 * 10;//10000
        int right = number % powerOf10;//532

        int roundDown = number - number % nextPowerOf10;//61532-1532 = 60000
        int roundUp = roundDown + nextPowerOf10;//60000+10000 = 70000

        int digit = (number / powerOf10) % 10; //61 % 10
        if (digit < 2) {//若第d位的数字小于2
            return roundDown / 10;//60000/10
        } else if (digit == 2) {
            return roundDown / 10 + right + 1;
        } else {
            return roundUp / 10;
        }

    }
}
