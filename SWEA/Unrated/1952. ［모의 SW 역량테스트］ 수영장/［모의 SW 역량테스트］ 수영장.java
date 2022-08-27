import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
	private static List<Integer> threeMonth;
	private static boolean[] isVisited;
	private static int[] pays;
	private static int startMonth, endMonth, cost3, answer;
	public static void main(String args[]) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int T;
		T=Integer.parseInt(in.readLine());
		for(int test_case = 1; test_case <= T; test_case++){
			sb.append("#" + test_case + " ");
			StringTokenizer st = new StringTokenizer(in.readLine());
			// 1일, 1달, 3달, 1년
			int cost1 = Integer.parseInt(st.nextToken());
			int cost2 = Integer.parseInt(st.nextToken());
			cost3 = Integer.parseInt(st.nextToken());
			int cost4 = Integer.parseInt(st.nextToken());

			int[] useday = new int[12];
			st = new StringTokenizer(in.readLine());
			startMonth = -1;
			endMonth = -1;
			for (int i = 0; i < 12; i++) {
				useday[i] = Integer.parseInt(st.nextToken());
				if (startMonth == -1 && useday[i] > 0 ) {
					startMonth = i;
				}
				else if( useday[i] > 0 && startMonth != -1) {
					endMonth = i;
				}
			}


			pays = new int[12];

			// 1일권 vs 1달
			int pay1 = 0;
			for (int i = startMonth; i <= endMonth; i++) {
				int p = useday[i];
				if (p > 0) {
					pays[i] =  Math.min(p * cost1, cost2);
					pay1 += pays[i];
				}
			}

			// 3달 vs pay1 경우의 수 모두
			threeMonth = new ArrayList<>();
			int pay2 = 0;
			for (int i = startMonth; i <= endMonth; i++) {
				int a = 0;
				for (int j = 0; j < 3; j++) {
					if (i + j < 12) {
						a += pays[i + j];
					}
				}
				if( a > cost3) {
					threeMonth.add(i);
				}
			}

			answer = pay1;
			
			isVisited = new boolean[12];
			if (!threeMonth.isEmpty()) subset(threeMonth.get(0));

			// 1년
			if (answer > cost4) {
				answer = cost4;
			}
			sb.append(answer);
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void subset(int cnt) {
		if(cnt > endMonth) {
			int getpay = 0;
			for (int i = 0; i < 12; i++) {
				if (isVisited[i]) {
					getpay += cost3;
					i = i + 2;

				}
				else {
					getpay += pays[i];
				}
			}
			if (answer > getpay) {
				answer = getpay;
			}
			return;

		}

		if(threeMonth.contains(cnt)) {
			isVisited[cnt] = true;
			if (cnt + 1 < 12) isVisited[cnt + 1] = true;
			if (cnt + 2 < 12) isVisited[cnt + 2] = true;
			subset(cnt + 3);			
		}

		isVisited[cnt] = false;
		if (cnt + 1 < 12) isVisited[cnt + 1] = false;
		if (cnt + 2 < 12) isVisited[cnt + 2] = false;
		subset(cnt + 1);

	}
}