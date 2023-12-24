package com.piotrholda.algorithms;

public class ManachersAlgorothm {

    static String longestPalindrome(String s) {
        String str = transform(s);
        int length = (2 * s.length()) + 1;
        int[] p = new int[length];
        // The center of the farthest right palindrome found so far.
        int c = 0;
        // The farthest right boundary of a palindrome found so far.
        int r = 0;
        // Length of the longest palindrome found so far.
        int maxLength = 0;
        // Position of the center of the longest palindrome found so far.
        int maxCenter = 0;
        for (int i = 0; i < length; i++) {
            // The position of the element lying to the left of center at the same distance as the current i.
            int mirror = (2 * c) - i;
            /*
                If we are inside the last found palindrome (within it's boundaries), the value of p[i] can take the minimum of two values:
                the distance from current i to right boundary or the size of the palindrome lying on the mirror side of the last found center.
            */
            if (i < r) {
                p[i] = Math.min(r - i, p[mirror]);
            }
            // Check if we can increase size of the current palindrome
            int tempL = i - (1 + p[i]);
            int tempR = i + (1 + p[i]);
            while (tempL >= 0 && tempR < length && str.charAt(tempL) == str.charAt(tempR)) {
                p[i]++;
                tempL--;
                tempR++;
            }
            /*
                Check if the palindrome at i is expanding beyond the current right boundary of the palindrome at center c.
                 If it is, the new center is i and the new r is the right boundary of the palindrome at i.
             */
            if (i + p[i] > r) {
                c = i;
                r = i + p[i];

                if (p[i] > maxLength) {
                    maxLength = p[i];
                    maxCenter = i;
                }
            }
        }
        return extractSubstring(s, maxLength, maxCenter);
    }

    private static String transform(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append("#");
            sb.append(s.charAt(i));
        }
        sb.append("#");
        return sb.toString();
    }

    private static String extractSubstring(String s, int maxLength, int maxCenter) {
        int l = (maxCenter - maxLength) / 2;
        int r = l + maxLength;
        return s.substring(l, r);
    }
}
