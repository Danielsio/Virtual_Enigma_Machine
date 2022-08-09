package machine.component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlugBoard {

    private Map<Integer, Integer> plugMap;


    /**
     * constructor for PlugBoard
     * creates an empty plugMap
     */
    public PlugBoard() {
        this.plugMap = new HashMap<>();
    }

    /**
     *
     * @return a map of indices that represents the pairs of letters that are currently plugged
     */
    public Map<Integer, Integer> getPlugMap() {
        return plugMap;
    }

    /**
     * finds out if a letter has a plug in the plug board
     * @param keyIndex index that represents a letter to be checked
     * @return 'true' if the letter is currently plugged, 'false' otherwise
     */
    public boolean isPlugged(int keyIndex){
        return plugMap.containsKey(keyIndex);
    }


    /**
     * finds out the value of the matching letter, which is plugged to the given letter
     * assuming the pair exists in the plug board
     * @param keyIndex index that represents a letter to be checked
     * @return index that represents the matching pair
     */
    public int getMatch(int keyIndex) {
        return plugMap.get(keyIndex);
    }


    /**
     * initializes the plug board mapping
     * @param character2index a map that translates each letter in the alphabet, to an index
     * @param plugs a string that represents the plug pairs.
     *              each pair is seperated with ','
     *              a pair is divided with '|'
     *              for example, "A|Z,D|E" means that there are two pairs.
     *              first pair : A and Z. second pair : D and E.
     */
    public void initPlugBoardMap(Map<Character, Integer> character2index, List<String> plugs){

        plugMap.clear();
        // run through all plugs
        for (String plug : plugs) {

            // convert char to index
            int firstInPlugIndex = character2index.get(plug.charAt(0));
            int secondInPlugIndex = character2index.get(plug.charAt(1));

            // build  plug map
            plugMap.put(secondInPlugIndex, firstInPlugIndex);
            plugMap.put(firstInPlugIndex, secondInPlugIndex);
        }
    }

    @Override
    public String toString() {
        return "PlugBoard{" +
                "plugMap=" + plugMap +
                '}';
    }

}
