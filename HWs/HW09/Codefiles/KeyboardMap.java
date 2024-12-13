import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Braiden Anderson
 * @version 1.0.0
 */
public class KeyboardMap {
    private static final ArrayList<String> ALLOWED_KEYS = new ArrayList<>(Arrays.asList("Q", "W", "E", "R", "T",
                                                                          "Y", "U", "I", "O", "P",
                                                                          "A", "S", "D", "F", "G",
                                                                          "H", "J", "K", "L", "ENTER",
                                                                          "Z", "X", "C", "V", "B",
                                                                          "N", "M", "BACK_SPACE"));
    //QWERTY layout. They are positioned well by using the tens place as the row and ones place as the column
    private HashMap<String, KeyboardPane> keyboardPaneMap = new HashMap<>();
    private HashMap<String, Integer> keyboardPositionMap = new HashMap<>();


    // CONSTRUCTORS
    /**
     * @param posOrKeyboard Used to determine which keyboardMap I want to instantiate.
     */
    public KeyboardMap(boolean posOrKeyboard) {
        if (posOrKeyboard) {
            instantiateKeyboardPositionMap();
        }
        if (!posOrKeyboard) {
            instantiateKeyboardPaneMap();
        }
    }

    // METHODS
    private void instantiateKeyboardPositionMap() {
        int index = 0;
        for (String key : ALLOWED_KEYS) {
            this.keyboardPositionMap.put(key, index++);
        }
    }

    private void instantiateKeyboardPaneMap() {
        for (String keyString : ALLOWED_KEYS) {
            this.keyboardPaneMap.put(keyString, new KeyboardPane(keyString));
        }
    }

        // GETTERS
            // PositionMap
    /**
     * @param key The key to search for the value in the HashMap
     * @return Returns the positional value from the HashMap.
     */
    public Integer getPosition(String key) {
        return this.keyboardPositionMap.get(key);
    }

    /**
     * @param value A value to search for in the positionMap HashMap.
     * @return Returns the key that corresponds to the HashMap value provided.
     */
    public String getPositionKeyString(Integer value) {
        for (String key : keyboardPositionMap.keySet()) {
            if (keyboardPositionMap.get(key).equals(value)) {
                return key;
            }
        }
        return null;
    }

            // PaneMap
    /**
     * @param key The key to search for the pane in the HashMap
     * @return Returns the pane from the HashMap.
     */
    public KeyboardPane getPane(String key) {
        return this.keyboardPaneMap.get(key);
    }

    /**
     * @param value A value to search for in the paneMap HashMap.
     * @return Returns the key that corresponds to the HashMap value provided.
     */
    public String getPaneKeyString(KeyboardPane value) {
        for (String key : keyboardPaneMap.keySet()) {
            if (keyboardPaneMap.get(key).equals(value)) {
                return key;
            }
        }
        return null;
    }
}