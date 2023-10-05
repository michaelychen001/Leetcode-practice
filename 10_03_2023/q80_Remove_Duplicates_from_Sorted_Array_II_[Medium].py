import collections

"""
    Questions (Medium):
        Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that 
        each unique element appears at most twice. The relative order of the elements should be kept the same.

        Since it is impossible to change the length of the array in some languages, you must instead have the 
        result be placed in the first part of the array nums. More formally, if there are k elements after 
        removing the duplicates, then the first k elements of nums should hold the final result. It does not 
        matter what you leave beyond the first k elements.

        Return k after placing the final result in the first k slots of nums.

        Do not allocate extra space for another array. You must do this by modifying the input array in-place 
        with O(1) extra memory.
        
    Examples:
        Example 1:
            Input: nums = [1,1,1,2,2,3]
            Output: 5, nums = [1,1,2,2,3,_]
            Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
            It does not matter what you leave beyond the returned k (hence they are underscores).

        Example 2:
            Input: nums = [0,0,1,1,1,1,2,3,3]
            Output: 7, nums = [0,0,1,1,2,3,3,_,_]
            Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
            It does not matter what you leave beyond the returned k (hence they are underscores).
            
    (Ref: 
        https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150
    )
"""

class Solution:
    def remove_duplicates(self, nums: list[int]) -> int:
        """
            Time & space complexity analysis.
        """
        print(nums)

        # Initialize the counter and the array index.
        i, count = 1, 1

        # Start from the second element of the array and process elements one by one.
        while i < len(nums):

            # If the current element is a duplicate, increment the count.
            if nums[i] == nums[i - 1]:
                count += 1

                # If the count is more than 2, this is an unwanted duplicate element and hence we remove it from the array.
                if count > 2:
                    print(f'Pop up {i} - {nums[i]}')
                    nums.pop(i)
                    print(nums)

                    # Note that we have to decrement the array index value
                    #  to keep it consistent with the size of the array.
                    i -= 1
            else:
                # Reset the count since we encountered a different element
                # than the previous one
                count = 1

            # Move on to the next element in the array
            i += 1

        return len(nums)


if __name__ == '__main__':
    # input examples
    # nums = [1, 1, 1, 2, 2, 3]
    nums = [0,0,1,1,1,1,2,3,3]
    print(Solution().remove_duplicates(nums))