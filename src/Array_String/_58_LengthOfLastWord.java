package Array_String;

public class _58_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        return s.substring(s.lastIndexOf(" ")+1).length();
    }
}
