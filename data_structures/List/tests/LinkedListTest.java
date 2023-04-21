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
public class LinkedListTest {

    int expectedValue = 4;

    public LinkedListTest() {
    }

    /**
     * Test of addFirst method, of class LinkedList.
     */
    @Test
    public void testAddFirst() {
        LinkedList arrayTest = new LinkedList();
        arrayTest.addFirst(7);
        arrayTest.addFirst(10);
        arrayTest.addFirst(expectedValue);
        assertEquals(expectedValue, arrayTest.getFirst());
    }

    /**
     * Test of addLast method, of class LinkedList.
     */
    @Test
    public void testAddLast() {
        LinkedList arrayTest = new LinkedList();
        arrayTest.addLast(7);
        arrayTest.addLast(10);
        arrayTest.addLast(expectedValue);
        assertEquals(expectedValue, arrayTest.getLast());
    }

    /**
     * Test of getFirst method, of class LinkedList.
     */
    @Test
    public void testGetFirst() {
        LinkedList arrayTest = new LinkedList();
        arrayTest.addFirst(7);
        arrayTest.addFirst(10);
        arrayTest.addFirst(expectedValue);
        assertEquals(expectedValue, arrayTest.getFirst());
    }

    /**
     * Test of getLast method, of class LinkedList.
     */
    @Test
    public void testGetLast() {
        LinkedList arrayTest = new LinkedList();
        arrayTest.addLast(7);
        arrayTest.addLast(10);
        arrayTest.addLast(expectedValue);
        assertEquals(expectedValue, arrayTest.getLast());
    }

    /**
     * Test of indexOf method, of class LinkedList.
     */
    @Test
    public void testIndexOf() {
        LinkedList arrayTest = new LinkedList();
        arrayTest.addLast(4);
        arrayTest.addLast(6);
        arrayTest.addLast(9);
        assertAll("indexOf",
                () -> assertEquals(2, arrayTest.indexOf(9)),
                () -> assertEquals(-1, arrayTest.indexOf(10))
        );
    }

    /**
     * Test of size method, of class LinkedList.
     */
    @Test
    public void testSize() {
        LinkedList arrayTest = new LinkedList();
        arrayTest.addFirst(2);
        arrayTest.addFirst(3);
        assertEquals(2, arrayTest.size());

    }

    /**
     * Test of removeLast method, of class LinkedList.
     */
    @Test
    public void testRemoveLast() {
        LinkedList arrayTest = new LinkedList();
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
     * Test of removeFirst method, of class LinkedList.
     */
    @Test
    public void testRemoveFirst() {
        LinkedList arrayTest = new LinkedList();
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
     * Test of insert method, of class LinkedList.
     */
    @Test
    public void testInsert() {
        LinkedList arrayTest = new LinkedList();
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
     * Test of set method, of class LinkedList.
     */
    @Test
    public void testSet() {
        LinkedList arrayTest = new LinkedList();
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
     * Test of isEmpty method, of class LinkedList.
     */
    @Test
    public void testIsEmpty() {
        LinkedList arrayTest = new LinkedList();
        arrayTest.addFirst(4);
        assertEquals(false, arrayTest.isEmpty());
        arrayTest.removeFirst();
        assertEquals(true, arrayTest.isEmpty());
    }

    /**
     * Test of get method, of class LinkedList.
     */
    @Test
    public void testGet() {
        LinkedList arrayTest = new LinkedList();
        arrayTest.addLast(1);
        arrayTest.addLast(45);
        arrayTest.addLast(expectedValue);
        arrayTest.addLast(22);
        assertEquals(expectedValue, arrayTest.get(2));
    }

    /**
     * Test of contains method, of class LinkedList.
     */
    @Test
    public void testContains() {
        LinkedList arrayTest = new LinkedList();
        arrayTest.addLast(expectedValue);

        assertAll("contains",
                () -> assertEquals(true, arrayTest.contains(expectedValue)),
                () -> assertEquals(false, arrayTest.contains(1000)),
                () -> assertEquals(false, arrayTest.contains(null))
        );
    }

    /**
     * Test of remove method, of class LinkedList.
     */
    @Test
    public void testRemove() {
        LinkedList arrayTest = new LinkedList();
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
