import java.util.ArrayList;
/**
 * Write a description of class WordPairList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WordPairList
{
    // instance variables - replace the example below with your own
    private ArrayList<WordPair> allPairs;

    /**
     * Constructor for objects of class WordPairList
     */
    public WordPairList(String[] words)
    {
        for (int i = 0; i < words.length; i++)
        {
            for (int j = i + 1; j < words.length; j++)
            {
                allPairs.add(new WordPair(words[i], words[j]));
            }
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        int count = 0;
        for (int i = 0; i < allPairs.size(); i++)
        {
            if (allPairs.get(i).getFirst().equals(allPairs.get(i).getSecond()))
            {
                count++;
            }
        }
        
        return count;
    }
    
    public static void main(String[] args)
    {
        String[] a = {"Havala", "Halailanka", "Rielle"};
        WordPairList n = new WordPairList(a);
    }
}
