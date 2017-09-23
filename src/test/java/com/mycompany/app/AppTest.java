package com.mycompany.app;
import java.util.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */

import java.util.*;
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }
    public void testFound() {
      ArrayList<String> array = new ArrayList<>(Arrays.asList("a","b","b","a"));
      assertTrue(new App().searchWord(array, "b","a"));
    }

    public void testNotFound() {
      ArrayList<String> array = new ArrayList<>(Arrays.asList("a","b","w","s"));
      assertFalse(new App().searchWord(array,"c", "d"));
    }

    public void testEmptyArray() {
      ArrayList<String> array = new ArrayList<>();
      assertFalse(new App().searchWord(array, " "," " ));
    }

    public void testNull() {
      assertFalse(new App().searchWord(null,"nehir","nehir"));
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
