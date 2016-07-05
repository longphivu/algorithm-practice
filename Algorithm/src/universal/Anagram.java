package universal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Anagram {
	public static boolean isAnagram(String a, String b){
		//assume that we are using ASCII
		int[] charCnt = new int[256];
		for(int i = 0; i < a.length(); i++){
			charCnt[a.charAt(i)]++;
		}
		for(int i = 0; i< b.length(); i++){
			charCnt[b.charAt(i)]--;
		}
		for(int i = 0; i<charCnt.length; i++){
			if(charCnt[i] != 0) return false;
		}
		return true;
	}
	
	public static void main(String[] arg){
		System.out.println(isAnagram("abcccc","accbccd"));
		
		String a = "a";
		String b = "b";
		
		swap(a, b);
		System.out.println(a);
		System.out.println(b);
		
		int n = 4;
		while(n-->0){
			System.out.println(n);
		}
		
		System.out.println("abba".hashCode());
		System.out.println("aabb".hashCode());
		try {
	        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	        Date date = format.parse("2015-11-14 17:29:16.5431");
	        //Calendar car = (Calendar) format.parse("2015-11-14 17:29:16.543");
	        System.out.println(date);
	        System.out.println(Calendar.getInstance().getTime());
	    } catch (Exception e) {
	    }

	}
	
	public static void swap(String a, String b){
		String tem = a;
		a = b;
		b = tem;
	}
}
