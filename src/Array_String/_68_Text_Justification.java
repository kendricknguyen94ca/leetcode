package Array_String;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of strings words and a width maxWidth,
 * format the text such that each line has exactly maxWidth characters
 * and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach;
 * that is, pack as many words as you can in each line.
 * Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible.
 * If the number of spaces on a line does not divide evenly between words,
 * the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text,
 * it should be left-justified,
 * and no extra space is inserted between words.
 *
 * Note:
 *
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 *
 * Example 1:
 *
 * Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 *
 * Example 2:
 *
 * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be",
 * because the last line must be left-justified instead of fully-justified.
 * Note that the second line is also left-justified because it contains only one word.
 *
 * Example 3:
 *
 * Input: words = ["Science","is","what","we","understand","well","enough","to",
 *          "explain","to","a","computer.","Art","is","everything","else","we","do"]
 *          , maxWidth = 20
 * Output:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 * */
public class _68_Text_Justification {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> currentWord = new ArrayList<String>();
        List<String> output = new ArrayList<String>();
        int num_of_letters = 0;
        for(String word:words) {
            if(word.length() + currentWord.size() + num_of_letters > maxWidth) {
                // Add space between word
                for (int i = 0; i < maxWidth - num_of_letters; i++) {
                    currentWord.set(i % (currentWord.size() - 1 > 0 ? currentWord.size() - 1 : 1), currentWord.get(i % (currentWord.size() - 1 > 0 ? currentWord.size() - 1 : 1)) + " ");
                }

                // Add currentWord to output
                StringBuffer sb = new StringBuffer();
                for (String s : currentWord) sb.append(s);
                output.add(sb.toString());
                // Reset currentWord
                currentWord.clear();
                num_of_letters = 0;
            };
            currentWord.add(word);
            num_of_letters += word.length();
        }

        // Add word to last line
        StringBuffer lastLine = new StringBuffer();
        for(int i=0; i<currentWord.size(); i++) {
            lastLine.append(currentWord.get(i));
            if (i != currentWord.size()-1) lastLine.append(" ");
        }
        // Add space to the end of lastLine so lastLine.length() = madWidth
        while (lastLine.length() < maxWidth) lastLine.append(" ");
        output.add(lastLine.toString());

        return output;
    }

    public static void main(String[] args) {
        String[] example1 = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] example2 = {"What","must","be","acknowledgment","shall","be"};
        String[] example3 = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        System.out.println(fullJustify(example1, 16));
        System.out.println(fullJustify(example2, 16));
        System.out.println(fullJustify(example3, 20));
    }
}
