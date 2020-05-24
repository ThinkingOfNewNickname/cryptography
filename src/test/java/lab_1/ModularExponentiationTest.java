package lab_1;

import junit.framework.TestCase;

import java.math.BigInteger;
import java.security.SecureRandom;

public class ModularExponentiationTest extends TestCase {
    private final SecureRandom random = new SecureRandom();
    private final int iteration = 100;

    public void testPowerModule() {
        final int bitLength = 512;

        for (int i = 0; i < iteration; ++i) {
            final BigInteger number = BigInteger.probablePrime(bitLength, random);
            final BigInteger exponent = BigInteger.probablePrime(bitLength, random);
            final BigInteger module = BigInteger.probablePrime(bitLength, random);

            final BigInteger expected = number.modPow(exponent, module);
            final BigInteger actual = ModularExponentiation.powerModule(number, exponent, module);

            assertEquals(expected, actual);
        }
    }
}