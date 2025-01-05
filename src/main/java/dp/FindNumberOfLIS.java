package dp;


/**
 * https://leetcode.cn/problems/number-of-longest-increasing-subsequence/
 *
 * @auther: LvSheng
 * @date: 2025/1/5
 * @description:
 */
public class FindNumberOfLIS {
    public int findNumberOfLIS(int[] nums) {
        int[] lenDp   = new int[nums.length];
        int[] countDp = new int[nums.length];
        lenDp[0] = 1;
        countDp[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            lenDp[i] = 1;
            countDp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && lenDp[j] + 1 > lenDp[i]) {
                    lenDp[i] = lenDp[j] + 1;
                    countDp[i] = countDp[j];
                } else if (nums[i] > nums[j] && lenDp[j] + 1 == lenDp[i]) {
                    countDp[i] += countDp[j];
                }
            }
        }

        int maxLen   = lenDp[0];
        int maxCount = countDp[0];
        for (int i = 1; i < nums.length; i++) {
            if (lenDp[i] > maxLen) {
                maxLen = lenDp[i];
                maxCount = countDp[i];
            } else if(lenDp[i] == maxLen) {
                maxCount += countDp[i];
            }
        }

        return maxCount;
    }

    public static void main(String[] args) {
        FindNumberOfLIS test = new FindNumberOfLIS();
        System.out.println(test.findNumberOfLIS(new int[] {1, 3, 5, 4, 7}));
        System.out.println(test.findNumberOfLIS(new int[] {1, 1, 1, 1}));
    }
}
