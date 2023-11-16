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
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        p = head
        visited = []
        find_it = False
        if p == None:
            pass
        else:
            print(p.val)
            visited.append(p)
            while(p.next):
                p = p.next
                if p in visited:
                    find_it = True
                    break
                else:
                    visited.append(p)
                print(p.val)

        return find_it


if __name__ == '__main__':
    pass