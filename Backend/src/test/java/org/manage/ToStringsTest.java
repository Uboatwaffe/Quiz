package org.manage;

import org.db.manage.ToStrings;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Test
 * @see ToStrings
 * @author Maciej
 * @version 0.1
 */
class ToStringsTest {
    final ToStrings toStrings = new ToStrings();

    @Test
    void questionsInStringArray() throws IOException {
        assertNotNull(toStrings.questionsInStringArray());
    }

    @Test
    void answersInStringArray() throws IOException {
        assertNotNull(toStrings.answersInStringArray());
    }
}