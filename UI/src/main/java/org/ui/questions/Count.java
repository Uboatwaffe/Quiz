package org.ui.questions;

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
