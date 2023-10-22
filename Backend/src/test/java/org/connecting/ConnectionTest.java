package org.connecting;

import org.db.connecting.Connection;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test
 * @see Connection
 * @author Maciej
 * @version 0.1
 */
class ConnectionTest {

    /**
     * Test for method getData()
     */
    @org.junit.jupiter.api.Test
    void getConnection() {
        assertNotNull(Connection.getConnection());
    }
}