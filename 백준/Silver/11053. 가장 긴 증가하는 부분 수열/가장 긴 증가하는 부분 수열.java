import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 수열의 크기
		int N = Integer.parseInt(in.readLine());
		int[] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] C = new int[N];

		int size = 0;

		for (int i = 0; i < N; i++) {
			int pos = Arrays.binarySearch(C, 0, size, arr[i]);
			if (pos >= 0)
				continue;

			int insertPos = Math.abs(pos) - 1;
			C[insertPos] = arr[i];

			if (insertPos == size)
				size++;
		}

		System.out.println(size);
	}
}