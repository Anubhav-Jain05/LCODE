class Solution {
    public int openLock(String[] deadends, String target) {
          Set<String> deadEnds = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        String start = "0000";
        
        if (deadEnds.contains(start)) return -1; // If start is in deadends, cannot proceed
        
        queue.offer(start);
        visited.add(start);
        int level = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(target)) return level;
                List<String> nextCombinations = getNextCombinations(current);
                for (String next : nextCombinations) {
                    if (!visited.contains(next) && !deadEnds.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
            level++;
        }
        
        return -1;
    }
    
    private List<String> getNextCombinations(String current) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            char[] chars = current.toCharArray();
            chars[i] = (char) ((chars[i] - '0' + 1) % 10 + '0');
            result.add(new String(chars));
            chars[i] = (char) ((chars[i] - '0' + 8) % 10 + '0');
            result.add(new String(chars));
        }
        return result;
    }
}