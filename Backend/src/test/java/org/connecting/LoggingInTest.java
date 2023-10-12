package org.connecting;

import static org.junit.jupiter.api.Assertions.*;

class LoggingInTest {
    @org.junit.jupiter.api.Test
    void getLoginAndPassword() {
        assertNotNull(LoggingIn.getLoginAndPassword());
    }
}