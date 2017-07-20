
public class Solution {
	public static void main(String[] args) {
		LRU l = new LRU(1);
		l.set(2, 1);
		System.out.println(l.get(2));
		l.set(3, 2);
		System.out.println(l.get(2));
		System.out.println(l.get(3));
	}
}
