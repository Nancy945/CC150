import java.util.ArrayList;

/**
 * Created by 余屌丝 on 2016/11/26.
 * 题目描述
 * 有一棵无穷大的满二叉树，其结点按根结点一层一层地从左往右依次编号，根结点编号为1。
 * 现在有两个结点a，b。请设计一个算法，求出a和b点的最近公共祖先的编号。
 * 给定两个int a,b。为给定结点的编号。请返回a和b的最近公共祖先的编号。
 * 注意这里结点本身也可认为是其祖先。
 * 测试样例：
 * 2，3
 * 返回：1
 */
public class Ex4_7 {
    public static ArrayList<Integer> getRoot(int root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (root != 0) {
            //包含自身
            list.add(root);
            root /= 2;
        }
        return list;
    }

    public static int getLCA(int a, int b) {
        ArrayList<Integer> listA = getRoot(a);
        ArrayList<Integer> listB = getRoot(b);
        return listA.get(0);
    }

    public class LCA {
        public int getLCA(int a, int b) {
            int i = a, j = b;
            while (i != j) {
                if (i >> 1 > j >> 1)
                    i >>= 1;
                else if (i >> 1 < j >> 1)
                    j >>= 1;
                else {
                    i >>= 1;
                    j >>= 1;
                }
            }
            return i;
        }
    }


    public static void main(String[] args) {
        getLCA(16, 17);
    }
}
