package org.ui.questions;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;


public class CountTest {

    @Test
    public void getCount() {
        assertNotNull(Count.getCount());
    }
}