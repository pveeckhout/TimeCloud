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

package timecloud.dao;

import timecloud.dao.episode.EpisodeDaoImpl;
import java.util.Collection;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import timecloud.dto.episode.EpisodeDTO;
import timecloud.model.episode.Episode;

/**
 *
 * TestNG for EpisodeDaoImpl
 * 
 * @see EpisodeDaoImpl
 * 
 * @author Pieter Van Eeckhout
 */
public class EpisodeDaoImplNGTest {
    
    public EpisodeDaoImplNGTest() {
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
     * Test of create method, of class EpisodeDaoImpl.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        EpisodeDTO episodeDTO = null;
        EpisodeDaoImpl instance = new EpisodeDaoImpl();
        Episode expResult = null;
        Episode result = instance.create(episodeDTO);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class EpisodeDaoImpl.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        EpisodeDTO episodeDTO = null;
        EpisodeDaoImpl instance = new EpisodeDaoImpl();
        Episode expResult = null;
        Episode result = instance.update(episodeDTO);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readAll method, of class EpisodeDaoImpl.
     */
    @Test
    public void testReadAll() {
        System.out.println("readAll");
        EpisodeDaoImpl instance = new EpisodeDaoImpl();
        Collection expResult = null;
        Collection result = instance.readAll();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class EpisodeDaoImpl.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        long episodeID = 0L;
        EpisodeDaoImpl instance = new EpisodeDaoImpl();
        instance.delete(episodeID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
