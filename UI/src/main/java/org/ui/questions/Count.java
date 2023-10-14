package org.ui.questions;

/**
 * Class that keeps track on current score
 * @author Maciej
 * @version 0.1
 */
public class Count {
    // Class that keeps track of count
    private static int count = 0;

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Count.count = count;
    }
}
