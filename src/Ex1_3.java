package part1;

/**
 * 
 * @author ����˿ ��Ŀ����
 * 
 *         ���������ַ��������д����ȷ������һ���ַ������ַ��������к� �ܷ�����һ���ַ���������涨��СдΪ��ͬ�ַ����ҿ����ַ����ص�ո�
 *         ����һ��string stringA��һ��string
 *         stringB���뷵��һ��bool�����������Ƿ��������к����ͬ����֤�����ĳ��ȶ�С�ڵ���5000��
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
