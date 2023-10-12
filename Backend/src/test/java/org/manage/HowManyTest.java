package org.manage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HowManyTest {

    @Test
    void howMany() {
        HowMany howMany = new HowMany();
        Integer i = howMany.howMany();
        assertNotNull(i);
    }

    @Test
    void highest() {
        HowMany howMany = new HowMany();
        Integer i = howMany.highest();
        assertNotNull(i);
    }
}