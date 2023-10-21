package org.manage;

import org.db.manage.HowMany;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test
 * @see HowMany
 * @author Maciej
 * @version 0.1
 */
class HowManyTest {

    /**
     * Test for method howMany()
     */
    @Test
    void howMany() {
        HowMany howMany = new HowMany();
        Integer i = howMany.howMany();
        assertNotNull(i);
    }

    /**
     * Test for method highest()
     */
    @Test
    void highest() {
        HowMany howMany = new HowMany();
        Integer i = howMany.highest();
        assertNotNull(i);
    }
}