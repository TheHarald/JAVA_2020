import java.util.Scanner;

public class Zad7 {


        static int calculateFactorial(int n){
            int result = 1;
            for (int i = 1; i <=n; i ++){
                result = result*i;
            }
            return result;
        }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();

        System.out.println(calculateFactorial(n));

    }

}
