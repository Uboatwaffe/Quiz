package org.connecting;

import org.db.connecting.Connecting;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test
 * @see Connecting
 * @author Maciej
 * @version 0.1
 */
class ConnectingTest {

    /**
     * Test for method getConnection()
     */
    @org.junit.jupiter.api.Test
    void getConnection() {
        assertNotNull(Connecting.getConnection());
    }
}