package basic;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringRotation {
//    Assumeyou have a method isSubstring which checks if one word is a substring
//    of another. Given two strings, sl and s2, write code to check if s2 is a rotation of sl using only one
//    call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat").
    public static void main(String[] args) {
        StringRotation s = new StringRotation();
        System.out.println(s.string_rotate("waterbottle", "erbottlewat"));
        s.test();

    }

    @Test
    public void test() {
        StringRotation s = new StringRotation();
        assertTrue(s.string_rotate("", ""));
        assertTrue(s.string_rotate("hello", "hello"));
        assertTrue(s.string_rotate("hello", "llohe"));
        assertFalse(s.string_rotate("hello", "llo"));
        assertFalse(s.string_rotate("hello", "world"));
        assertFalse(s.string_rotate("hello", "oehll"));

    }

    private boolean string_rotate(String s1, String s2) {
        // s2 will always be a substring of s1s1. refer book for explanation.
        int len = s1.length();
        /* Check that sl and s2 are equal length and not empty*/
        if (len == s2.length()) {
            /* Concatenate sl and sl within new buffer */
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }
        return false;
    }

    private boolean isSubstring(String s1, String s2) {
        return s1.contains(s2);
    }
}
