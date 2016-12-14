/**
 * 有一个排过序的字符串数组，但是其中有插入了一些空字符串，请设计一个算法，找出给定字符串的位置。算法的查找部分的复杂度应该为log级别。
 * 给定一个string数组str,同时给定数组大小n和需要查找的string x，请返回该串的位置(位置从零开始)。
 * 测试样例：
 * ["a","b","","c","","d"],6,"c"
 * 返回：3
 * Created by Nancy on 2016/12/13.
 * Url:https://github.com/Nancy945/CC150
 */
public class Ex11_5 {
    public int findString(String[] str, int n, String x) {

        int low = 0;
        int high = str.length - 1;


        //等号不能漏！！
        while (low <= high) {
            int mid = low + (high - low) / 2;


            //如果为空，则对mid进行修正到最近的一个不是空的字符上去
            if (str[mid].isEmpty()) {
                int left = mid - 1;
                int right = mid + 1;
                while (true) {
                    if (left < low && right > high) {
                        return -1;
                    } else if (right <= high && !str[right].isEmpty()) {
                        mid = right;
                        break;
                    } else if (left >= low && !str[left].isEmpty()) {
                        mid = left;
                        break;
                    }
                    right++;
                    left--;
                }
            }

            if (str[mid].equals(x)) {
                return mid;
            } else if (str[mid].compareTo(x) < 0) {//搜索右半边
                low = mid + 1;
            } else if (str[mid].compareTo(x) > 0) {//搜索左半边
                high = mid - 1;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        String[] s1 = new String[]{"", "", "", "", "", "", "AECOGS", "AOOFYXQ", "AQ", "AVMMTXNXRA", "BAXEVHLYME", "BCA", "BUV", "BVTPMOLHLC", "BX", "CBDHCOMI", "CDWGWW", "CLG", "CODB", "CWKIYFYHNIY", "CZA", "D", "DEMJMHQYMC", "DFLYAK", "DRR", "DVMVXK", "EIHULX", "EOTCMEXHH", "ETYGMD", "EXXHWDPS", "GNVM", "GVEBGEFC", "HEFVFXDND", "HOUUXMYVC", "IDPNQI", "IIODZQF", "IVPD", "JEGHXQCTTNT", "JJXNXIYGH", "JZBCHVIHK", "LIDN", "LLKIIAZ", "MCBFFHFJBLT", "MRTYDDIM", "MVWD", "N", "NJBXRKL", "NLEMZIZ", "NMMQL", "NQQRGMAN", "NUO", "O", "OBC", "ONES", "OPP", "OXOPR", "Q", "QBZNAE", "QCK", "QGR", "QKLUDC", "RWASPGXEUJY", "TDDWTG", "TER", "TTZK", "TV", "UGUJUEU", "UIQYOL", "USQENKTCEGJ", "UZ", "V", "VDGRM", "VNEFQVOGRYX", "VQNFRIPQR", "WHLNXPTCPAI", "WNYVMOYJBCY", "WSZQBUGJO", "WVPZVAWYJJ", "X", "XMTDBDND", "XPANBKVAKB", "XTPYTK", "Y", "ZUDJMEVLQJN"};
        int n = 84;
        String s2 = "TER";
        System.out.println(new Ex11_5().findString(s1, n, s2));
    }


}
