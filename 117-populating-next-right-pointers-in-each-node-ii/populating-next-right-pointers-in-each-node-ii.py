class Solution:
    def connect(self, root):
        curr = root

        while curr:

            head = None
            prev = None

            while curr:

                if curr.left:
                    if prev:
                        prev.next = curr.left
                    else:
                        head = curr.left
                    prev = curr.left

                if curr.right:
                    if prev:
                        prev.next = curr.right
                    else:
                        head = curr.right
                    prev = curr.right

                curr = curr.next

            curr = head

        return root