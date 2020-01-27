package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LvSheng
 * @date 2020/1/26
 **/
public class RestoreIpAddresses {
	
	public List<String> restoreIpAddresses(String s) {
		List<String> list = new ArrayList<>();
		if (s.length() > 12) {
			return list;
		}
		dfs(list, s, 0, 0, "");
		return list;
	}
	
	private void dfs(List<String> list, String s, int pos, int level, String ip) {
		if (level == 3) {
			// 边界情况
			if (pos >= s.length()) return;
			String tmp = s.substring(pos);
			// int可能溢出
			if (tmp.length() > 3 || (tmp.length() > 1 && tmp.startsWith("0"))) {
				return;
			}
			int cur = Integer.parseInt(tmp);
			
			if (cur <= 255) {
				String wholeIp = ip + "." + cur;
				
				// 前导0被删除的情况
				if (wholeIp.length() - 4 == s.length()) {
					list.add(wholeIp.substring(1));
				}
			}
			return;
		}
		
		for (int len = 1; len <= 3 && pos + len < s.length(); len++) {
			String tmp = s.substring(pos, pos + len);
			int    cur = Integer.parseInt(tmp);
			
			// 剪枝
			if (cur > 255 || (len > 1 && tmp.startsWith("0"))) {
				return;
			}
			
			dfs(list, s, pos + len, level + 1, ip + "." + cur);
		}
	}
	
	public static void main(String[] args) {
		RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
		System.out.println(restoreIpAddresses.restoreIpAddresses("0279245587303"));
	}
}
