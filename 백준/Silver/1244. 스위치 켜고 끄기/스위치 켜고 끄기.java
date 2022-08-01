import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		int switch_num = Integer.parseInt(in.readLine()); // 스위치 개수 100이하 양의 정수
		String[] st = in.readLine().split(" "); // 스위치 상태
		// 켜짐: 1, 꺼짐 : 0
		
		int student_num = Integer.parseInt(in.readLine()); // 학생 수
		// 남학생: 1, 여학생: 2
		
		
		for (int i = 0; i < student_num; i++) {
			String[] token = in.readLine().split(" ");
			int gen = Integer.parseInt(token[0]);		
			int number = Integer.parseInt(token[1]);
			if (gen == 1) {
				int sn = 1;
				while (sn*number-1 < switch_num) {
					st[sn*number-1] = (st[sn*number-1].equals("1")) ? "0": "1";
					sn++;
 				}
				
			} else {
				int j = 0;
				number--;
				while ( number + j >= 0 && number + j < switch_num
						&& number - j >= 0 &&number - j < switch_num) {
					if ( st[number + j].equals(st[number - j])) {
						if (st[number + j].equals("1")) {
							st[number + j] = "0";
							st[number - j] = "0";
						}else {
							st[number + j] = "1";
							st[number - j] = "1";
						}
						j++;
					} else {
						break;
					}
				}
			}
			
		}
		
		for (int i = 0; i < st.length; i++) {
			if (i == st.length-1) {
				sb.append(st[i]);
				break;
			}
			sb.append(st[i]+ " ");
			if (i > 1 && (i+1) % 20 == 0) {
				sb.append("\n");
			}
		}

		System.out.println(sb);
	}
	
}
