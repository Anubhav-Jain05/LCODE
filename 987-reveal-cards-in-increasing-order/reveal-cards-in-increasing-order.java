class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
         Arrays.sort(deck);
        int n = deck.length;
        Deque<Integer> index = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            index.offer(i);
        }
        
        int[] result = new int[n];
        for (int card : deck) {
            result[index.pollFirst()] = card;
            if (!index.isEmpty()) {
                index.offer(index.pollFirst());
            }
        }
        
        return result;
    }
}