/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author davidperez
 */
public class ArrayListTest {
    
    public ArrayListTest() {
    }

   /**
     * Test of addFirst method, of class ArrayList.
     */
    @Test
    public void testAddFirst() {
        ArrayList arrayTest = new ArrayList();
        int expectedValue = 4;
        arrayTest.addFirst(7);
        arrayTest.addFirst(10);
        arrayTest.addFirst(expectedValue);
        assertEquals(expectedValue, arrayTest.getFirst());
    }

    /**
     * Test of addLast method, of class ArrayList.
     */
    @Test
    public void testAddLast() {
        ArrayList arrayTest = new ArrayList();
        int expectedValue = 4;
        arrayTest.addLast(7);
        arrayTest.addLast(10);
        arrayTest.addLast(expectedValue);
        assertEquals(expectedValue, arrayTest.getLast());
    }

    /**
     * Test of getFirst method, of class ArrayList.
     */
    @Test
    public void testGetFirst() {
        ArrayList arrayTest = new ArrayList();
        int expectedValue = 4;
        arrayTest.addFirst(7);
        arrayTest.addFirst(10);
        arrayTest.addFirst(expectedValue);
        assertEquals(expectedValue, arrayTest.getFirst());
    }

    /**
     * Test of getLast method, of class ArrayList.
     */
    @Test
    public void testGetLast() {
        ArrayList arrayTest = new ArrayList();
        int expectedValue = 4;
        arrayTest.addLast(7);
        arrayTest.addLast(10);
        arrayTest.addLast(expectedValue);
        assertEquals(expectedValue, arrayTest.getLast());
    }

    /**
     * Test of indexOf method, of class ArrayList.
     */
    @Test
    public void testIndexOf() {
        ArrayList arrayTest = new ArrayList();
        
        arrayTest.addLast(4);
        arrayTest.addLast(6);
        arrayTest.addLast(9);
        assertAll("indexOf",
                () -> assertEquals(2, arrayTest.indexOf(9)),
                () -> assertEquals(-1, arrayTest.indexOf(10))
        );
    }

    /**
     * Test of size method, of class ArrayList.
     */
    @Test
    public void testSize() {
        ArrayList arrayTest = new ArrayList();
        arrayTest.addFirst(2);
        arrayTest.addFirst(3);
        assertEquals(2, arrayTest.size());
    }

    /**
     * Test of removeLast method, of class ArrayList.
     */
    @Test
    public void testRemoveLast() {
        ArrayList arrayTest = new ArrayList();
        arrayTest.addLast(2);
        arrayTest.addLast(3);
        arrayTest.addLast(4);
        int previousSize = arrayTest.size();
        Object lastItem = arrayTest.getLast();
        arrayTest.removeLast();
        assertAll("last",
                () -> assertEquals(previousSize - 1, arrayTest.size()),
                () -> assertEquals(-1, arrayTest.indexOf(lastItem))
        );
    }

    /**
     * Test of removeFirst method, of class ArrayList.
     */
    @Test
    public void testRemoveFirst() {
        ArrayList arrayTest = new ArrayList();
        arrayTest.addFirst(2);
        arrayTest.addFirst(3);
        arrayTest.addFirst(4);
        int previousSize = arrayTest.size();
        Object firstItem = arrayTest.getFirst();
        arrayTest.removeFirst();

        assertAll("first",
                () -> assertEquals(previousSize - 1, arrayTest.size()),
                () -> assertEquals(-1, arrayTest.indexOf(firstItem))
        );
    }

    /**
     * Test of insert method, of class ArrayList.
     */
    @Test
    public void testInsert() {
        ArrayList arrayTest = new ArrayList();
        int expectedValue = 4;

        arrayTest.addFirst(1);
        arrayTest.addFirst(2);
        arrayTest.addFirst(3);

        arrayTest.insert(1, expectedValue);

        assertAll("insert",
                () -> assertEquals(false, arrayTest.insert(1, null)),
                () -> assertEquals(expectedValue, arrayTest.get(1))
        );
    }

    /**
     * Test of set method, of class ArrayList.
     */
    @Test
    public void testSet() {
        ArrayList arrayTest = new ArrayList();
        arrayTest.addLast(2);
        arrayTest.addLast(3);
        arrayTest.addLast(4);

        assertAll("set",
                () -> assertEquals(true, arrayTest.set(1, 10)),
                () -> assertEquals(10, arrayTest.get(1)),
                () -> assertEquals(false, arrayTest.set(1, null))
        );

    }

    /**
     * Test of isEmpty method, of class ArrayList.
     */
    @Test
    public void testIsEmpty() {
        ArrayList arrayTest = new ArrayList();
        arrayTest.addFirst(4);
        assertEquals(false, arrayTest.isEmpty());
        arrayTest.removeFirst();
        assertEquals(true, arrayTest.isEmpty());
    }

    /**
     * Test of get method, of class ArrayList.
     */
    @Test
    public void testGet() {
        ArrayList arrayTest = new ArrayList();
        int expectedValue = 4;
        arrayTest.addLast(1);
        arrayTest.addLast(45);
        arrayTest.addLast(expectedValue);
        arrayTest.addLast(22);
        assertEquals(expectedValue, arrayTest.get(2));
    }

    /**
     * Test of contains method, of class ArrayList.
     */
    @Test
    public void testContains() {
        ArrayList arrayTest = new ArrayList();
        int expectedValue = 4;
        arrayTest.addLast(expectedValue);

        assertAll("contains",
                () -> assertEquals(true, arrayTest.contains(expectedValue)),
                () -> assertEquals(false, arrayTest.contains(1000)),
                () -> assertEquals(false, arrayTest.contains(null))
        );
    }

    /**
     * Test of remove method, of class ArrayList.
     */
    @Test
    public void testRemove() {
        ArrayList arrayTest = new ArrayList();

        arrayTest.addFirst(2);
        arrayTest.addFirst(3);
        arrayTest.addFirst(4);

        int previousSize = arrayTest.size();

        arrayTest.remove(1);

        assertAll("remove",
                () -> assertEquals(previousSize - 1, arrayTest.size()),
                () -> assertEquals(-1, arrayTest.indexOf(3))
        );

    }
    
}
