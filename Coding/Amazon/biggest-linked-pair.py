'''
Give you a singly linked list. you can sum up the value of 1st and last node, 2nd and second from last node ... etc. 
Then return the max sum of this kind of pair. Edit: O(1) space complexity is required so you cannot convert it to an array
'''


class ListNode:
    def __init__(self, x=0):
        self.val = x
        self.next = None


def bigestLinkedPair(head):
    dummy = ListNode()
    dummy.next = head
    slow, fast = dummy, dummy
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next
    secondHead = slow.next
    slow.next = None
    pre, cur = None, secondHead
    while cur:
        cur.next, pre, cur = pre, cur, cur.next
    maxSum = -inf
    while pre:
        maxSum = max(maxSum, pre.val+head.val)
        pre = pre.next
        head = head.next
    return maxSum
