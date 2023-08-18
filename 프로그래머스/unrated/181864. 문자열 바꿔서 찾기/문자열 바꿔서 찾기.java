class Solution {
    public int solution(String myString, String pat) {
        pat = pat.replaceAll("A", "C");
        pat = pat.replaceAll("B", "A");
        pat = pat.replaceAll("C", "B");

        return myString.contains(pat) ? 1 : 0;
    }
}