import collections

"""
    Questions: 
"""

class Solution1:
    def reverseWords(self, s: str) -> str:
        s_split = s.split(' ')
        s_split = [s.strip() for s in s_split]

        s_split_new = []
        for tmp in s_split:
            if tmp != '':
                s_split_new.append(tmp)

        print(s_split_new)

        s_out = []
        for i in range(len(s_split_new), 0, -1):
            s_out.append(s_split_new[i-1])

        return ' '.join(s_out)

class Solution2:
    def reverseWords(self, s: str) -> str:
        s = s.split()
        return " ".join(s[::-1])


if __name__ == '__main__':
    pass