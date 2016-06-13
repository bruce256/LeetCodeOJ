package add.binary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author lvsheng
 *         project LeetCodeOJ
 *         date 2016年2月18日
 *         time 下午6:56:35
 */
public class MergeIntervals {

	public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.size() <= 1) {
			return intervals;
		}
		Collections.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				int r = o1.start - o2.start;
				if (r != 0)
					return r;
				return o1.end - o2.end;
			}
		});
		List<Interval> r = new ArrayList<Interval>();
		Interval in = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval cur = intervals.get(i);
			if (cur.start <= in.end && in.end <= cur.end) {
				in.end = cur.end;
			} else if(cur.start > in.end){
				r.add(in);
				in = cur;
			} else if(cur.start <= in.end && in.end >= cur.end){
				continue;
			}
		}
		r.add(in);
		return r;
	}
}

class Interval {

	int	start;
	int	end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}