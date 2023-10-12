package org.connecting;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ConnectTest {
    @org.junit.jupiter.api.Test
    void getConnection() {
        Connect connect = new Connect();
        assertNotNull(connect.getConnection());
    }
}