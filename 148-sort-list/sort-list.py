class Solution:
    def sortList(self, head):
        if not head or not head.next:
            return head

        # Find middle
        slow, fast = head, head.next

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        mid = slow.next
        slow.next = None

        # Sort both halves
        left = self.sortList(head)
        right = self.sortList(mid)

        # Merge
        dummy = ListNode(0)
        tail = dummy

        while left and right:
            if left.val < right.val:
                tail.next = left
                left = left.next
            else:
                tail.next = right
                right = right.next

            tail = tail.next

        tail.next = left if left else right

        return dummy.next