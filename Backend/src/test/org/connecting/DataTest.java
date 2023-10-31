package org.connecting;

import org.db.connecting.Data;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test
 * @see Data
 * @author Maciej
 * @version 0.1
 */
class DataTest {

    /**
     * Test for method getData()
     */
    @org.junit.jupiter.api.Test
    void getConnection() {
        Data data = new Data();
        assertNotNull(data.getData());
    }
}