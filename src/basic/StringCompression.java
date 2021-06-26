import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCompression {
//    Implement a method to perform basic string compression using the counts
//    of repeated characters. For example, the string "aabcccccaaa" would become a2blc5a3. If the
//    "compressed" string would not become smaller than the original string, your method should return
//    the original string. You can assume the string has only uppercase and lowercase letters (a - z).
    public static void main(String[] args) {
        StringCompression s = new StringCompression();
        System.out.println(s.compress("aabcccccaaa"));
        s.test();
    }

    @Test
    public void test() {
        StringCompression s = new StringCompression();
        assertEquals("a2", s.compress("aa"));
        assertEquals("a3", s.compress("aaa"));
        assertEquals("a", s.compress("a"));
        assertEquals("a3b", s.compress("aaab"));
        assertEquals("a3b2a3", s.compress("aaabbaaa"));
    }

    private String compress(String str) {
        char[] s = str.toCharArray();
        int count = 1; //count repeating chars, 1 character already inserted in res
        StringBuilder res = new StringBuilder();
        res.append(s[0]);
        for (int i =1; i< s.length; i++) {
            if (s[i] == s[i-1]) {
                count++;
            }
            else {
                res.append(count); //append the count
                res.append(s[i]); // append the new char
                count = 1; // acknowledge the new char
            }
        }
        if (count > 1) //if last char occurs only once instead of a1 write just a
            res.append(count);
        return res.toString();
    }


}
