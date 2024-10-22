package Array_String;

import java.util.ArrayList;
import java.util.List;

public class _6_Zigzag_Conversion {
    public String convert(String s, int numRows) {
        List<Character>[] rows = new ArrayList[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i]= new ArrayList<>();
        }

        int idx=0, d=1;
        for (char c:s.toCharArray()) {
            rows[idx].add(c);
            if (idx==0) d=1;
            else if (idx==numRows-1) d=-1;
            idx +=d;
        }

        StringBuffer sb = new StringBuffer();
        for(List<Character> row:rows) {
            for (char c:row) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

}
