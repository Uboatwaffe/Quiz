package org.uiProperties;

/**
 * Class that contains fields regulating parameters of ui design
 *
 * @author Maciej
 * @version 0.1
 */
public class Properties {
    private static Boolean scalable = false;

    public static Boolean getScalable() {
        return scalable;
    }

    public static void setScalable(Boolean scalable) {
        Properties.scalable = scalable;
    }
}
