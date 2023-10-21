package org.connecting;

import org.db.connecting.LoggingIn;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Test
 * @see LoggingIn
 * @author Maciej
 * @version 0.1
 */
class LoggingInTest {

    /**
     * Test for method getLoginAndPassword()
     */
    @org.junit.jupiter.api.Test
    void getLoginAndPassword() {
        assertNotNull(LoggingIn.getLoginAndPassword());
    }
}