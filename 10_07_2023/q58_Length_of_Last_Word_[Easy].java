/**
    Questions:
        Given a string s consisting of words and spaces, return the length of the last word in the string.

        A word is a maximal substring consisting of non-space characters only.

    Example 1:
        Input: s = "Hello World"
        Output: 5
        Explanation: The last word is "World" with length 5.

    Example 2:
        Input: s = "   fly me   to   the moon  "
        Output: 4
        Explanation: The last word is "moon" with length 4.

    Example 3:
        Input: s = "luffy is still joyboy"
        Output: 6
        Explanation: The last word is "joyboy" with length 6.
*/

class Solution {
    public int lengthOfLastWord(String s) {

        /**
            Time-complexity: O(n)
            Space-complexity: O(n)
        */

        List<Character> savedWord = new ArrayList<Character>();

        int len = s.length();
        boolean spaceFlag = false;

        for (int i=0; i < len; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                spaceFlag = true;
            } else {
                if (spaceFlag == true) {
                    savedWord = new ArrayList<Character>();
                    System.out.println("clear the list");
                    spaceFlag = false;
                }
                savedWord.add(c);
                System.out.println("saved " + String.valueOf(c) + " to list");
            }
        }


        System.out.println(savedWord);

        return savedWord.size();
    }
}