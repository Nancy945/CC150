import java.util.*;

/**
 * 对于一个有向图，请实现一个算法，找出两点之间是否存在一条路径。
 * 给定图中的两个结点的指针UndirectedGraphNode* a,UndirectedGraphNode* b(请不要在意数据类型，图是有向图),
 * 请返回一个bool，代表两点之间是否存在一条路径(a到b或b到a)。
 * Created by Nancy on 2016/11/19.
 */
public class Ex4_2 {


    /**
     * 题目分析：
     * 这个题目考察的其实是有向图的遍历，图的遍历分为深度优先遍历和广度优先遍历，深度优先遍历用堆栈实现，广度优先遍历用队列实现，在该题目中给出了每个节点的子节点，所以最好用广度优先遍历。
     * 图的广度优先遍历和树的层次遍历类似，但是不是完全相同，因为图是连通的，所以我们必须去标志那个节点被访问过，那个节点没有被访问过，最后如果全部访问完以后，还没有找到a到b的路径，则返回false。
     * 注意知识点：
     * （1）图中有环，记得标记是否被访问
     * （2）要分别检测两个方向（a->b，b->a）
     */

    private class UndirectedGraphNode {
        int label = 0;
        UndirectedGraphNode left = null;
        UndirectedGraphNode right = null;
        ArrayList<UndirectedGraphNode> neighbors = new ArrayList<>();

        public UndirectedGraphNode(int label) {
            this.label = label;
        }
    }

    Map<UndirectedGraphNode, Boolean> visitedMap = new HashMap<>();

    public boolean checkPath(UndirectedGraphNode a, UndirectedGraphNode b) {

        String method = "BFS";

        switch (method) {
            case "DFS":
                if (checkDFS(a, b)) {
                    return true;
                } else {
                    visitedMap.clear();
                    return checkDFS(b, a);
                }

            case "BFS":
                return checkBFS(a, b) || checkBFS(b, a);

            default:
                //错误的选择
                return false;
        }


    }


    /**
     * 深度优先搜索
     */
    private boolean checkDFS(UndirectedGraphNode a, UndirectedGraphNode b) {


        if (a == null || b == null) {
            return false;
        }
        if (a == b) {
            return true;
        }

        visitedMap.put(a, true);

        for (UndirectedGraphNode neighbor : a.neighbors) {

            //下面的写法是错误的，原因是在这种情况下,如果a先访问邻居c就会最终返回true；如果a先访问到邻居d就会返回false。
//            而访问的顺序与存储的结构和存储的顺序有关，所以可能会存在一定概率出错。简单的说，这种写法的含义是，DFS搜索的到的第一条线路如果是要找到就返回true并不在继续找，如果不是返回false，也不会继续找其他线路了.
//               ↗ d → e
//             a
//               ↘ c → b
//            if (!visitedMap.containsKey(neighbor)) {
//                return checkDFS(neighbor, b);
//            }


            //没访问过等于：根本没包含 或者 包含了但是为false(其中第二种情况不可能存在，因为从来没赋值过false)
            //这种写法是正确的，含义是:找到了就直接返回true，并不再寻找下一条线路。如果没找到，继续for的下一个循环就行（也就是继续找其他线路，不会return false）
            if (!visitedMap.containsKey(neighbor) && checkDFS(neighbor, b)) {
                return true;
            }
        }

        return false;

    }

    private boolean checkBFS(UndirectedGraphNode a, UndirectedGraphNode b) {

        if (a == null || b == null) {
            return false;
        }
        if (a == b) {
            return true;
        }

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        //用来标记是否访问过该节点
        HashMap<UndirectedGraphNode, Boolean> visitedMap = new HashMap<>();
        visitedMap.put(a, true);
        queue.offer(a);
        while (!queue.isEmpty()) {
            UndirectedGraphNode node = queue.poll();//从队列头部移除
            for (UndirectedGraphNode neighbor : node.neighbors) {
                if (!visitedMap.containsKey(neighbor)) {//如果没访问过

                    if (neighbor == b) {
                        return true;
                    }

                    visitedMap.put(neighbor, true);

                    queue.offer(neighbor);

                }
            }
        }


        return false;
    }

    public static void main(String[] args) {
        Ex4_2 obj = new Ex4_2();
        UndirectedGraphNode a = obj.new UndirectedGraphNode(0);
        UndirectedGraphNode b = obj.new UndirectedGraphNode(0);
        UndirectedGraphNode c = obj.new UndirectedGraphNode(0);
        UndirectedGraphNode d = obj.new UndirectedGraphNode(0);
        UndirectedGraphNode e = obj.new UndirectedGraphNode(0);

        ArrayList<UndirectedGraphNode> aList = new ArrayList<>();

        aList.add(d);
        aList.add(c);

        a.neighbors = aList;

        ArrayList<UndirectedGraphNode> cList = new ArrayList<>();
        cList.add(b);
        c.neighbors = cList;

        ArrayList<UndirectedGraphNode> dList = new ArrayList<>();
        aList.add(e);
        d.neighbors = dList;

        System.out.println(obj.checkPath(a, b));
    }
}
