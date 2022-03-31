//My solution
public static boolean isPerm(String stringOne, String stringTwo)
        {
            if(stringOne.length() != stringTwo.length())
            {
                return false;
            }

            HashMap<Character, Integer> charFreq1 = new HashMap<>();
            HashMap<Character, Integer> charFreq2 = new HashMap<>();

            for(char key : stringOne.toCharArray())
            {
                int currentValue = charFreq1.getOrDefault(key, 0);
                charFreq1.put(key, currentValue + 1);
            }

            for(char key2 : stringTwo.toCharArray())
            {
                int currentValue2 = charFreq2.getOrDefault(key2, 0);
                charFreq2.put(key2, currentValue2 + 1);
            }

            if(charFreq1.equals(charFreq2) == true)
            {
                return true;
            }
            return false;
        }

//The Book's Solution:
//Logic->If you sort the strings based on their ASCII value, and then just compare them using equals()
//      -if they are perms- they should match.
//      Book solution creates a helper method called sort(String s)

public static String sort(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
}

public static boolean permutation(String s, String t) {
        return sort(s).equals(sort(t));
}