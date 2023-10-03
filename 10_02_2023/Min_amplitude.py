
def find_min_amplitude(input, k):

    MIN_AMP = -1

    # 1. sort the input.
    input_sort = sorted(input)

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
    for i, j in zip(range(1, len(input) - k + 1), range(last+1, len(input)-1)):
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