import java.util.HashMap;

/**
 * 在二维平面上，有一些点，请找出经过点数最多的那条线。
 * 给定一个点集vector p和点集的大小n,没有两个点的横坐标相等的情况,请返回一个vector，代表经过点数最多的那条直线的斜率和截距。
 * Created by Nancy on 2016/12/2.
 * Url:https://github.com/Nancy945/CC150
 */
public class Ex7_6 {


    private class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point() {
            this.x = 0;
            this.y = 0;
        }
    }

    //面向对象的编程思想
    private class Line {
        private double k;  //斜率
        private double b;  //截距
        private double epsilon = 0.0001; //误差

        Line(double k, double b) {
            this.k = k;
            this.b = b;
        }

        //比较两个double是否相等
        private boolean isEqualValue(double a, double b) {
            return (Math.abs(a - b) < epsilon);
        }

        //重写equals方法当此方法被重写时，通常有必要重写 hashCode 方法，
        //以维护 hashCode 方法的常规协定，该协定声明相等对象必须具有相等的哈希码。
        public boolean equals(Object obj) {
            if (obj instanceof Line) {
                return isEqualValue(k, ((Line) obj).k) && isEqualValue(b, ((Line) obj).b);
            }
            return super.equals(obj);
        }

        //HashMap对应的应该是HashSet，数据结构是哈希表，先比hashCode()，再比equals
        public int hashCode() {
            String str = String.valueOf(k) + String.valueOf(b);
            return str.hashCode();
        }
    }


    public double[] getLine(Point[] p, int n) {
        HashMap<Line, Integer> lineNum = new HashMap<>();
        int max = 0;
        double slope = Double.POSITIVE_INFINITY, intercept = 0;
        //把所有线取出来求出斜率和截距,并用哈希图存储下线条和个数的键值对
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double k = (double) (p[j].y - p[i].y) / (p[j].x - p[i].x);
                double b = (double) (p[i].y - k * p[i].x);
                Line line = new Line(k, b);
                if (lineNum.containsKey(line)) {
                    int num = lineNum.get(line) + 1;
                    lineNum.put(line, num);
                    //不断调整最大值
                    if (num > max) {
                        max = num;
                        slope = k;
                        intercept = b;
                    }
                } else
                    lineNum.put(line, 1);
            }
        }
        return new double[]{slope, intercept};
    }
}

