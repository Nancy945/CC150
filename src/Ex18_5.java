/**
 * 有一篇文章内含多个单词，现给定两个单词，请设计一个高效算法，找出文中这两个单词的最短距离(即最少相隔的单词数,也就是两个单词在文章中位置的差的绝对值)。
 * 给定一个string数组article，代表所给文章，同时给定文章的单词数n和待查找的两个单词x和y。请返回两个单词的最短距离。保证两个单词均在文中出现且不相同，同时保证文章单词数小于等于1000。
 * Created by Nancy on 2016/12/17.
 * Url:https://github.com/Nancy945/CC150
 */
public class Ex18_5 {
    public int getDistance(String[] article, int n, String x, String y) {
        int min = Integer.MAX_VALUE;
        int lastPosWord1 = -1;
        int lastPosWord2 = -1;

        for (int i = 0; i < article.length; i++) {
            String currentWord = article[i];

            if (currentWord.equals(x)) {
                lastPosWord1 = i;
                int distance = lastPosWord1 - lastPosWord2;
                if (lastPosWord2 >= 0 && min > distance) {
                    min = distance;
                }
            } else if (currentWord.equals(y)) {
                lastPosWord2 = i;
                int distance = lastPosWord2 - lastPosWord1;
                if (lastPosWord1 >= 0 && min > distance) {
                    min = distance;
                }
            }
        }

        return min;
    }
}
