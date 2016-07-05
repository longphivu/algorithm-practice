package leetcode;

public class Q5_LongestPalindromicSubstring {

	public static void main(String[] args) {
		System.out.println(simple("acacad"));
		System.out.println(palindromeHelper("acacad", 2,2));
	}
	
	public static String dynamic(String s){
		if(s.isEmpty()) return "";
		
		int start = 0, end = 0;
		int len = s.length();
		boolean[][] table = new boolean[len][len];
		
		//
		for(int i = 0; i < len; i++){
			table[i][i] = true;//every single char is palindrome
		}
		
		for(int i = 1; i < len; i++){
			if(s.charAt(i) == s.charAt(i-1)){ //check for 2 consecutive chars 
				table[i-1][i] = true; 
				start = i-1;
				end = i+1;
			}
		}
		
		//start checking for substring that has len >= 3 
		for(int l = 1; l < len; l++){
			for(int i = 0; i<len-l-1; i++){
				int j = i+l+1;
				if(s.charAt(i) == s.charAt(j) && table[i+1][j-1] == true){ //if the inside is palindrome and outer bound is the same
					table[i][j]=true;
					start = i;
					end = j+1;
				} 
			}
		}
		
		return s.substring(start, end);
	}

	public static String simple(String s){
		int max = 0;
		int start = 0, end = 0;
		for(int i = 0; i<s.length(); i++){
			int l1 = palindromeHelper(s, i, i);
			int l2 = palindromeHelper(s, i, i+1);
			if(l1 > max){
				max = l1;
				start = i-l1/2;
				end = i+l1/2;
			}
			if(l2 > max){
				max = l2;
				start = i-l2/2;
				end = i+1+l2/2;
			}
		}
		return s.substring(start, end+1);
	}
	
	public static int palindromeHelper(String st, int s, int e){
		while(s >= 0 && e < st.length() && st.charAt(s) == st.charAt(e)){
			s--;e++;
		}
		return e-s+1;
	}
}
