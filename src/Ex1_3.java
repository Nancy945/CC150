package part1;

/**
 * 
 * @author 余屌丝 题目描述
 * 
 *         给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后， 能否变成另一个字符串。这里规定大小写为不同字符，且考虑字符串重点空格。
 *         给定一个string stringA和一个string
 *         stringB，请返回一个bool，代表两串是否重新排列后可相同。保证两串的长度都小于等于5000。
 *
 */
public class Ex1_3 {
	public static boolean checkSam(String stringA, String stringB) {
        if(stringA.length() != stringB.length())
        	return false;
        
        for(int i = 0 ; i < stringA.length() ;i++){
        	String c = stringA.charAt(i) +"";
        	if(!stringB.contains(c)){
        		return false;
        	}else{
        		stringB.replace(c,"");
        	}
        }
		
		return true;
       
	}

	public static void main(String[] args) {
		String A = "Here you are";
		String B = "Are you here";
		System.out.println(checkSam(A,B));
	}

}
