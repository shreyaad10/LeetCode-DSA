class Solution:
    def sumNumbers(self, root):

        def dfs(node, current):
            if not node:
                return 0

            current = current * 10 + node.val

            if not node.left and not node.right:
                return current

            left_sum = dfs(node.left, current)
            right_sum = dfs(node.right, current)

            return left_sum + right_sum

        return dfs(root, 0)