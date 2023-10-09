
/**
    Questions:
        Write a function to find the longest common prefix string amongst an array of strings.
        If there is no common prefix, return an empty string "".

    Example 1:
        Input: strs = ["flower","flow","flight"]
        Output: "fl"

    Example 2:
        Input: strs = ["dog","racecar","car"]
        Output: ""
        Explanation: There is no common prefix among the input strings.

*/

class Solution {
    public String longestCommonPrefix(String[] strs) {

        int StrsLen = strs.length;

        if (StrsLen == 0){
            return "";
        }

        if (StrsLen == 1){
            return strs[0];
        }

        List<Character> commonPrefix = new ArrayList<Character>();
        int idx = 0;
        boolean compareFlag = true;

        while (compareFlag) {
            if (idx < strs[0].length()) {
                char c = strs[0].charAt(idx);
                for (int j=1; j<StrsLen; j++) {
                    if ((idx > strs[j].length()-1) || (strs[j].charAt(idx) != c)) {
                        compareFlag = false;
                        break;
                    }
                }
                if (compareFlag) {
                    commonPrefix.add(c);
                }
            } else {
                compareFlag = false;
            }

            idx++;
        }

        // System.out.println(commonPrefix);

        StringBuffer sb = new StringBuffer();
        for (char c: commonPrefix) {
            sb.append(c);
        }

        String rt = sb.toString();

        return rt;
    }
}