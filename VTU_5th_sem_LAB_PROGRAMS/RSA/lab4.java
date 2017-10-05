import java.math.BigInteger;

import java.util.Random;
import java.util.Scanner;		/////////by PRASANNA ACHARYA :)//////////

public class lab4 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		Random Rand=new Random();
		Random Rand1=new Random();
		Random rand3=new Random();
		BigInteger p,q,n,z,d,e;
		int j=0;

	//step1:- reading p and q
		p=BigInteger.probablePrime(32,Rand);
		System.out.println("the RANDOM first prime number is:  "+p);
		q=BigInteger.probablePrime(32,Rand1);
		System.out.println("\nthe RANDOM second prime number is:  "+q);
	//step 2:- find n and z
		n=p.multiply(q);
		System.out.println("\nvalue of n is:  "+n);
		z=((p.subtract(new BigInteger("1"))).multiply((q.subtract(new BigInteger("1")))));
		
		System.out.println("\nvalue of z is:  "+z);
	//step 3 find e
		
		do {
			
            e = new BigInteger(2 * 32, new Random());
        } while ((e.compareTo(z) != 1)|| (e.gcd(z).compareTo(BigInteger.valueOf(1)) != 0));
       
	// Step 4: Calculate d such that e.d = 1 (mod ø(n)) */
        d = e.modInverse(z);
        System.out.println("\nthe value od d is:-  "+d);
	//step 5
			System.out.println("\npublic key is(n,e):-  ("+n+","+e+")");
			System.out.println("\nprivate key is(n,d):-  ("+n+","+d+")");
	//step 6 encryption
			System.out.println("\nEnter the data");
			String u=in.next();
			BigInteger DATA = new BigInteger(u);
	       BigInteger c=DATA.modPow(e,n);
	       System.out.println("\nthe encrypted message is:-  "+"<<<<<<<<  "+c+" >>>>>>>>");
	// step 7 :decryption
	       BigInteger ans=c.modPow(d,n);
	       System.out.println("\nthe reciver msg is:-  "+"<<<<<<<<  "+ans+" >>>>>>>>");
	        
	

}
}
