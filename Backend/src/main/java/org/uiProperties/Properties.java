package org.uiProperties;

/**
 * Class that contains fields regulating parameters of ui design
 *
 * @author Maciej
 * @version 0.1
 */
public class Properties {

    /**
     * Property that allows to scale windows
     */
    private static Boolean scalable = false;

    /**
     * Getter
     *
     * @return ability to scale windows
     */
    public static Boolean getScalable() {
        return scalable;
    }

    /**
     * Setter
     * @param scalable new value
     */
    public static void setScalable(Boolean scalable) {
        Properties.scalable = scalable;
    }
}
