class Solution {
    public boolean wordPattern(String pattern, String s) {
        
//         Approach-1: Doesn't work 
        
        // String[] words = s.split(" ");
        // if(words.length != pattern.length()) return false;
        // int n = words.length;
        // String[] map = new String[26];
        // for(int i=0; i<n; i++){
        //     char ch = pattern.charAt(i);
        //     String str = words[i];
        //     int index = ch - 'a';
        //     if(map[index] == null){
        //         map[index] = str;
        //         continue;
        //     }
        //     if(!map[index].equals(str))
        //         return false;
        // }
        // return true;
        
        
        
//         Approach-2: Works! | Time: O(pattern.length()) | Space: O(pattern.length())
        
        String[] words = s.split(" ");
        if(words.length != pattern.length())
            return false;
        
        int n = words.length;
        
        Map<String, Character> representedBy = new HashMap<>();
        Map<Character, String> representing = new HashMap<>();
        
        for(int i=0; i<n; i++){
            char ch = pattern.charAt(i);
            String word = words[i];
            if(!representedBy.containsKey(word) && !representing.containsKey(ch)){
                representedBy.put(word, ch);
                representing.put(ch, word);
            } else if(!representedBy.containsKey(word)){
                if(!representing.get(ch).equals(word))
                    return false;
                else
                    representedBy.put(word, ch);
            } else if(!representing.containsKey(ch)){
                if(representedBy.get(word) != ch)
                    return false;
                else
                    representing.put(ch, word);
            } else{
                if(representedBy.get(word) != ch
                    || !representing.get(ch).equals(word)){
                    return false;
                }
            }
        }
        return true;
    }
}
