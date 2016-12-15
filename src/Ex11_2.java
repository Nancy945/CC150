import java.util.*;

/**
 * 请编写一个方法，对一个字符串数组进行排序，将所有变位词合并，保留其字典序最小的一个串。
 * 这里的变位词指变换其字母顺序所构成的新的词或短语。例如"triangle"和"integral"就是变位词。
 * 给定一个string的数组str和数组大小int n，请返回排序合并后的数组。保证字符串串长小于等于20，数组大小小于等于300。
 * 测试样例：
 * ["ab","ba","abc","cba"]
 * 返回：["ab","abc"]
 */
public class Ex11_2 {
    public static void main(String[] args) {
        String[] strings = new String[]{"ab", "ba", "abc","cba"};
        System.out.println(sortStrings(strings,4).size());
    }
    public static ArrayList<String> sortStrings(String[] str, int n) {
        // write code here
        HashMap<String, LinkedList<String>> map = new HashMap<>();
        ArrayList<String> res = new ArrayList<>();
        for (String s : str) {
            String temp = sort(s);
            if(map.get(temp) == null){
                LinkedList<String> list = new LinkedList<>();
                list.add(s);
                map.put(temp, list);
            }else{
                LinkedList<String> list = map.get(temp);
                list.add(s);
            }
        }
        for(String key : map.keySet()){//HashMap对key存储有序，因此最后结果中带有排序，若想按添加的顺序可使用LinkedHashMap
            //sort every list and save res
            LinkedList<String> list = map.get(key);
            Collections.sort(list);
            res.add(list.getFirst());
        }
        Collections.sort(res);
        return res;
    }

    private static String sort(String s) {
        char[] t = s.toCharArray();
        Arrays.sort(t);
        return new String(t);
    }
}
