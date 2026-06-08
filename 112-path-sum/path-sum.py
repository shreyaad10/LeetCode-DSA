class Solution(object):
    def hasPathSum(self, root, targetSum):
        """
        :type root: Optional[TreeNode]
        :type targetSum: int
        :rtype: bool
        """
        
        if not root:
            return False
        
        # Leaf node
        if not root.left and not root.right:
            return targetSum == root.val
        
        targetSum -= root.val
        
        return (self.hasPathSum(root.left, targetSum) or
                self.hasPathSum(root.right, targetSum))