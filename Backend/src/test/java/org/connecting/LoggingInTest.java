package org.connecting;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Test
 * @see LoggingIn
 * @author Maciej
 * @version 0.1
 */
class LoggingInTest {
    @org.junit.jupiter.api.Test
    void getLoginAndPassword() {
        assertNotNull(LoggingIn.getLoginAndPassword());
    }
}