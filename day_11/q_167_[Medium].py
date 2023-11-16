import collections

"""
    Questions: 
    Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 < numbers.length.

    Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
    
    The tests are generated such that there is exactly one solution. You may not use the same element twice.
    
    Your solution must use only constant extra space.
"""


class Solution:

    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        idx1, idx2 = -1, -1;

        for i in range(len(numbers)):
            if i == 0:  # the first round
                for j in range(i + 1, len(numbers)):
                    if j == i + 1:  # the first round
                        if (numbers[i] + numbers[j] == target):
                            idx1 = i
                            idx2 = j
                    else:  # other rounds
                        if numbers[j] != numbers[j - 1]:
                            if (numbers[i] + numbers[j] == target):
                                idx1 = i
                                idx2 = j
            else:  # other rounds
                if numbers[i] != numbers[i - 1]:
                    for j in range(i + 1, len(numbers)):
                        if j == i + 1:  # the first round
                            if (numbers[i] + numbers[j] == target):
                                idx1 = i
                                idx2 = j
                        else:  # other rounds
                            if numbers[j] != numbers[j - 1]:
                                if (numbers[i] + numbers[j] == target):
                                    idx1 = i
                                    idx2 = j

        return [idx1 + 1, idx2 + 1]

if __name__ == '__main__':
    pass