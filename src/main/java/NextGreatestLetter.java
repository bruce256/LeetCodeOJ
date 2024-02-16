/**
 * https://leetcode.cn/problems/find-smallest-letter-greater-than-target/description/
 *
 * @author LvSheng
 * @date 2024/2/15
 **/
public class NextGreatestLetter {
	
	public char nextGreatestLetter(char[] letters, char target) {
		if (target >= letters[letters.length - 1]) return letters[0];
		
		int left   = 0;
		int right  = letters.length - 1;
		int middle = 0;
		while (left < right) {
			middle = (left + right) / 2;
			if (target >= letters[middle]) {
				left = middle + 1;
			} else {
				right = middle;
			}
		}
		return letters[left];
	}
	
	public static void main(String[] args) {
		NextGreatestLetter test = new NextGreatestLetter();
		System.out.println(test.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
		System.out.println(test.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'f'));
		System.out.println(test.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j'));
	}
}
