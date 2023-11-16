import collections

"""
    Questions: 
"""


class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        idx1 = 0
        idx2 = 0

        range_list = []

        if nums == []:
            return range_list

        for i in range(1, len(nums)):
            if nums[i] - nums[i - 1] == 1:
                idx2 = i
            else:
                if idx1 == idx2:
                    range_list.append(f'{nums[idx1]}')
                else:
                    range_list.append(f'{nums[idx1]}->{nums[idx2]}')
                idx1 = i
                idx2 = i

        if idx1 == idx2:
            range_list.append(f'{nums[idx1]}')
        else:
            range_list.append(f'{nums[idx1]}->{nums[idx2]}')

        return range_list


if __name__ == '__main__':
    pass