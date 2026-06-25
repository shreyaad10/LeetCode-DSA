class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {

            int lineLength = words[i].length();
            int j = i + 1;

            // Find maximum words that fit in current line
            while (j < words.length &&
                   lineLength + 1 + words[j].length() <= maxWidth) {

                lineLength += 1 + words[j].length();
                j++;
            }

            int gaps = j - i - 1;
            StringBuilder line = new StringBuilder();

            // Last line or single word -> Left Justify
            if (j == words.length || gaps == 0) {

                for (int k = i; k < j; k++) {
                    line.append(words[k]);

                    if (k != j - 1)
                        line.append(' ');
                }

                while (line.length() < maxWidth)
                    line.append(' ');
            }

            // Fully Justify
            else {

                int totalChars = 0;

                for (int k = i; k < j; k++)
                    totalChars += words[k].length();

                int totalSpaces = maxWidth - totalChars;

                int evenSpaces = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;

                for (int k = i; k < j; k++) {

                    line.append(words[k]);

                    if (k != j - 1) {

                        for (int s = 0; s < evenSpaces; s++)
                            line.append(' ');

                        if (extraSpaces > 0) {
                            line.append(' ');
                            extraSpaces--;
                        }
                    }
                }
            }

            result.add(line.toString());
            i = j;
        }

        return result;
    }
}