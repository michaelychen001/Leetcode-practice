
"""
    Given a string S, we can split S into 2 strings: S1 and S2. Return the number of ways S can be split such that the number of unique characters between S1 and S2 are the same.

    Example 1:
        Input: "aaaa"
        Output: 3
        Explanation: we can get a - aaa, aa - aa, aaa- a

    Example 2:
        Input: "bac"
        Output: 0

    Example 3:
        Input: "ababa"
        Output: 2
        Explanation: ab - aba, aba - ba

    (** Ref: 1525. Number of Good Ways to Split a String.
    https://leetcode.com/problems/number-of-good-ways-to-split-a-string/)
"""

def split_sting_ways(s):
    cnt = 0
    for i in range(1, len(s)):
        s1_unique = set(s[:i])
        s2_unique = set(s[i:])
        if s1_unique == s2_unique:
            cnt += 1
    return cnt

if __name__ == '__main__':
    s1 = 'aaaa'
    print(split_sting_ways(s1))

    s1 = 'abc'
    print(split_sting_ways(s1))

    s1 = 'ababa'
    print(split_sting_ways(s1))