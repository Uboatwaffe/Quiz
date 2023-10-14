package org.manage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test
 * @see SQL
 * @author Maciej
 * @version 0.1
 */
class SQLTest {

    @Test
    void getCurrentTable() {
        assertNotNull(SQL.getCurrentTable());
    }

    @Test
    void getAllTables() {
        assertNotNull(SQL.getAllTables());
    }
}