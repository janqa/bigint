package bigint;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class AppTest {
    public static final BigInteger BIIIG = BigInteger.TEN.pow(309);
    public static final BigInteger BIIIG2 = new BigInteger("33");
    public static final double LOG2 = Math.log(2);

    @Test public void testFlux() {
        System.out.println("ok, the answer is " + solve(BIIIG2));

    }

    public int solve(BigInteger x) {
        Assertions.assertTrue(asd(BigInteger.valueOf(33)) < 0);
        int i = 0;
        return iterate(x, i);
    }

    public static int iterate(BigInteger x, int i) {
        if (x.equals(BigInteger.ONE)) {
            return i;
        } else {
            if (even(x)) {
                x = x.divide(BigInteger.TWO);
            } else if (asd(x) > 0) {
                x = x.add(BigInteger.ONE);
            } else {
                x = x.subtract(BigInteger.ONE);
            }
            System.out.println(x);
            return iterate(x, ++i);
        }
    }

    private static int asd(BigInteger x) {
        BigInteger m = BigInteger.TWO.pow((int) log2(x));
        return x.subtract(m).compareTo(m.multiply(BigInteger.TWO).subtract(x));
    }

    private static double log2(BigInteger x) {
        return Math.log(x.doubleValue()) / LOG2;
    }

    public static boolean even(BigInteger x) {
        return x.mod(BigInteger.TWO).equals(BigInteger.ZERO);
    }
}