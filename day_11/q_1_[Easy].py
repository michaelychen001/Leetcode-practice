import collections

"""
    Questions: 
"""

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:

        idx1, idx2 = -1, -1;

        for i in range(len(nums)):
            for j in range(i+1, len(nums)):
                if (nums[i] + nums[j] == target):
                    idx1 = i
                    idx2 = j

        return [idx1, idx2]



if __name__ == '__main__':
    pass