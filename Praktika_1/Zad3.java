
import java.util.Scanner;

public class Zad3
{


    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int sum =0;
        int i = in.nextInt();
        int[] arr = new int[i];

        for(int j=0;j< arr.length;j++)
        {   arr[j] = in.nextInt();
            sum+=arr[j];
        }

        System.out.println(sum);
    }
}
