
package Math;

import Math.Karatsuba;
import java.math.BigInteger;

public class Main
{
    public static void main(String[] args)
    {
        Karatsuba();
    }
    public static void Karatsuba()
    {
        /**Karatsuba Mulitplication**/
        Karatsuba ks=new Karatsuba();
        //input data for exam
        //BigInteger x=new BigInteger("3141592653589793238462643383279502884197169399375105820974944592");
        //BigInteger y=new BigInteger("2718281828459045235360287471352662497757247093699959574966967627");
        
        BigInteger x=new BigInteger("1089");
        BigInteger y=new BigInteger("1478");
        
        BigInteger z=ks.multiply(x,y);
        System.out.printf("The Karatsuba product of %n%s and%n%s is%n%s%n  " ,x.toString(),y.toString(),z.toString());
    } 
}
