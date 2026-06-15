class Solution(object):
    def partition(self, head, x):
        """
        :type head: Optional[ListNode]
        :type x: int
        :rtype: Optional[ListNode]
        """
        
        small_dummy = ListNode(0)
        large_dummy = ListNode(0)
        
        small = small_dummy
        large = large_dummy
        
        while head:
            
            if head.val < x:
                small.next = head
                small = small.next
            else:
                large.next = head
                large = large.next
            
            head = head.next
        
        large.next = None
        small.next = large_dummy.next
        
        return small_dummy.next