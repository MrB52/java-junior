package com.acme.edu.iteration02;

import com.acme.edu.Logger;
import com.acme.edu.MessageState;
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
    public void shouldLogSequentIntegersAsSum() throws IOException {
        Logger.log("str 1");
        Logger.log(1);
        Logger.log(2);
        Logger.log(2);
        Logger.log("str 2");
        Logger.log(0);
        MessageState.flush();

        assertSysoutContains("str 1");
        assertSysoutContains("3");
        assertSysoutContains("str 2");
        assertSysoutContains("0");
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {

        Logger.log("str 1");
        Logger.log(10);
        Logger.log(Integer.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        MessageState.flush();

        assertSysoutContains("str 1");
        assertSysoutContains("10");
        assertSysoutContains(Integer.toString(Integer.MAX_VALUE));
        assertSysoutContains("str 2");
        assertSysoutContains("0");
    }

    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() {
        Logger.log("str 1");
        Logger.log((byte)10);
        Logger.log(Byte.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        MessageState.flush();

        assertSysoutContains("str 1");
        assertSysoutContains("10");
        assertSysoutContains(Integer.toString(Byte.MAX_VALUE));
        assertSysoutContains("str 2");
        assertSysoutContains("0");
    }

    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws IOException {
        Logger.log("str 1");
        Logger.log("str 2");
        Logger.log("str 2");
        Logger.log(0);
        Logger.log("str 2");
        Logger.log("str 3");
        Logger.log("str 3");
        Logger.log("str 3");
        MessageState.flush();

        assertSysoutContains("str 1");
        assertSysoutContains("str 2 (x2)");
        assertSysoutContains("0");
        assertSysoutContains("str 2");
        assertSysoutContains("str 3 (x3)");
    }
}