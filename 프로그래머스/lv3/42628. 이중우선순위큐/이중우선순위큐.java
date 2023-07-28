import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
		PriorityQueue<Integer> pqMin = new PriorityQueue<>();
		PriorityQueue<Integer> pqMax = new PriorityQueue<>();

		for (int i = 0; i < operations.length; i++) {
			String[] split = operations[i].split(" ");
			int num = Integer.parseInt(split[1]);

			switch (split[0]) {
			case "I":
				pqMin.offer(num);
				pqMax.offer(-num);
				break;
			case "D":
                if (!pqMin.isEmpty()) {
                    if (num == 1) { // 큐에서 최댓값 삭제
                            pqMin.remove(-1 * pqMax.poll());
                    } else { // 큐에서 최솟값 삭제
                            pqMax.remove(-1 * pqMin.poll());
                    }
                }
				break;
			}
		}

		if (!pqMin.isEmpty()) {
			answer[0] = -1 * pqMax.peek();
			answer[1] = pqMin.peek();
		}
		return answer;
    }
}