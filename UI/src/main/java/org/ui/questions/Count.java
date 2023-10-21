package org.ui.questions;

/**
 * Class that keeps track on current score
 * @author Maciej
 * @version 0.1
 */
public class Count {
    /**
     * Field that keeps track of the score
     */
    private static int count = 0;

    /**
     * Method that returns score
     * @return Score of the user
     */
    public static int getCount() {
        return count;
    }

    /**
     * Method that sets score
     * @param count New score
     */
    public static void setCount(int count) {
        Count.count = count;
    }
}
