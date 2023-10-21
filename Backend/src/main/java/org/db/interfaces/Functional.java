package org.db.interfaces;

/**
 * Functional interface
 * @author Maciej
 * @version 0.1
 */
public interface Functional{
    /**
     * Method that is used by lambda nr 1
     * @param chain String containing all of data
     * @return String array with question, answer, type
     */
    String[] toArray(String chain);
}
