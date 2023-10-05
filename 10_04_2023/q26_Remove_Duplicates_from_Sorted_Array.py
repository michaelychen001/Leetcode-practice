import collections

"""
    Questions: 
"""

class Solution:
    def remove_duplicates(self, nums: list) -> int:
        """
            Time & space complexity analysis.
        """
        print(nums)

        i = 1
        while(i < len(nums)):

            if nums[i] == nums[i-1]:
                print(f'Pop up {i} - {nums[i]}')
                nums.pop(i)
                print(nums)
                i -= 1

            i += 1

        return len(nums)


if __name__ == '__main__':
    # input examples
    # nums = [1, 1, 2]
    nums = [0,0,1,1,1,2,2,3,3,4]
    print(Solution().remove_duplicates(nums))