package org.manage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToStringsTest {
    final ToStrings toStrings = new ToStrings();

    @Test
    void questionsInStringArray() {
        assertNotNull(toStrings.questionsInStringArray());
    }

    @Test
    void answersInStringArray() {
        assertNotNull(toStrings.answersInStringArray());
    }
}