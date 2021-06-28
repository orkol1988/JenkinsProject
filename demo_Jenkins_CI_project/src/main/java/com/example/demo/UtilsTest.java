package com.example.demo;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class UtilsTest {

    @Test
    public void checkHighwayLegalSpeed_TrueTest(){
        boolean actualResult = Utils.checkHighwayLegalSpeed(120);

        assertEquals(true, actualResult);
    }

    @Test
    public void checkHighwayLegalSpeed_FalseTest(){
        boolean actualResult = Utils.checkHighwayLegalSpeed(121);

        assertEquals(false, actualResult);
    }

    @Test
    public void checkUrbanLegalSpeed_TrueTest(){
        boolean actualResult = Utils.checkUrbanLegalSpeed(90);

        assertEquals(true, actualResult);
    }

    @Test
    public void checkUrbanLegalSpeed_FalseTest(){
        boolean actualResult = Utils.checkUrbanLegalSpeed(91);

        assertEquals(false, actualResult);
    }
}
