package basic;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PalindromePermutation {
    //Given a string, write a function to check if it is a permutation of a palindrome
    public static void main(String[] args) {
        PalindromePermutation p = new PalindromePermutation();
        System.out.println(p.check("Tact Coa"));
        System.out.println(p.check_adv("Tact Coa"));
        p.test();
    }

    @Test
    public void test() {
        PalindromePermutation s = new PalindromePermutation();
        assertTrue(s.check_adv("act cat"));
        assertTrue(s.check_adv("act atac"));
        assertTrue(s.check_adv("acto tac"));
        assertTrue(s.check_adv("a"));
        assertTrue(s.check_adv("a"));
    }

    private boolean check(String s) {
        s = s.replaceAll(" ", "").toLowerCase();
        char[] c = s.toCharArray();
        if (c.length == 0 || c.length == 1)
            return true;
        boolean[] arr = new boolean[256]; //initialized with false
        for (char i : c) {
            arr[i] = !arr[i]; //stores true if exists already otherwise false
        }
        int true_count = 0;
        for (boolean b : arr) {
            if (b)
                true_count++;
            if (true_count > 1)
                return false;
        }
        return true;
    }

    private boolean check_adv(String s) {
        //using a 32bit integer instead of an array
        s = s.replaceAll(" ", "").toLowerCase();
        int checker = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - 'a';
            val = 1 << val;
            if ((checker & val) == 0) //this means the bit was not already set as no bit matched
                checker |= val; //set the bit
            else
                checker &= ~val; //here the bit is already set, so we are unsetting it
        }
        // to check if an integer contains exactly one bit set to 1 and rest 0:
        // do AND operation on that integer with integer -1. This will set the the leftmost bit with 1 to 0. If there was only one 1, that means it is all 0s now.
        return checker == 0 || (checker & (checker - 1)) == 0; //even frequency of all char or odd frequency of only 1 char
    }
}
