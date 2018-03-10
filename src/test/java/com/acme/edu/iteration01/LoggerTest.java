package com.acme.edu.iteration01;

import com.acme.edu.Logger;
import com.acme.edu.MessageState;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

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
    public void shouldLogInteger() throws IOException {
        Logger.log(1);
        Logger.flush();
        Logger.log(0);
        Logger.flush();
        Logger.log(-1);
        Logger.flush();

        assertSysoutContains("primitive: ");
        assertSysoutContains("primitive: 1");
        assertSysoutContains("primitive: 0");
        assertSysoutContains("primitive: -1");
    }

    @Test
    public void shouldLogByte() throws IOException {
        Logger.log((byte)1);
        MessageState.flush();
        Logger.log((byte)0);
        MessageState.flush();
        Logger.log((byte)-1);
        MessageState.flush();

        assertSysoutContains("primitive: ");
        assertSysoutContains("1");
        assertSysoutContains("0");
        assertSysoutContains("-1");
    }

    @Test
    public void shouldLogChar() throws IOException {
        Logger.log('a');
        Logger.log('b');

        assertSysoutContains("char: ");
        assertSysoutContains("a");
        assertSysoutContains("b");
    }

    @Test
    public void shouldLogString() throws IOException {
        Logger.log("test string 1");
        MessageState.flush();
        Logger.log("other str");
        MessageState.flush();

        assertSysoutContains("string: ");
        assertSysoutContains("test string 1");
        assertSysoutContains("other str");
    }

    @Test
    public void shouldLogBoolean() throws IOException {
        Logger.log(true);
        Logger.log(false);

        assertSysoutContains("primitive: ");
        assertSysoutContains("true");
        assertSysoutContains("false");
    }

    @Test
    public void shouldLogReference() throws IOException {
        Logger.log(new Object());

        assertSysoutContains("reference: ");
        assertSysoutContains("@");
    }
}