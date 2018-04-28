package leetcode.recursion;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama"is a palindrome.
 * "race a car"is not a palindrome.
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
public class Exercise26 {

    public static void main(String[] args) {
        String str = ".,";
        Exercise26 exe = new Exercise26();
        System.out.println(exe.isPalindrome(str));
    }

    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        for (int i = 0, j = s.length() - 1; i < j; ) {
            char charI = s.charAt(i);
            char charJ = s.charAt(j);
            if (!Character.isLetterOrDigit(charI)) {
                i++;
            } else if (!Character.isLetterOrDigit(charJ)) {
                j--;
            } else {
                if (Character.toLowerCase(charI) != Character.toLowerCase(charJ)) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }

}
