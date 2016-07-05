package leetcode;

public class Q14_LongestCommonPrefix {
	 public static String longestCommonPrefix(String[] strs) {
	        if( strs == null || strs.length == 0) return "";
	        
	        StringBuilder sb = new StringBuilder();
	        String curWord = strs[0];
	        while( !curWord.isEmpty() ){
	            int mid = curWord.length()/2;
	            String word = curWord.substring(0, mid);
	            if(word.isEmpty()) break;
	            if(isCommonPrefix(strs, sb.toString()+word)){
	                sb.append(word);
	                curWord = curWord.substring(mid, curWord.length());
	            } else {
	                curWord = word;
	            }
	        }
	        return sb.toString();
	    }
	    
	    public static boolean isCommonPrefix(String[] strs, String word){
	        for(String str : strs){
	            if(str.indexOf(word) == -1)
	                return false;
	        }
	        return true;
	    }
	    public static void main(String[] arg){
	    	String[] strs = {"abcdd","abcd","abc","abc","abcdd","acdd"};
	    	System.out.println(longestCommonPrefix(strs));
	    }
}
