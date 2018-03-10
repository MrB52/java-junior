package com.acme.edu.iteration03;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }

    @Test
    public void shouldLogIntegersArray() throws IOException {
        Logger.log(new int[] {-1, 0, 1});

        assertSysoutContains("primitives array: {-1, 0, 1}");
    }

    @Test
    public void shouldLogIntegersMatrix() throws IOException {
        Logger.log(new int[][] {{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});

        assertSysoutContains("primitives matrix: {");
        assertSysoutContains("{-1, 0, 1}");
        assertSysoutContains("{1, 2, 3}");
        assertSysoutContains("{-1, -2, -3}");
        assertSysoutContains("}");
    }
}