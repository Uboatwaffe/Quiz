package org.connecting;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test
 * @see Connecting
 * @author Maciej
 * @version 0.1
 */
class ConnectingTest {

    @org.junit.jupiter.api.Test
    void getConnection() {
        assertNotNull(Connecting.getConnection());
    }
}