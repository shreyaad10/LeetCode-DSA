class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        
        rows = set()
        cols = set()
        boxes = set()
        
        for r in range(9):
            for c in range(9):
                
                val = board[r][c]
                
                if val == ".":
                    continue
                
                if (r, val) in rows:
                    return False
                
                if (c, val) in cols:
                    return False
                
                box = (r // 3, c // 3, val)
                
                if box in boxes:
                    return False
                
                rows.add((r, val))
                cols.add((c, val))
                boxes.add(box)
        
        return True