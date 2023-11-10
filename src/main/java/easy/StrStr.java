package easy;

/**
 * @author 吕胜 lvheng1
 * @date 2023/11/5
 **/
public class StrStr {
	
	public int strStr(String haystack, String needle) {
		
		for (int i = 0; i < haystack.length() && (haystack.length() - i) >= needle.length(); i++) {
			int j = 0;
			for (j = 0; j < needle.length(); j++) {
				if (needle.charAt(j) != haystack.charAt(i + j)) {
					break;
				}
			}
			if (j == needle.length()) {
				return i;
			}
		}
		return -1;
	}
	
}
