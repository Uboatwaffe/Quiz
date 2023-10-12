package org.connecting;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ConnectingTest {

    @org.junit.jupiter.api.Test
    void getConnection() {
        assertNotNull(Connecting.getConnection());
    }
}