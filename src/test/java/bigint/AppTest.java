package bigint;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.stream.IntStream;

class AppTest {
    public static final BigInteger BIIIG = BigInteger.TWO.pow(309);
    public static final BigInteger BIIIG2 = new BigInteger("3");
    public static final double LOG2 = Math.log(2);

    @Test public void testFlux() {
        IntStream.range(1, 30).mapToObj(BigInteger::valueOf).map(this::solve).forEach(System.out::println);
        System.out.println("ok, the answer is " + solve(BIIIG));

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