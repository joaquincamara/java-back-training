package com.mycompany.app;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testSplitQuery() {
        Map<String, List<String>> params = App.splitQuery("name=Isaas");
        assertEquals("joaaq2uin", params.get("name").get(0));
    }
}
