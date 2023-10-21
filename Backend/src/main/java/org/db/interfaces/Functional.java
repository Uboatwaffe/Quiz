package org.db.interfaces;

/**
 * Functional interface
 * @author Maciej
 * @version 0.1
 */
public interface Functional{
    /**
     * @param chain String containing all of data
     * @return String array with question, answer, type
     */
    String[] toArray(String chain);
}
