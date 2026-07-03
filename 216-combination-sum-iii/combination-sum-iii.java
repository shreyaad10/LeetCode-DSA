class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(1, k, n, new ArrayList<>());
        return result;
    }

    private void backtrack(int start, int k, int target, List<Integer> curr) {

        if (target == 0 && curr.size() == k) {
            result.add(new ArrayList<>(curr));
            return;
        }

        if (target < 0 || curr.size() == k)
            return;

        for (int i = start; i <= 9; i++) {
            curr.add(i);
            backtrack(i + 1, k, target - i, curr);
            curr.remove(curr.size() - 1);
        }
    }
}