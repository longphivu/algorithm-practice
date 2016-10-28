package leetcode.string;

public class Q038_CountAndSay {
	public String countAndSay(int n) {
        StringBuilder next = new StringBuilder();
        StringBuilder curr = new StringBuilder("1");
        
        while (--n > 0) {
            for (int i = 0; i < curr.length(); i++) {
                //count
                int count = 1;
                while (i != curr.length()-1 && curr.charAt(i) == curr.charAt(i+1)) {
                    count++;
                    i++;
                }
                //say
                next.append(count).append(curr.charAt(i));
            }
            //swap to avoid create new object
            StringBuilder temp = curr;
            curr = next;
            next = temp;
            next.setLength(0);
        }
        return curr.toString();
    }
}
