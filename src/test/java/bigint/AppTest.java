package bigint;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class AppTest {
    public static final BigInteger BIIIG = BigInteger.TEN.pow(309);
    public static final BigInteger BIIIG2 = new BigInteger("15");

    @Test public void testFlux() {
        System.out.println("ok, the answer is " + solve(BIIIG2));

    }

    public int solve(BigInteger x) {
        int i = 0;
        return iterate(x, i);
    }

    public static int iterate(BigInteger x, int i) {
        if (even(x)) {
            x = x.divide(BigInteger.TWO);
        } else if (asd(x) > 0) {
            x = x.add(BigInteger.ONE);
        } else {
            x = x.subtract(BigInteger.ONE);
        }
        System.out.println(x);

        if (!x.equals(BigInteger.ONE)) {
            return iterate(x, ++i);
        } else
            return i;
    }

    private static int asd(BigInteger x) {
        BigInteger m = BigInteger.TWO.pow((int) Math.log(x.doubleValue()));
        return x.subtract(m).compareTo(m.multiply(BigInteger.TWO).subtract(x));
    }

    public static boolean even(BigInteger x) {
        return x.mod(BigInteger.TWO).equals(BigInteger.ZERO);
    }
}