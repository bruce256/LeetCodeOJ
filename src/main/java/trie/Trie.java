package trie;

/**
 * https://leetcode.cn/problems/implement-trie-prefix-tree/description
 *
 * @auther: LvSheng
 * @date: 2024/6/23
 * @description:
 */
public class Trie {
	
	Trie[]  children;
	boolean isEnd;
	
	
	public Trie() {
		children = new Trie[26];
		isEnd    = false;
	}
	
	public void insert(String word) {
		Trie root = this;
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (root.children[index] == null) {
				root.children[index] = new Trie();
			}
			root = root.children[index];
		}
		root.isEnd = true;
	}
	
	public boolean search(String word) {
		Trie root = this;
		for (int i = 0; i < word.length(); i++) {
			if (root == null) {
				return false;
			}
			root = root.children[word.charAt(i) - 'a'];
		}
		return root == null ? false : root.isEnd;
	}
	
	public boolean startsWith(String prefix) {
		Trie root = this;
		for (int i = 0; i < prefix.length(); i++) {
			if (root == null) {
				return false;
			}
			root = root.children[prefix.charAt(i) - 'a'];
		}
		return root == null ? false : true;
		
	}
	
	public static void main(String[] args) {
		Trie test = new Trie();
		test.insert("apple");
		System.out.println(test.search("apple"));
		System.out.println(test.search("app"));
		System.out.println(test.startsWith("app"));
		System.out.println(test.startsWith("c"));
	}
}
