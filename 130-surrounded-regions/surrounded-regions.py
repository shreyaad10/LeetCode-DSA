class Solution:
    def solve(self, board):
        if not board:
            return

        rows, cols = len(board), len(board[0])

        def dfs(r, c):
            if (
                r < 0 or r >= rows or
                c < 0 or c >= cols or
                board[r][c] != 'O'
            ):
                return

            board[r][c] = 'T'

            dfs(r + 1, c)
            dfs(r - 1, c)
            dfs(r, c + 1)
            dfs(r, c - 1)

        # Left and Right borders
        for r in range(rows):
            dfs(r, 0)
            dfs(r, cols - 1)

        # Top and Bottom borders
        for c in range(cols):
            dfs(0, c)
            dfs(rows - 1, c)

        # Final conversion
        for r in range(rows):
            for c in range(cols):

                if board[r][c] == 'O':
                    board[r][c] = 'X'

                elif board[r][c] == 'T':
                    board[r][c] = 'O'