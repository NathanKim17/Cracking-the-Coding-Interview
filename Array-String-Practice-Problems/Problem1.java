
public class Main {

    public static void main(String[] args) {
        String testCase1 = "293926687";
        String testCase2 = "12345";
        String apple = "apple";
        String y = "y";

        int p = apple.charAt(2);
        System.out.println(p);

        System.out.println(testCase1 + " brute force result: " + uniqueString(testCase1));
        System.out.println(testCase2 + " brute force result: " + uniqueString(testCase2));

        System.out.println();

        System.out.println(testCase1 + " version 2 result: " + uniqueStringV2(testCase1));
        System.out.println(testCase2 + " version 2 result: " + uniqueStringV2(testCase2));
        System.out.println(apple + "version 2 result: " + uniqueStringV2(apple));
        System.out.println(y + " version 2 result: " + uniqueStringV2(y));

        System.out.println();
        System.out.println(testCase1 + " book sol. result: " + uniqueStringBookSol(testCase1));
        System.out.println(testCase2 + " book sol. result: " + uniqueStringBookSol(testCase2));
        System.out.println(apple + " book sol. result: " + uniqueStringBookSol(apple));
        System.out.println(y + " book sol. result: " + uniqueStringBookSol(y));

    }
    //Brute Force Solution
    public static boolean uniqueString(String arg)
    {
        for(int i = 0; i < arg.length(); i++)
        {
            for(int j = 0; j < arg.length(); j++)
            {
                if((i != j) && (arg.charAt(i) == arg.charAt(j)))
                {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean uniqueStringV2(String arg)
    {
        for(int i = 0; i < arg.length(); i++)
        {
            if(arg.lastIndexOf(arg.charAt(i)) != i)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean uniqueStringBookSol(String arg)
    {
        // We can only use the first 128 characters in the ascii chart
        if (arg.length() > 128) {
            return false;
        }
        //Creating a hash table: The key will be the character's ASCII code and the value will be whether true or false
        boolean[] char_set = new boolean[128];

        for (int i = 0; i < arg.length(); i++)
        {
            //val will contain the ASCII code of the character
            int val = arg.charAt(i);
            //If entry exists, the character is not unique
            if (char_set[val]) return false;
            //Else, create a new entry
            char_set[val] = true;
        }

        return true;
    }
}