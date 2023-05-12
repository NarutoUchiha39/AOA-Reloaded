import java.util.Scanner;

public class NaiveStringMatching
{
    public static void main(String[] args) {
        System.out.println("Enter string to be searched: ");
        Scanner sc = new Scanner(System.in) ;
        String string = sc.next();
        System.out.println("Enter string to be matched: ");
        String pattern = sc.next();

        int i = 0;
        int j = 0;
        int global = 1;
        boolean temp = false;
        while (i<string.length()){
            if(j==pattern.length()){
                System.out.println("Pattern found");
                temp = true;
                break;
            }
            if(string.charAt(i) == pattern.charAt(j)){
                j+=1;
                i+=1;
            }

            else{
                i = global;
                j=0;
                global+=1;
            }
        }

        if(!temp){
            if(j==pattern.length()){
                System.out.println("Pattern found");
            }
            else {
                System.out.println("Pattern not found :(");
            }
        }

    }
}
