/**
 * Created by 余屌丝 on 2016/12/9.
 * 题目描述
 * 在二维平面上，有两个正方形，请找出一条直线，能够将这两个正方形对半分。假定正方形的上下两条边与x轴平行。
 * 给定两个vecotrA和B，分别为两个正方形的四个顶点。请返回一个vector，代表所求的平分直线的斜率和截距，保证斜率存在。
 * 测试样例：
 * [(0,0),(0,1),(1,1),(1,0)],[(1,0),(1,1),(2,0),(2,1)]
 * 返回：[0.0，0.5]
 */
public class Ex7_5 {


    public class Point {
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


    public double[] getBipartition(Point[] A, Point[] B) {
        double[] result = new double[2];
        //求 k  b
        result[0] = (center(A)[1] - center(B)[1]) / (center(A)[0] - center(B)[0]);//k=(y1-y2)/(x1-x2)
        if (Math.abs(result[0]) == 0)
            result[0] = 0.0;
        result[1] = center(A)[1] - result[0] * center(A)[0];//b=y1-k*x1
        return result;
    }

    //求中心点
    public double[] center(Point[] a) {
        double[] result = {0, 0};
        for (int i = 0; i < a.length; i++) {
            result[0] += a[i].x;
            result[1] += a[i].y;
        }
        result[0] /= 4;
        result[1] /= 4;
        return result;
    }

}
