public class Trie {

    static int alphabet_size  = 26;
    
    static class TrieNode {
    	
        TrieNode[] n = new TrieNode[alphabet_size];

        boolean isEndOfWord;
          
        TrieNode(){
            isEndOfWord = false;
            for (int i = 0; i < alphabet_size; i++)
                n[i] = null;
        }
    }
       
    static TrieNode root; 
    static void insert(String key) {
    	
        int level;
        int length = key.length();
        int index;
       
        TrieNode p = root;
       
        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';
            if (p.n[index] == null)
                p.n[index] = new TrieNode();
       
            p = p.n[index];
        }

        p.isEndOfWord = true;
    }

    static boolean search(String key)
    {
        int level;
        int length = key.length();
        int index;
        TrieNode p = root;
       
        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';
       
            if (p.n[index] == null)
                return false;
       
            p = p.n[index];
        }
       
        return (p.isEndOfWord);
    }

    public static void main(String args[]) {
    	
        String keys[] = {"amrita", "vishwa", "vidyapeetham"};
       
        String output[] = {"Not present in trie.", "Present in trie."};
       
        root = new TrieNode();
       
        int i;
        for (i = 0; i < keys.length ; i++)
            insert(keys[i]);
       
        if(search("amrita") == true)
            System.out.println("amrita - " + output[1]);
        else 
        	System.out.println("amrita - " + output[0]);
   
        if(search("coimbatore") == true)
            System.out.println("coimbatore - " + output[1]);
        else 
        	System.out.println("coimbatore - " + output[0]);
    }
}