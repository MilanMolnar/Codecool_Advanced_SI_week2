package com.codecool.thehistory;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestTheHistoryCorrectness {
    private TheHistory theHistory;

    public TestTheHistoryCorrectness(String name) {
        switch (name) {
            case "Array":
                theHistory = new TheHistoryArray();
                break;
            case "ArrayList":
                theHistory = new TheHistoryArrayList();
                break;
            case "LinkedList":
                theHistory = new TheHistoryLinkedList();
                break;
        }
    }

    @Parameterized.Parameters(name = "{0}")
    public static Collection data() {
        return Arrays.asList(new String[] { "Array", "ArrayList", "LinkedList" });
    }

    @Test
    public void add__simple() {
        theHistory.add("abc def ghi");
        assertEquals("abc def ghi", theHistory.toString());
        theHistory.add("x y z w");
        assertEquals("abc def ghi x y z w", theHistory.toString());
    }

    @Test
    public void add__multipleSpaces() {
        theHistory.add("multiple    spaces");
        assertEquals("multiple spaces", theHistory.toString());
        assertEquals(2, theHistory.size());
    }

    @Test
    public void add__otherWhitespace() {
        theHistory.add("newlines\nand tabs\ttoo");
        assertEquals("newlines and tabs too", theHistory.toString());
        assertEquals(4, theHistory.size());
    }


    @Test
    public void size() {
        assertEquals(0, theHistory.size());
        theHistory.add("abc def ghi");
        assertEquals(3, theHistory.size());
    }

    @Test
    public void clear() {
        theHistory.add("abc def ghi");
        assertNotEquals("", theHistory.toString());

        theHistory.clear();
        assertEquals("", theHistory.toString());
    }

    @Test
    public void replaceOneWord__simple() {
        theHistory.add("abc def ghi abc def ghi");
        theHistory.replace("abc", "ABC");
        theHistory.replace("def", "DEF");
        assertEquals("ABC DEF ghi ABC DEF ghi", theHistory.toString());
    }

    @Test
    public void replaceOneWord__partOfWordOnly() {
        theHistory.add("carpet car motorcar Nicaragua");
        theHistory.replace("car", "AUTOMOBILE");
        assertEquals("carpet AUTOMOBILE motorcar Nicaragua", theHistory.toString());
    }

    @Test
    public void removeWord__found() {
        theHistory.add("hello world hello hello world");
        theHistory.removeWord("hello");
        assertEquals("world world", theHistory.toString());
    }

    @Test
    public void removeWord__notFound() {
        theHistory.add("hello world hello hello world");
        theHistory.removeWord("x");
        assertEquals("hello world hello hello world", theHistory.toString());
    }

    @Test
    public void replaceMoreWords__equal() {
        theHistory.add("replace me replace me me replace me");
        theHistory.replace("replace me", "HAPPY FUN");
        assertEquals("HAPPY FUN HAPPY FUN me HAPPY FUN", theHistory.toString());
    }

    @Test
    public void replaceMoreWords__insert() {
        theHistory.add("x y z x y z w");
        theHistory.replace("x y", "X X Y Y");
        assertEquals("X X Y Y z X X Y Y z w", theHistory.toString());
    }

    @Test
    public void replaceMoreWords__delete() {
        theHistory.add("x y z x y z w");
        theHistory.replace("x y", "XY");
        assertEquals("XY z XY z w", theHistory.toString());
    }

    @Test
    public void replaceMoreWords__notFound() {
        theHistory.add("replace me replace me me replace me");
        theHistory.replace("replace replace me", "HAPPY FUN");
        assertEquals("replace me replace me me replace me", theHistory.toString());
    }

    @Test
    public void replaceMoreWords__multipleRuns() {
        theHistory.add("x x x y x x x x y x x");
        theHistory.replace("x x", "XX");
        assertEquals("XX x y XX XX y XX", theHistory.toString());
    }

    @Test
    public void replaceMoreWords__everything() {
        String text = "this is the text that I would like to be replaced";
        theHistory.add(text);
        theHistory.replace(text, "everything");
        assertEquals("everything", theHistory.toString());
    }

    @Test
    public void replaceMoreWords__endOfString() {
        theHistory.add("end of string end of");
        theHistory.replace("end of string", "END OF STRING");
        assertEquals("END OF STRING end of", theHistory.toString());
    }

    @Test
    public void replaceMoreWords__extendPart() {
        theHistory.add("Il Pet Il Pet");
        theHistory.replace("Il", "Pet Il");
        assertEquals("Pet Il Pet Pet Il Pet", theHistory.toString());
    }

    @Test
    public void replaceMoreWords__partOfWordOnly() {
        theHistory.add("foo bar baz");

        theHistory.replace("o b", "X");
        assertEquals("foo bar baz", theHistory.toString());

        theHistory.replace("foo b", "X");
        assertEquals("foo bar baz", theHistory.toString());

        theHistory.replace("o bar", "X");
        assertEquals("foo bar baz", theHistory.toString());

        theHistory.replace("o bar b", "X");
        assertEquals("foo bar baz", theHistory.toString());
    }
}