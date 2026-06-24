class Solution {
    public boolean isMatch(String s, String p) {

        int i = 0; // pointer for s
        int j = 0; // pointer for p

        int star = -1;
        int match = 0;

        while (i < s.length()) {

            // Characters match or '?'
            if (j < p.length() &&
                (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {

                i++;
                j++;
            }

            // Found '*'
            else if (j < p.length() && p.charAt(j) == '*') {

                star = j;
                match = i;

                j++;
            }

            // Mismatch but previous '*' exists
            else if (star != -1) {

                j = star + 1;
                match++;
                i = match;
            }

            // No '*' to help
            else {
                return false;
            }
        }

        // Remaining pattern must be all '*'
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }

        return j == p.length();
    }
}