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
 *//*
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
import timecloud.model.transfer.Transfer;

/**
 *
 * @author Pieter Van Eeckhout
 */
public class EpisodeImplBuilderNGTest {

    public EpisodeImplBuilderNGTest() {
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
     * Test of setEpisodeID method, of class EpisodeBuilderImpl.
     */
    @Test
    public void testSetEpisodeID() {
        System.out.println("setEpisodeID");
        long episodeID = 0L;
        EpisodeBuilderImpl instance = new EpisodeImplBuilderImpl();
        EpisodeBuilderImpl expResult = null;
        EpisodeBuilderImpl result = instance.setEpisodeID(episodeID);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPatientID method, of class EpisodeBuilderImpl.
     */
    @Test
    public void testSetPatientID() {
        System.out.println("setPatientID");
        String patientID = "";
        EpisodeBuilderImpl instance = new EpisodeImplBuilderImpl();
        EpisodeBuilderImpl expResult = null;
        EpisodeBuilderImpl result = instance.setPatientID(patientID);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIntakeTimestamp method, of class EpisodeBuilderImpl.
     */
    @Test
    public void testSetIntakeTimestamp() {
        System.out.println("setIntakeTimestamp");
        DateTime intakeTimestamp = null;
        EpisodeBuilderImpl instance = new EpisodeImplBuilderImpl();
        EpisodeBuilderImpl expResult = null;
        EpisodeBuilderImpl result = instance.setIntakeTimestamp(intakeTimestamp);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMeg method, of class EpisodeBuilderImpl.
     */
    @Test
    public void testSetMeg() {
        System.out.println("setMeg");
        boolean meg = false;
        EpisodeBuilderImpl instance = new EpisodeImplBuilderImpl();
        EpisodeBuilderImpl expResult = null;
        EpisodeBuilderImpl result = instance.setMeg(meg);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTriageTimestamp method, of class EpisodeBuilderImpl.
     */
    @Test
    public void testSetTriageTimestamp() {
        System.out.println("setTriageTimestamp");
        DateTime triageTimestamp = null;
        EpisodeBuilderImpl instance = new EpisodeImplBuilderImpl();
        EpisodeBuilderImpl expResult = null;
        EpisodeBuilderImpl result = instance.setTriageTimestamp(triageTimestamp);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTriageLevel method, of class EpisodeBuilderImpl.
     */
    @Test
    public void testSetTriageLevel() {
        System.out.println("setTriageLevel");
        TriageLevel triageLevel = null;
        EpisodeBuilderImpl instance = new EpisodeImplBuilderImpl();
        EpisodeBuilderImpl expResult = null;
        EpisodeBuilderImpl result = instance.setTriageLevel(triageLevel);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTransfers method, of class EpisodeBuilderImpl.
     */
    @Test
    public void testSetTransfers() {
        System.out.println("setTransfers");
        Collection<Transfer> transfers = null;
        EpisodeBuilderImpl instance = new EpisodeImplBuilderImpl();
        EpisodeBuilderImpl expResult = null;
        EpisodeBuilderImpl result = instance.setTransfers(transfers);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createEpisodeImpl method, of class EpisodeBuilderImpl.
     */
    @Test
    public void testCreateEpisodeImpl() {
        System.out.println("createEpisodeImpl");
        EpisodeBuilderImpl instance = new EpisodeImplBuilderImpl();
        EpisodeImpl expResult = null;
        EpisodeImpl result = instance.createEpisode();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class EpisodeImplBuilderImpl extends EpisodeBuilderImpl {
    }

}
