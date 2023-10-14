import collections

"""
    Questions: 
"""

class RandomizedSet:

    def __init__(self):
        self.random_nums = []

    def insert(self, val: int) -> bool:
        if (val not in self.random_nums):
            self.random_nums.append(val)
            return True
        else:
            return False

    def remove(self, val: int) -> bool:
        if (val in self.random_nums):
            self.random_nums.remove(val)
            return True
        else:
            return False

    def getRandom(self) -> int:
        import numpy as np
        return np.random.choice(self.random_nums)


if __name__ == '__main__':
    # input examples
    # Your RandomizedSet object will be instantiated and called as such:
    # obj = RandomizedSet()
    # param_1 = obj.insert(val)
    # param_2 = obj.remove(val)
    # param_3 = obj.getRandom()
    pass