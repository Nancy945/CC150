/**
 * Created by 余屌丝 on 2016/12/1.
 * <p>
 * 题目描述
 * 有一个介于0和1之间的实数，类型为double，返回它的二进制表示。如果该数字无法精确地用32位以内的二进制表示，返回“Error”。
 * 给定一个double num，表示0到1的实数，请返回一个string，代表该数的二进制表示或者“Error”。
 * 测试样例：
 * 0.625
 * 返回：0.101
 */
public class Ex5_2 {
    public static String printBin(double num) {
        // write code here
        StringBuilder temp = new StringBuilder("0.");

        int count = 0;

        while( num > 0 ){
            num = num * 2;
            int bit = num >= 1 ? 1 :0;
            temp.append(bit);


            num = num - bit;


            if(++count >32)
                return "Error";
        }
        return temp.toString();
    }

    public static String printBin2(double num) {
        // write code here
            StringBuilder sb = new StringBuilder();
            sb.append("0.");
            int time = 30;
            double tmp = num;
            while(tmp > 0 && time-- > 0){
                tmp *= 2;
                sb.append((int)tmp);
                tmp = tmp >=1 ? (tmp - 1) : tmp;
            }
            if(tmp > 0)
                return "Error";
            else
                return sb.toString();


    }

    public static void main(String [] args){
        System.out.println("result: "+printBin2(0.46502));
        //  System.out.println("result: "+(0.815 % 10));

    }

}
