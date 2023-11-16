import collections

"""
    Questions: 
"""


class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:

        p1 = len(s) - 1
        p2 = len(t) - 1

        if len(s) == 0:
            return True

        while (p2 >= 0):
            if s[p1] == t[p2]:
                p1 -= 1
                p2 -= 1
            else:
                p2 -= 1

        if p1 >= 0:
            return False
        else:
            return True


if __name__ == '__main__':
    # input examples
    Solution().fun_name()