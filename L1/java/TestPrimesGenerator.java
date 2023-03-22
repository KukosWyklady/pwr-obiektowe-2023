public class TestPrimesGenerator
{
    private TestPrimesGenerator() throws InstantiationError
    {
        throw new InstantiationError("This is a static class!");
    }

    private static void testPrimesGeneratorException(final int n, final int [] primeIndexes)
    {
        try
        {
            final PrimesGenerator primesGenerator = new PrimesGenerator(n);
            for (final int index : primeIndexes)
            {
                final int prime = primesGenerator.getPrime(index);
            }

            assert false : "Exception should be raised";

        }
        catch (final IllegalArgumentException e)
        {

        }
    }

    private static void testPrimesGeneratorNormalCase(final int n, final int[] primeIndexes, final int[] expectedPrimes)
    {
        final PrimesGenerator primesGenerator = new PrimesGenerator(n);
        for (int i = 0; i < primeIndexes.length; ++i)
        {
            final int prime = primesGenerator.getPrime(primeIndexes[i]);
            assert prime == expectedPrimes[i] : "prime should be equals with expected prime";
        }
    }

    private static void testPrimesGeneratorPerformance(final int n, final int[] primeIndexes)
    {
        final long startTime = System.currentTimeMillis();

        final PrimesGenerator primesGenerator = new PrimesGenerator(n);
        for (int i = 0; i < primeIndexes.length; ++i)
        {
            final int prime = primesGenerator.getPrime(primeIndexes[i]);
        }

        final long stopTime = System.currentTimeMillis();
        System.out.println("primesGenerator(" + n + ") took: " + (stopTime - startTime) + "ms");
    }

    public static void testPrimesGenerator()
    {
        testPrimesGeneratorException(-100, new int[] {});
        testPrimesGeneratorException(-1, new int[] {});
        testPrimesGeneratorException(0, new int[] {});
        testPrimesGeneratorException(1, new int[] {});
        testPrimesGeneratorException(2, new int[] {0, -1, 1, 2, 100, -100});
        testPrimesGeneratorException(100, new int[] {0, -1, 1, 2, 100, -100});
        testPrimesGeneratorException(1000, new int[] {0, -1, 1, 2, 100, -100});

        testPrimesGeneratorNormalCase(2, new int[] {0}, new int[] {2});
        testPrimesGeneratorNormalCase(100, new int[] {0, 3, 7, 10}, new int[] {2, 7, 19, 31});

        testPrimesGeneratorPerformance(10 * 1000, new int[] {0, 100, 1000});
        testPrimesGeneratorPerformance(1 * 1000 * 1000, new int[] {0, 100, 1000});
        testPrimesGeneratorPerformance(1 * 1000 * 1000, new int[] {0, 100, 1000, 78497});
        testPrimesGeneratorPerformance(1 * 1000 * 1000 * 1000, new int[] {0, 100, 1000}); // java -Xmx16G
        testPrimesGeneratorPerformance(1 * 1000 * 1000 * 1000, new int[] {0, 100, 1000, 100000});
    }
}
