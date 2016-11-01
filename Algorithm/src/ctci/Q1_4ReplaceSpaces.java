package ctci;

public class Q1_4ReplaceSpaces {
	public static String replaceSpaces(String s) {
		
		char[] str = s.toCharArray();
		
		int spaceCount = 0;
		for (int i = 0; i < s.length(); i ++) {
			if (str[i] == ' ')
				spaceCount++;
		}

		int newLength = s.length() + spaceCount*2;
		char[] ret = new char[newLength];
		
		int j = s.length() - 1;//last char of current string
		for (int i = newLength - 1; i >= 0; i--) {
			if (str[j] == ' ') {
				ret[i] 	 = '0';
				ret[i-1] = '2';
				ret[i-2] = '%';
				i = i - 2;
			} else {
				ret[i] = str[j];
			}
			j--;
		}
		return new String(ret);
	}
	
	public static void main(String[] agr) {
		String s = "This is a Test String";
		System.out.println(replaceSpaces(s));
	}
}
