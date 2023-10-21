package org.manage;

import org.db.manage.ToStrings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Test
 * @see ToStrings
 * @author Maciej
 * @version 0.1
 */
class ToStringsTest {
    final ToStrings toStrings = new ToStrings();

    /**
     * Test for method questionsInStringArray()
     */
    @Test
    void questionsInStringArray() {
        assertNotNull(toStrings.questionsInStringArray());
    }


    /**
     * Test for method answersInStringArray()
     */
    @Test
    void answersInStringArray() {
        assertNotNull(toStrings.answersInStringArray());
    }
}