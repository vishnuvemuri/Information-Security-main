import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class RSA {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter a prime number: ");
        BigInteger p = sc.nextBigInteger();
        System.out.print("Enter another prime number: ");
        BigInteger q = sc.nextBigInteger();

        BigInteger n = p.multiply(q);
        BigInteger fiofn = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger e = generateE(fiofn);
        BigInteger d = e.modInverse(fiofn);

        System.out.println("Encryption keys are: (" + e + ", " + n + ")");
        System.out.println("Decryption keys are: (" + d + ", " + n + ")");
    }

    public static BigInteger generateE(BigInteger fiofn) {
        int y, intGCD;
        BigInteger e;
        BigInteger gcd;
        Random x = new Random();

        do {
            y = x.nextInt(fiofn.intValue() - 2) + 2; // generate a random number between 2 and fiofn-1
            e = BigInteger.valueOf(y);
            gcd = fiofn.gcd(e);
            intGCD = gcd.intValue();
        } while (intGCD != 1);

        return e;
    }
}
