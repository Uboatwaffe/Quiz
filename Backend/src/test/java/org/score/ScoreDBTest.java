package org.score;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreDBTest {

    @Test
    void getStats() {
        assertNotNull(ScoreDB.getStats());
    }
}