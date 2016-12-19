import java.util.*;

/**
 * 现有一个字典，同时给定字典中的两个字符串s和t，给定一个变换，
 * 每次可以改变字符串中的任意一个字符，请设计一个算法，
 * 计算由s变换到t所需的最少步数，同时需要满足在变换过程中的每个串都是字典中的串。
 * 给定一个string数组dic，同时给定数组大小n，串s和串t，
 * 请返回由s到t变换所需的最少步数。若无法变换到t则返回-1。
 * 保证字符串长度均小于等于10，且字典中字符串数量小于等于500。
 * 测试样例：
 * ["abc","adc","bdc","aaa”],4,”abc","bdc"
 * 返回：2
 */

/**
 * 思路：最短搜索路径，所以是广度优先搜索(BFS)。
 * 按照定义，存在一个字母差异的单词为邻居，因此采用逐位替换字母并查找字典的方法寻找邻居。
 * 对队列中的每个单词记录路径长度。queue<pair<string,int> > q;
 * 从start进入队列记作0.长度为i的字母的邻居，如果没有访问过，则路径长度为i+1
 */
public class Ex18_10 {
    public static void main(String[] args) {
        String[] test = new String[]{"vvz", "bbaa", "f", "bbba", "bbaa", "baoa", "btoa", "bbba", "dcki", "bbbb", "ge", "atoj", "baaa", "btoj", "ae"};
        System.out.println(countChanges(test, 15, "atoj", "bbbb"));
    }

    public static int countChanges(String[] dic, int n, String s, String t) {
        if(dic == null || n <= 0 || s.length() != t.length())
            return -1;
        if(s.equals(t))
            return 0;
        Map<String,Integer> map = new HashMap<String,Integer>();//记录当前字符串被改变的次数
        LinkedList<String> queue = new LinkedList<>();//BFS的队列
        map.put(s,0);
        queue.add(s);
        while(!queue.isEmpty()){
            String top = queue.removeFirst();
            List<String> adjs =getAdjStr(dic,n,top);//获取当前字符串的邻接字符串（只有一位不相同的字符串）
            for (String adj : adjs) {
                if (adj.equals(t)) {//当前变换已经与目的字符串一致
                    return map.get(top) + 1;//因为是邻接的关系，所以需要+1
                } else {
                    if (map.get(adj) == null) {
                        map.put(adj, map.get(top) + 1);//因为是邻接的关系，所以需要+1
                        queue.add(adj);
                    }
                }
            }
        }
        return -1;
    }

    public static List<String> getAdjStr(String[] dic, int n, String s) {
        List<String> adjs = new ArrayList<>();//存放邻接字符串
        String t;
        int count;//记录不同字符的个数
        for (int i = 0; i < n; i++) {
            t = dic[i];
            count = 0;
            if (s.length() != t.length())//长度不一致的不做判断
                continue;
            int j = 0;
            for (; j < s.length(); j++) {//逐位比较，如果不同位数超过1，直接结束
                if (s.charAt(j) != t.charAt(j)) {
                    if (count != 0)
                        break;
                    count++;
                }
            }
            if (j != s.length() || count != 1)//判断是否遍历到字符串s的最后一位，或者不是恰好改变了一个字符
                continue;
            adjs.add(t);
        }
        return adjs;
    }
}
