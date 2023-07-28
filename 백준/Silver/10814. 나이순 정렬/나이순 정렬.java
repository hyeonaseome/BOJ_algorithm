import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	private static class Person {
		int idx;
		int age;
		String name;

		public Person(int idx, int age, String name) {
			this.idx = idx;
			this.age = age;
			this.name = name;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine()); // 온라인 저지 회원의 수

		Person[] persons = new Person[N];
		for (int i = 0; i < N; i++) {
			String[] split = in.readLine().split(" ");
			persons[i] = new Person(i, Integer.parseInt(split[0]), split[1]);
		}

		Arrays.sort(persons, new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				// 나이순 정렬
				if (p1.age != p2.age) {
					return p1.age - p2.age;
				}

				// 가입한 순
				return p1.idx - p2.idx;
			}
		});

		for (Person p : persons) {
			sb.append(p.age).append(" ").append(p.name).append("\n");
		}
		System.out.println(sb);
	}
}