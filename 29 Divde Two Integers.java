/*Solution: Bit manipulation
* Time: O(logn)
* Space: O(1)
*/
class Solution {
    private static int HALF_INT_MIN = -1073741824;

    public int divide(int dividend, int divisor) {

        // Special case: overflow.
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        /* We need to convert both numbers to negatives.
        * Also, we count the number of negatives signs. */
        int negatives = 2;
        if (dividend > 0) {
            negatives--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negatives--;
            divisor = -divisor;
        }

        /* In the first loop, we simply find the largest double of divisor
        * that fits into the dividend.
        * The >= is because we're working in negatives. In essence, that
        * piece of code is checking that we're still nearer to 0 than we
        * are to INT_MIN. */
        int highestDouble = divisor;
        int highestPowerOfTwo = -1;
        while (highestDouble >= HALF_INT_MIN && dividend <= highestDouble + highestDouble) {
            highestPowerOfTwo += highestPowerOfTwo;
            highestDouble += highestDouble;
        }

        /* In the second loop, we work out which powers of two fit in, by
        * halving highestDouble and highestPowerOfTwo repeatedly.
        * We can do this using bit shifting so that we don't break the
        * rules of the question :-) */
        int quotient = 0;
        while (dividend <= divisor) {
            if (dividend <= highestDouble) {
                quotient += highestPowerOfTwo;
                dividend -= highestDouble;
            }
            /* We know that these are always even, so no need to worry about the
            * annoying "bit-shift-odd-negative-number" case. */
            highestPowerOfTwo >>= 1;
            highestDouble >>= 1;
        }

        /* If there was originally one negative sign, then
        * the quotient remains negative. Otherwise, switch
        * it to positive. */
        if (negatives != 1) {
            return -quotient;
        }
        return quotient;
    }
}