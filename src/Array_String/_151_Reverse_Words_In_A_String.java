package Array_String;

public class _151_Reverse_Words_In_A_String {
    public String reverseWords(String s) {
        StringBuffer sb = new StringBuffer();
        String[] sArray = s.trim().replaceAll(" +", " ").split(" ");
        for(int i=sArray.length-1; i>=0; i--) {
            sb.append(sArray[i].trim());
            if(i != 0) sb.append(" ");
        }
        return sb.toString().trim();
    }
}
