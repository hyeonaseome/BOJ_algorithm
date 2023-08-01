import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String output = "";
        
        for (int i = 0; i < a.length(); i++){
            char ch = a.charAt(i);
            if (Character.isUpperCase(ch)){
                output += Character.toLowerCase(ch);
            } else {
                output += Character.toUpperCase(ch);
            }
        }
        
        System.out.println(output);
    }
}