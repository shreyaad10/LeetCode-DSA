class Solution {

    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        int size = 2 * m;

        // Base vector for length = 2
        long[] state = new long[size];

        for (int y = 0; y < m; y++) {
            state[y] = y;                 // U[y]
            state[m + y] = m - 1 - y;    // D[y]
        }

        if (n == 2) {
            long ans = 0;
            for (long v : state) ans = (ans + v) % MOD;
            return (int) ans;
        }

        long[][] T = new long[size][size];

        // U[y] <- D[x], x < y
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < y; x++) {
                T[y][m + x] = 1;
            }
        }

        // D[y] <- U[x], x > y
        for (int y = 0; y < m; y++) {
            for (int x = y + 1; x < m; x++) {
                T[m + y][x] = 1;
            }
        }

        long[][] P = matrixPower(T, n - 2);

        long[] result = multiply(P, state);

        long ans = 0;
        for (long v : result) {
            ans = (ans + v) % MOD;
        }

        return (int) ans;
    }

    private long[][] matrixPower(long[][] mat, long exp) {
        int n = mat.length;

        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = multiply(res, mat);
            }

            mat = multiply(mat, mat);
            exp >>= 1;
        }

        return res;
    }

    private long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;

        long[][] C = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {

                if (A[i][k] == 0) continue;

                long a = A[i][k];

                for (int j = 0; j < n; j++) {

                    if (B[k][j] == 0) continue;

                    C[i][j] = (C[i][j] + a * B[k][j]) % MOD;
                }
            }
        }

        return C;
    }

    private long[] multiply(long[][] A, long[] v) {
        int n = A.length;

        long[] res = new long[n];

        for (int i = 0; i < n; i++) {

            long sum = 0;

            for (int j = 0; j < n; j++) {
                sum = (sum + A[i][j] * v[j]) % MOD;
            }

            res[i] = sum;
        }

        return res;
    }
}