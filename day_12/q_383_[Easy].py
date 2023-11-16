import collections

"""
    Questions: 
"""


class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        ransom_dict = collections.Counter(ransomNote)
        magazine_dict = collections.Counter(magazine)

        # print(ransom_dict)
        # print(magazine_dict)

        flag = True
        for k in ransom_dict.keys():
            if ransom_dict[k] > magazine_dict[k]:
                flag = False
                return flag

        return flag


if __name__ == '__main__':
    # input examples
    Solution().fun_name()