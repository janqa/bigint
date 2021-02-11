package bigint;

import java.math.BigInteger;

public class Solution implements ISolution {
    public static final double LOG2 = Math.log(2);

    public int solution(String s) {
        int i = 0;
        return iterate(new BigInteger(s), i);
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
