import java.util.HashSet;
import java.util.*;

// Thus, the key to solving this challenge is determining whether or not the two strings share a common character because if they have a common character then they have a common substring of lengh 1.

// public class CommonSubstring{

//     // public Character[] convertString2List(String str){ //char[] to 
//     //     char[] charArray = str.toCharArray();
//     //     Character[] CharArray = Arrays.stream( charArray ).boxed().toArray( Integer[]::new );
//     //     return CharArray;
//     // }

//     public String haveCommonSubstring(String str1, String str2){
//         HashSet<Character> hs1 = new HashSet<Character>(Arrays.asList(convertString2List(str2)));
//     }
//     public static void main(String[] args){
//         String[] str1 = {"bubblegum"};
//         String[] str2 = {"bluemoon"};

//         System.out.println(haveCommonSubstring(str1, str2));
//     }

// }

public class q18{

    static HashSet<Character> a;
    static HashSet<Character> b;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i = 0; i<n; i++){
            a = new HashSet<Character>();
            b = new HashSet<Character>();
            
            //creating the set of string1
            for(char c : scan.next().toCharArray()) {
                a.add(c);
            }
            //creating the set of string2
            for(char c : scan.next().toCharArray()) {
                b.add(c);
            }

            // for(char elementB : b){ //without using retainAll
            //     if(a.contains(elementB))
            //     System.out.println(a.isEmpty() ? "no"  : "yes");
            // }

            // store the set intersection in set 'a'
            a.retainAll(b);

            System.out.println(a.isEmpty() ? "no"  : "yes");
            
        }
        scan.close();
    }

}