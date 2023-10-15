package org.connecting;

import org.db.connecting.Connect;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test
 * @see Connect
 * @author Maciej
 * @version 0.1
 */
class ConnectTest {
    @org.junit.jupiter.api.Test
    void getConnection() {
        Connect connect = new Connect();
        assertNotNull(connect.getConnection());
    }
}