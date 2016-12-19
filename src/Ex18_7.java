import java.util.*;

/**
 * 有一组单词，请编写一个程序，在数组中找出由数组中字符串组成的最长的串A，
 * 即A是由其它单词组成的(可重复)最长的单词。
 * 给定一个string数组str，同时给定数组的大小n。
 * 请返回最长单词的长度，保证题意所述的最长单词存在。
 * 测试样例：
 * ["a","b","c","ab","bc","abc"],6
 * 返回：3
 */
public class Ex18_7 {

    public static void main(String[] args) {
        String[] test = new String[]{"c", "ab", "bc", "abc"};
        System.out.println(getLongest(test, 4));
    }

    private static ArrayList<String> list;
    public static int getLongest(String[] str, int n) {
        // write code here
        list = new ArrayList<>();
        list.addAll(Arrays.asList(str));
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() < o2.length()) {
                    return -1;
                } else {
                    return o1.compareTo(o2);
                }
            }
        });
        for (int i = list.size()-1; i >= 0; i--) {
            String t = list.get(i);
            list.remove(t);
            if (check(t, list)) {
                return t.length();
            }
            list.add(str[i]);
        }
        return 0;
    }

    private static boolean check(String s, ArrayList<String> l) {
        if (l.contains(s)) {
            //直接包含了该字符串，即原始数组中有重复元素
            return true;
        } else {
            //不包含
            String temp = s;
            for (int i = 0; i < l.size(); i++) {//"c", "ab", "bc", "abc"
                temp = s;
                for (int j = l.size() - 1 - i; j >= 0; j--) {//从最长的开始删除
                    if (temp.contains(l.get(j))) {
                        temp = temp.replaceAll(l.get(j), "");//删除匹配上的
                    }
                }
                if (temp.equals("")) {
                    //s由其他字符串组合而成
                    return true;
                }
            }
            if (temp.equals("")) {
                //s由其他字符串组合而成
                return true;
            } else {
                //其他字符串不能构成该字符串
                return false;
            }
        }
    }

//方法2
    public int getLongest01(String[] str, int n) {
        // write code here
        if(str==null||n==0)
            return 0;
        Arrays.sort(str,new Comparator<String>(){
            public int compare(String s1,String s2){
                return s2.length()-s1.length();
            }
        });
        HashMap<String,Boolean> map = new HashMap<String,Boolean>();
        for(String s:str)
            map.put(s,true);
        for(String ss:str){
            if(canBuild(ss,map,true))
                return ss.length();
        }
        return 0;
    }
    boolean canBuild(String s,HashMap<String,Boolean> map,boolean isOriginal){
        if(s==null||s.length()==0)
            return false;
        if(map.containsKey(s)&&!isOriginal)
            return map.get(s);
        for(int i=1;i<s.length();i++){
            String s1 = s.substring(0,i);
            String s2 = s.substring(i);
            if(map.containsKey(s1)&&map.get(s1)==true&&canBuild(s2,map,false))
                return true;
        }
        map.put(s,false);
        return false;
    }
}
