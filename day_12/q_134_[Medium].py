import collections

"""
    Questions: 
"""


class Solution1:

    def isSolution(self, init_idx, gas, cost):
        rt = False

        # start from an random index (idx)
        # set the tank to gas[idx]
        tank = gas[init_idx]

        # for idx: init_idx+1 -> max -> 0 -> init_idx:
        visit_list = []

        for t in range(init_idx + 1, len(gas)):
            visit_list.append(t)
        for t in range(init_idx + 1):
            visit_list.append(t)

        print(init_idx, ' --- ', visit_list)

        print(f'Visited {init_idx} --> tank is {tank}')
        for idx in visit_list:
            if idx == 0:
                tank -= cost[-1]
            else:
                tank -= cost[idx - 1]
            if tank == 0 and idx == init_idx:
                rt = True
                print(f'Visited {idx} --> tank is {tank}')
                return rt
            elif tank < 0:
                return rt
            else:
                tank += gas[idx]
                print(f'Visited {idx} --> tank is {tank}')

        if tank > 0:
            rt = True

        return rt

    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:

        """
            gas =  [1,2,3,4,5]
            cost = [3,4,5,1,2]
        """
        for init_idx in range(len(gas)):
            rt = self.isSolution(init_idx, gas, cost)
            print(f'{init_idx} -- {rt}')
            if rt:
                return init_idx

        return -1

class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        n = len(gas)
        total_gas, total_cost, start, tank = 0, 0, 0, 0

        for i in range(n):
            total_gas += gas[i]
            total_cost += cost[i]
            tank += gas[i] - cost[i]

            if tank < 0:
                start = i + 1
                tank = 0

        return start if total_gas >= total_cost else -1


if __name__ == '__main__':
    # input examples
    Solution().fun_name()