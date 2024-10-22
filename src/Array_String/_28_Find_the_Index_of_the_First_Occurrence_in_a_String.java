package Array_String;

public class _28_Find_the_Index_of_the_First_Occurrence_in_a_String {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        _28_Find_the_Index_of_the_First_Occurrence_in_a_String test = new _28_Find_the_Index_of_the_First_Occurrence_in_a_String();
        System.out.println(test.strStr("abcdefgh", "ads"));
    }
}
