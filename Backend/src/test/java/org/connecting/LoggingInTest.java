package org.connecting;

import org.db.connecting.LoggingIn;

import java.io.IOException;

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