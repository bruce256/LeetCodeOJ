package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 吕胜 lvheng1
 * @date 2023/11/11
 **/
public class CanConstruct {
	
	public boolean canConstruct(String ransomNote, String magazine) {
		int[] mapa = new int[26];
		int[] mapb = new int[26];
		
		
		for (int i = 0; i < ransomNote.length(); i++) {
			char key = ransomNote.charAt(i);
			mapa[key - 'a']++;
		}
		
		for (int i = 0; i < magazine.length(); i++) {
			char key = magazine.charAt(i);
			mapb[key - 'a'] ++;
		}
		
		for (int i = 0; i < 26; i++) {
			if(mapb[i] < mapa[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		CanConstruct can = new CanConstruct();
		System.out.println(can.canConstruct("a", "b"));
		System.out.println(can.canConstruct("aa", "ab"));
		System.out.println(can.canConstruct("aa", "aab"));
	}
}
