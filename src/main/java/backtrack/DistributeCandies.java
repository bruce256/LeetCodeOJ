package backtrack;

/**
 * https://leetcode.cn/problems/distribute-candies-among-children-i/
 *
 * @author LvSheng
 * @date 2024/2/6
 **/
public class DistributeCandies {
	
	int result;
	
	public int distributeCandies(int n, int limit) {
		result = 0;
		dfs(n, limit, 0);
		return result;
	}
	
	private void dfs(int n, int limit, int level) {
		if (level == 2) {
			if (n <= limit) {
				result++;
			}
			return;
		}
		
		int min = Math.min(limit, n);
		for (int i = 0; i <= min; i++) {
			dfs(n - i, limit, level + 1);
		}
	}
	
	public static void main(String[] args) {
		DistributeCandies test = new DistributeCandies();
		System.out.println(test.distributeCandies(5, 2));
		System.out.println(test.distributeCandies(3, 3));
	}
}
