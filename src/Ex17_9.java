/**
 * Created by 余屌丝 on 2017/1/7.
 * 题目描述
 * 请设计一个高效的方法，找出任意指定单词在一篇文章中的出现频数。
 * 给定一个string数组article和数组大小n及一个待统计单词word，请返
 * 回该单词在文章中的出现频数。保证文章的词数小于等于1000。
 */
public class Ex17_9 {
    public int getFrequency(String[] article, int n, String word) {
        // write code here
        int ret = 0;
        for (String str : article) {
            if (str.equals(word))
                ret++;
        }
        return ret;
    }
}
