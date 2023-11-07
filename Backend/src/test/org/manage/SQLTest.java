package org.manage;

import org.db.connecting.SQL;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test
 * @see SQL
 * @author Maciej
 * @version 0.1
 */
class SQLTest {

    /**
     * Test for method getCurrentTable()
     */
    @Test
    void getCurrentTable() {
        assertNotNull(SQL.getCurrentTable());
    }


    /**
     * Test for method getAllTables()
     */
    @Test
    void getAllTables() {
        assertNotNull(SQL.getAllTables());
    }
}