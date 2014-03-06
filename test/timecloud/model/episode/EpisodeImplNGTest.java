/*
*   The MIT License (MIT)
*
*   Copyright (c) 2014 Pieter Van Eeckhout
*
*   Permission is hereby granted, free of charge, to any person obtaining a copy of
*   this software and associated documentation files (the "Software"), to deal in
*   the Software without restriction, including without limitation the rights to
*   use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
*   the Software, and to permit persons to whom the Software is furnished to do so,
*   subject to the following conditions:
*
*   The above copyright notice and this permission notice shall be included in all
*   copies or substantial portions of the Software.
*
*   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
*   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
*   FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
*   COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
*   IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
*   CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package timecloud.model.episode;

import java.util.Collection;
import org.joda.time.DateTime;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import timecloud.enums.TriageLevel;

/**
 *
 * TestNG for EpisodeImpl
 * 
 * @see EpisodeImpl
 * 
 * @author Pieter Van Eeckhout
 */
public class EpisodeImplNGTest {
    
    public EpisodeImplNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of setEpisodeID method, of class EpisodeImpl.
     */
    @Test
    public void testSetEpisodeID() {
        System.out.println("setEpisodeID");
        long episodeID = 0L;
        EpisodeImpl instance = null;
        instance.setEpisodeID(episodeID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEpisodeID method, of class EpisodeImpl.
     */
    @Test
    public void testGetEpisodeID() {
        System.out.println("getEpisodeID");
        EpisodeImpl instance = null;
        long expResult = 0L;
        long result = instance.getEpisodeID();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPatientID method, of class EpisodeImpl.
     */
    @Test
    public void testSetPatientID() {
        System.out.println("setPatientID");
        String patientID = "";
        EpisodeImpl instance = null;
        instance.setPatientID(patientID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getpatientID method, of class EpisodeImpl.
     */
    @Test
    public void testGetpatientID() {
        System.out.println("getpatientID");
        EpisodeImpl instance = null;
        String expResult = "";
        String result = instance.getpatientID();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIntakeTimestamp method, of class EpisodeImpl.
     */
    @Test
    public void testSetIntakeTimestamp() {
        System.out.println("setIntakeTimestamp");
        DateTime intakeTimestamp = null;
        EpisodeImpl instance = null;
        instance.setIntakeTimestamp(intakeTimestamp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIntakeTimestamp method, of class EpisodeImpl.
     */
    @Test
    public void testGetIntakeTimestamp() {
        System.out.println("getIntakeTimestamp");
        EpisodeImpl instance = null;
        DateTime expResult = null;
        DateTime result = instance.getIntakeTimestamp();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMeg method, of class EpisodeImpl.
     */
    @Test
    public void testSetMeg() {
        System.out.println("setMeg");
        boolean meg = false;
        EpisodeImpl instance = null;
        instance.setMeg(meg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMeg method, of class EpisodeImpl.
     */
    @Test
    public void testGetMeg() {
        System.out.println("getMeg");
        EpisodeImpl instance = null;
        boolean expResult = false;
        boolean result = instance.getMeg();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTriageTimestamp method, of class EpisodeImpl.
     */
    @Test
    public void testSetTriageTimestamp() {
        System.out.println("setTriageTimestamp");
        DateTime triageTimestamp = null;
        EpisodeImpl instance = null;
        instance.setTriageTimestamp(triageTimestamp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTriageTimestamp method, of class EpisodeImpl.
     */
    @Test
    public void testGetTriageTimestamp() {
        System.out.println("getTriageTimestamp");
        EpisodeImpl instance = null;
        DateTime expResult = null;
        DateTime result = instance.getTriageTimestamp();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTriageLevel method, of class EpisodeImpl.
     */
    @Test
    public void testSetTriageLevel() {
        System.out.println("setTriageLevel");
        TriageLevel triageLevel = null;
        EpisodeImpl instance = null;
        instance.setTriageLevel(triageLevel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTriageLevel method, of class EpisodeImpl.
     */
    @Test
    public void testGetTriageLevel() {
        System.out.println("getTriageLevel");
        EpisodeImpl instance = null;
        TriageLevel expResult = null;
        TriageLevel result = instance.getTriageLevel();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTransfers method, of class EpisodeImpl.
     */
    @Test
    public void testGetTransfers() {
        System.out.println("getTransfers");
        EpisodeImpl instance = null;
        Collection expResult = null;
        Collection result = instance.getTransfers();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class EpisodeImpl.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        EpisodeImpl instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class EpisodeImpl.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        EpisodeImpl instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
