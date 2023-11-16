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
    def isHappy(self, n: int) -> bool:

        happy = False
        if n == 1:
            happy = True
        else:
            sum_list = []
            sum = n

            while (True):
                if sum not in sum_list:
                    sum_list.append(sum)
                else:
                    break

                # get digits
                from functools import reduce
                digits = reduce(lambda acc, x: acc + [int(x)], str(sum), [])

                next_sum = 0
                for i in digits:
                    next_sum += i * i

                if next_sum == 1:
                    happy = True
                    break
                else:
                    sum = next_sum

        return happy


if __name__ == '__main__':
    pass