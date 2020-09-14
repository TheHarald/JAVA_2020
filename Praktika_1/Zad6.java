import java.lang.Math;
import java.util.Scanner;
import java.util.Random;
import java.util.*;
public class Zad6
{


    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int size=in.nextInt();
        int masMath[]=new int[size];
        int masRand[]=new int[size];
        Random rand = new Random();
        System.out.println("masMath");
        for(int i=0;i<size;i++)
        {
            masMath[i]=  (int)(Math.random()*100);

            System.out.print(masMath[i]+" ");

        }
        System.out.println("\nRandMath");
        for(int i=0;i<size;i++) {
            masRand[i] = rand.nextInt()%100;
            System.out.print( masRand[i] + " ");
        }
        Arrays.sort(masMath);
        Arrays.sort(masRand);
        System.out.println("\n After sort \n masMath");
        for(int i=0;i<size;i++)
        {
            System.out.print(masMath[i]+" ");

        }
        System.out.println("\nRandMath");
        for(int i=0;i<size;i++) {

            System.out.print(masRand[i] + " ");
        }


    }
}
