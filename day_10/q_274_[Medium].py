import collections

"""
    Questions: 
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        """
            H-index:
                1. >= h papers
                2. each has been cited >= h
        """

        h_value = 0

        # the range of h is [0, len(citations)]
        for h in range(len(citations) + 1):
            # if all e in citations > h, then set h_flag to true

            num = 0
            for i in range(len(citations)):
                if citations[i] >= h:
                    num += 1

            h_flag = num >= h
            if h_flag:
                h_value = h

            print(h, h_flag, h_value)

        print(h_value)

        return h_value


if __name__ == '__main__':
    pass