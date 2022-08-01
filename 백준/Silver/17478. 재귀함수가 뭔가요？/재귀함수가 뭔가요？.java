import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int res = 0;
	static String str1 = "\"재귀함수가 뭔가요?\"\n";
	static String str2 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
	static String str3 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
	static String str4 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
	static String result = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n";
	
	static StringBuilder sb = new StringBuilder();
	static String bar = "";
	static void func(int n) {
		String new_bar = bar;
		if (n == 0) {
			sb.append(new_bar + "\"재귀함수가 뭔가요?\"\n");
			sb.append(new_bar + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			sb.append(new_bar + "라고 답변하였지.\n");
			return;
		}
		res += 1;

		sb.append(new_bar + str1);
		sb.append(new_bar + str2);
		sb.append(new_bar + str3);
		sb.append(new_bar + str4);
		bar += "____";
		func(n-1);
		sb.append(new_bar + "라고 답변하였지.\n");
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
	
		int N = Integer.parseInt(in.readLine());
		func(N);
		System.out.println(sb);
	}
}

