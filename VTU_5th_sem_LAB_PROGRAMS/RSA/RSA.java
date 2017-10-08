import java.math.BigInteger;

import java.util.Random;
import java.util.Scanner;		/////////by PRASANNA ACHARYA :)//////////

public class RSA {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		Random Rand=new Random();
		Random Rand1=new Random();
		Random rand3=new Random();
		BigInteger p,q,n,z,d,e;
		int j=0;
	//step1:- reading p and q
		System.out.println("Enter value p and q");
		String t=in.next();
		String o=in.next();
		p= new BigInteger(t);
		System.out.println("the first prime number is:  "+p);
		q=new BigInteger(o);
		System.out.println("\nthe  second prime number is:  "+q);
	//step 2:- find n and z
		n=p.multiply(q);
		System.out.println("\nvalue of n is:  "+n);
		z=((p.subtract(new BigInteger("1"))).multiply((q.subtract(new BigInteger("1")))));
		System.out.println("\nvalue of z is:  "+z);
	//step 3 find e
		do {
			//////////////------(v)/////-----
            e = new BigInteger(2*10, new Random());
        } while ((e.compareTo(z) != 1)||(e.gcd(z).compareTo(BigInteger.valueOf(1)) != 0));
    // Step 4: Calculate d such that e.d = 1 (mod �(n)) */
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
