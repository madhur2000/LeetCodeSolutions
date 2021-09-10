class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> charCounts = new HashMap<>();
        for(char c : s.toCharArray()){
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(new Comparator<Character>(){
            public int compare(Character c1, Character c2){
                return (charCounts.get(c2) - charCounts.get(c1));
            }
        });
        
        for(Character c : charCounts.keySet()){
            maxHeap.add(c);
        }
        
        StringBuilder ans = new StringBuilder();
        
        while(maxHeap.size() >= 2){
            char mostFreq = maxHeap.remove();
            char secondMostFreq = maxHeap.remove();
            ans.append(mostFreq);
            ans.append(secondMostFreq);
            
            charCounts.put(mostFreq, charCounts.get(mostFreq) - 1);
            charCounts.put(secondMostFreq, charCounts.get(secondMostFreq) - 1);
            
            if(charCounts.get(mostFreq) > 0){
                maxHeap.add(mostFreq);
            }
            if(charCounts.get(secondMostFreq) > 0){
                maxHeap.add(secondMostFreq);
            }
        }
        
        if(maxHeap.size() != 0){
            char last = maxHeap.remove();
            if(charCounts.get(last) == 1){
                ans.append(last);
                return ans.toString();
            }
            return "";
        }
        return ans.toString();
    }
}
