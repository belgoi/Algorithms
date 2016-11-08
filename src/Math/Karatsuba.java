/*
* Implements the Karatsuba multiplication algorithm. Useful for multiplying 
* two large integers
 */
package Math;
import java.math.BigInteger;
import java.lang.Math;

public class Karatsuba
{
    public Karatsuba(){}

   public BigInteger multiply(BigInteger x,BigInteger y)
   {
       int N=Math.max(x.bitLength(),y.bitLength());
        if (N<=3)
            return x.multiply(y);
        //divide N & round up
        N=(N/2)+(N%2);

        BigInteger a=x.shiftRight(N);
        BigInteger b=x.subtract(a.shiftLeft(N));
        BigInteger c=y.shiftRight(N);
        BigInteger d=y.subtract(c.shiftLeft(N));
                
        BigInteger ac=multiply(a,c);
        BigInteger bd=multiply(b,d);
        BigInteger abcd=multiply(a.add(b),c.add(d));
        
        return bd.add(abcd.subtract(bd).subtract(ac).shiftLeft(N)).add(ac.shiftLeft(2*N));


    }
   
}
