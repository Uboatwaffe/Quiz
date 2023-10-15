package org.score;

import org.db.score.ScoreDB;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Test
 * @see ScoreDB
 * @author Maciej
 * @version 0.1
 */
class ScoreDBTest {

    @Test
    void getStats() {
        assertNotNull(ScoreDB.getStats());
    }
}