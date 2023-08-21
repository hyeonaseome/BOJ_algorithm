import java.util.*;

class Solution {
    public class Student implements Comparable<Student>{
        int rank;
        int idx;
        public Student (int rank, int idx){
            this.rank = rank;
            this.idx = idx;
        }
        @Override
        public int compareTo(Student s) {
            return this.rank - s.rank;
        }
        
        @Override
        public String toString() {
            return this.rank + " " + this.idx;
        }

    }

    public int solution(int[] rank, boolean[] attendance) {
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < attendance.length; i++) {
            if (attendance[i]) {
                list.add(new Student(rank[i], i));
            }
        }
        
        Collections.sort(list);
        
        return 10000 * list.get(0).idx + 100 * list.get(1).idx + list.get(2).idx;
    }
}