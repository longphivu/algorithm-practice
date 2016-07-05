package JavaRevisited;

public class Q06_ReverseString {
	public static String recursive(String a){
		if(a == null) return "";
		if(a.equals("")) return "";
		return a.charAt(a.length()-1) + recursive(a.substring(0,a.length()-1));
	}
	
	public static void main(String... arg){
		String a = "abcdef";
		System.out.println(recursive(a));
	}
}
