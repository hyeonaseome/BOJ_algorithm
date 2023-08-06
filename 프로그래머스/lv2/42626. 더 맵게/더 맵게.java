import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        SortedMap<Long,Integer> map = new TreeMap<>();
        for(long x : scoville) {
            map.put(x,map.getOrDefault(x,0)+1);
        }
        int res =0;
        while(true) {
            if(map.size()==1) {
                break;
            }
            int cnt =0;
            long[] arr = new long[2];
            for(long x : map.keySet()) {
                int len = Math.min(2 - cnt, map.get(x));
                for (int i = 0; i < len; i ++)  {
                    arr[cnt++] = x;
                }
                if(cnt==2) {
                    break;
                }
            }
            if(arr[0]>=K) {
                break;
            }
            map.put(arr[0],map.get(arr[0])-1);
            if(map.get(arr[0])==0) {
                map.remove(arr[0]);
            }
            map.put(arr[1],map.get(arr[1])-1);
            if(map.get(arr[1])==0) {
                map.remove(arr[1]);
            }
            long x = arr[0]+arr[1]*2;
            map.put(x, map.getOrDefault(x,0) +1);

            res++;
        }
        if(map.firstKey()>=K){
            return res;
        }
        return -1;
    }
}
