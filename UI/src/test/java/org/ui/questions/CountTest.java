package org.ui.questions;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Test
 * @see Count
 * @author Maciej
 * @version 0.1
 */
public class CountTest {

    @Test
    public void getCount() {
        assertNotNull(Count.getCount());
    }
}