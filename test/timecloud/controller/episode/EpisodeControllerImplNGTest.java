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

package timecloud.controller.episode;

import java.util.Collection;
import java.util.Map;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import timecloud.dto.EpisodeDTO;
import timecloud.model.episode.Episode;

/**
 *
 * TestNG for EpisodeControllerImpl
 * 
 * @see EpisodeControllerImpl
 * 
 * @author Pieter Van Eeckhout
 */
public class EpisodeControllerImplNGTest {
    
    public EpisodeControllerImplNGTest() {
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
     * Test of save method, of class EpisodeControllerImpl.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        EpisodeDTO episodeDTO = null;
        EpisodeControllerImpl instance = null;
        instance.save(episodeDTO);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllFromDB method, of class EpisodeControllerImpl.
     */
    @Test
    public void testGetAllFromDB() {
        System.out.println("getAllFromDB");
        EpisodeControllerImpl instance = null;
        Map expResult = null;
        Map result = instance.getAllFromDB();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEpisode method, of class EpisodeControllerImpl.
     */
    @Test
    public void testGetEpisode() {
        System.out.println("getEpisode");
        long episodeNumber = 0L;
        EpisodeControllerImpl instance = null;
        Episode expResult = null;
        Episode result = instance.getEpisode(episodeNumber);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllEpisodes method, of class EpisodeControllerImpl.
     */
    @Test
    public void testGetAllEpisodes() {
        System.out.println("getAllEpisodes");
        EpisodeControllerImpl instance = null;
        Collection expResult = null;
        Collection result = instance.getAllEpisodes();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class EpisodeControllerImpl.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        long episodeID = 0L;
        EpisodeControllerImpl instance = null;
        instance.delete(episodeID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
