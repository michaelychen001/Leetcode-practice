

"""
    Question:
        Find the minimum amplitude after changing up to 3 elements;
        Amplitude is the range of the array (basically difference between the largest and smallest element).

    Example 1:
        Input: [-1, 3, -1, 8, 5 4]
        Output: 2
        Explanation: we can change -1, -1, 8 to 3, 4 or 5

    Example 2:
        Input: [10, 10, 3, 4, 10]
        Output: 0
        Explanation: change 3 and 4 to 10

    (** Ref: 1509. Minimum Difference Between Largest and Smallest Value in Three Moves. [Medium]
    https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/)
"""
def find_min_amplitude(input, k):
    """
        build counters: O(n*logn) or n(n^2)
        update retValue: O(n)
        Total: O(n*logn) or n(n^2), depending on the sorting algorithm utilized.
    """
    MIN_AMP = -1

    # 1. sort the input.
    input_sort = sorted(input) # -> O(n*logn) or n(n^2)

    # 2. check if k is less than the array's length.
    if len(input) < k:
        return MIN_AMP

    # 3. find the minimum amplitude.
    last = len(input)-k-1
    MIN_AMP = input_sort[last] - input_sort[0]

    """ Solution 1"""
    # for i in range(1, len(input) - k + 1):
    #     if input_sort[j + 1] - input_sort[i] < MIN_AMP:
    #         MIN_AMP = input_sort[j + 1] - input_sort[i]
    #     j += 1

    """ Solution 2"""
    for i, j in zip(range(1, len(input) - k + 1), range(last+1, len(input)-1)):   # O(n)
        if input_sort[j] - input_sort[i] < MIN_AMP:
            MIN_AMP = input_sort[j] - input_sort[i]

    return MIN_AMP

if __name__ == '__main__':
    arr_1 = [-1, 3, -1, 8, 5, 4]
    rt = find_min_amplitude(arr_1, 3)
    print(rt)

    arr_2 = [10, 10, 3, 4, 10]
    rt = find_min_amplitude(arr_2, 3)
    print(rt)