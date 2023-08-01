import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static class Meeting {
		int start;
		int end;

		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return this.start + " " + this.end;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 회의의 수 N(1 ≤ N ≤ 100,000)
		int N = Integer.parseInt(in.readLine());

		Meeting[] meetings = new Meeting[N];
		for (int i = 0; i < N; i++) {
			String[] split = in.readLine().split(" ");
			int start = Integer.parseInt(split[0]);
			int end = Integer.parseInt(split[1]);
			meetings[i] = new Meeting(start, end);
		}

		Arrays.sort(meetings, new Comparator<Meeting>() {
			@Override
			public int compare(Meeting o1, Meeting o2) {
				if (o1.end != o2.end)
					return o1.end - o2.end;

				return o1.start - o2.start;
			}

		});

		int cnt = 1;
		int end = meetings[0].end;
		for (int i = 1; i < N; i++) {
			if (meetings[i].start >= end) {
				end = meetings[i].end;
				cnt++;
			}
		}

		System.out.println(cnt);
	}

}