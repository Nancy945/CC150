
/*
题目描述

请实现一个算法，在不使用额外数据结构和储存空间的情况下，翻转一个给定的字符串(可以使用单个过程变量)。
给定一个string iniString，请返回一个string，为翻转后的字符串。保证字符串的长度小于等于5000。
测试样例：
"This is nowcoder"
返回："redocwon si sihT"
*/
public class Ex1_2 {

	//方法1
	private static String func(String s) {
			  int N = s.length ();
	          if ( N <= 1 ) {
	              return s ;
	          }
	          return func(s.substring (N/2, N)) + func(s.substring (0, N/2));
	}

	//方法2
	private static String reverseString(String iniString) {
		StringBuilder sb = new StringBuilder();
		return sb.append(iniString).reverse() + "";
	}
}