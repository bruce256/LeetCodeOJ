package nowcoder;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * short job first
 * 华为上机题
 *
 * @author LvSheng
 * @date 2020/2/23
 **/
public class SJF {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			int coreNum = sc.nextInt();
			int jobNum  = sc.nextInt();
			
			PriorityQueue<Integer> jobs = new PriorityQueue<>(jobNum);
			for (int i = 0; i < jobNum; i++) jobs.add(sc.nextInt());
			
			int[] cpu = new int[coreNum];
			for (int i = 0; i < coreNum && i < jobNum; i++) cpu[i] = jobs.poll();
			
			// corner case : CPU核心数比任务数多
			if (coreNum >= jobNum) {
				System.out.println(cpu[jobNum - 1]);
				continue;
			}
			
			int cost = 0;
			while (!jobs.isEmpty()) {
				Arrays.sort(cpu);
				int elapse = cpu[0];
				cost += elapse;
				
				for (int i = 0; i < coreNum; i++) cpu[i] -= elapse;
				
				// corner case : 同时有多个任务结束
				for (int i = 0; i < coreNum && cpu[i] == 0 && !jobs.isEmpty(); i++) {
					cpu[i] = jobs.poll();
				}
			}
			Arrays.sort(cpu);
			cost += cpu[coreNum - 1];
			System.out.println(cost);
		}
	}
}
