package basic;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OneAway {
//    There are three types of edits that can be performed on strings: insert a character,
//    remove a character, or replace a character. Given two strings, write a function to check if they are
//    one edit (or zero edits) away.
    public static void main(String[] args) {
        OneAway p = new OneAway();
        System.out.println(p.check1("paxye", "pamne"));
          p.test();
    }

    @Test
    public void test() {
        OneAway s = new OneAway();
        assertTrue(s.check1("", ""));
        assertTrue(s.check1("", "b"));
        assertTrue(s.check1("a", "b"));
        assertTrue(s.check1("pae", "pale"));
        assertTrue(s.check1("pales", "paes"));
        assertTrue(s.check1("pawe", "pave"));
        assertFalse(s.check1("paxye", "pamne"));
    }

    private boolean check(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        if (c1.length == 0 && c2.length == 0)
            return true;
        if (c1.length == 1 && c2.length == 0)
            return true;
        if (c1.length == 0 && c2.length == 1)
            return true;
        if (c1.length == 1 && c2.length == 1)
            return true;
        boolean[] arr = new boolean[256]; //initialized with false
        for (char i: c1)
            arr[i] = !arr[i]; //stores true if exists already otherwise false
        for (char i: c2)
            arr[i] = !arr[i];
        int true_count = 0;
        boolean pass_once = false;
        for (boolean b: arr) {
            if (b)
                true_count++;
            if (true_count > 1) {
                if (true_count == 2 && !pass_once)
                    if (Math.abs(c1.length - c2.length) == 0) {
                        pass_once = true;
                        true_count --;
                        continue;
                    }
                return false;
            }
        }
        return true;
    }

    private boolean check1 (String s1, String s2) {
        //both the strings can have max one char different with same length(update opr)
        // or 1 length difference (insert, delete opr)
        if (s1.length() - s2.length() ==1)
            return insert_or_delete(s1, s2);
        else if (s2.length() - s1.length() == 1)
            return insert_or_delete(s2, s1);
        else if (s2.length() == s1.length())
            return update(s1, s2);
        else return false;
    }

    private boolean insert_or_delete(String big, String small) {
           int index1 = 0, index2 = 0;
           while (index1 < big.length() && index2 < small.length()) {
               if (big.charAt(index1) != small.charAt(index2)) {
                   if(index1 != index2)
                       return false;
                   index1++;
               }
               else {
                   index1++;
                   index2++;
               }
           }
           return true;
    }

    private boolean update(String s1, String s2) {
        boolean diffOnce = false;
        for (int i=0;i<s1.length();i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (diffOnce)
                    return false;
                diffOnce = true;
            }
        }
        return true;
    }
}

