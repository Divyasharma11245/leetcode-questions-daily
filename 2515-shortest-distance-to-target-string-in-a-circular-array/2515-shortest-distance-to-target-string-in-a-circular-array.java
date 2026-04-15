class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n=words.length;

        int left = startIndex;
        int right = startIndex;

        for (int step = 0; step < n; step++) {
            if (words[left].equals(target) || words[right].equals(target)) {
                return step;
            }

            left = (left - 1 + n) % n;
            right = (right + 1) % n;
        }

        return -1;
    }
}