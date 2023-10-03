import collections

"""
    You are given a string s.
        A split is called good if you can split s into two non-empty strings sleft and sright where their concatenation is equal to s (i.e., sleft + sright = s) and the number of distinct letters in sleft and sright is the same.
        Return the number of good splits you can make in s.
        
    Example 1:
        Input: s = "aacaba"
        Output: 2
        Explanation: There are 5 ways to split "aacaba" and 2 of them are good. 
        ("a", "acaba") Left string and right string contains 1 and 3 different letters respectively.
        ("aa", "caba") Left string and right string contains 1 and 3 different letters respectively.
        ("aac", "aba") Left string and right string contains 2 and 2 different letters respectively (good split).
        ("aaca", "ba") Left string and right string contains 2 and 2 different letters respectively (good split).
        ("aacab", "a") Left string and right string contains 3 and 1 different letters respectively.
"""

class Solution:
    def numSplits(self, s: str) -> int:
        cnt = 0
        cnt_unique_left = 0
        cnt_unique_right = 0

        if len(s) >= 1 and len(s) <= 100000:

            left_counter = collections.Counter(s[:1])
            right_counter = collections.Counter(s[1:])
            # print(s[:1], s[1:])

            cnt_left = len(left_counter.keys())
            cnt_right = len(right_counter.keys())

            if cnt_left == cnt_right:
                cnt += 1
                # print('+1', left_counter, right_counter)

            for i in range(1, len(s)):
                e = s[i]  # the one will be added to left
                # print(e)

                if e not in left_counter.keys():
                    left_counter[e] = 1
                    cnt_left += 1

                # for right
                if right_counter[e] == 1:
                    del right_counter[e]
                    cnt_right -= 1
                else:
                    right_counter[e] -= 1

                # print('** ', left_counter, right_counter)

                if cnt_left == cnt_right:
                    cnt += 1

        return cnt

if __name__ == '__main__':
    s = "aacaba"
    print(Solution().numSplits(s))