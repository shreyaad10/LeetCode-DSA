class Solution(object):
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        
        dummy = ListNode(0)
        dummy.next = head
        
        prev = dummy
        
        while prev.next and prev.next.next:
            
            first = prev.next
            second = prev.next.next
            
            # Swap
            first.next = second.next
            second.next = first
            prev.next = second
            
            # Move to next pair
            prev = first
        
        return dummy.next