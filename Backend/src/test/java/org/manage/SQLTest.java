package org.manage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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