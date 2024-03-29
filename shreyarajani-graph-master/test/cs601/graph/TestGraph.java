package cs601.graph;

import junit.framework.TestCase;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class TestGraph extends TestCase {
	String edges =
		"110 -> 112\n" +
		"112 -> 210\n" +
		"110 -> 220\n" +
		"112 -> 245\n" +
		"210 -> 315\n" +
		"245 -> 315\n" +
		"210 -> 326\n" +
		"220 -> 326\n" +
		"245 -> 326\n" +
		"112 -> 336\n" +
		"245 -> 336\n" +
		"245 -> 342\n" +
		"112 -> 345\n" +
		"245 -> 345\n" +
		"210 -> 414\n" +
		"245 -> 414\n" +
		"342 -> 490\n" +
		"498\n";

	public void testPrint() throws IOException {
		String g =
			"110 -> 112\n" +
			"112 -> 326\n" +
			"print\n";
		StringReader in = new StringReader(g);
		String found = exec(in);
		String expecting =
			"Graph:\n" +
			"110 -> 112\n" +
			"112 -> 326\n";
		assertEquals(expecting, found);
	}

	public void testLen() throws IOException {
		String g =
			"110 -> 112\n" +
			"112 -> 326\n" +
			"len 110 326\n";
		StringReader in = new StringReader(g);
		String found = exec(in);
		String expecting =
			"len 110 -> 326 = 2\n";
		assertEquals(expecting, found);
	}

    public void testLen1() throws IOException {
        String g =
                "110 -> 112\n" +
                        "112 -> 345\n" +
                        "len 110 345\n";
        StringReader in = new StringReader(g);
        String found = exec(in);
        String expecting =
                "len 110 -> 345 = 2\n";
        assertEquals(expecting, found);
    }

	public void testNodes() throws IOException {
		String g = edges+"nodes 110 336\n";
		StringReader in = new StringReader(g);
		String found = exec(in);
		String expecting =
			"nodes 110 -> 336 = [110, 112, 245, 336]\n";
		assertEquals(expecting, found);
	}

	public void testReach() throws IOException {
		String g = edges+"reach 210\n";
		StringReader in = new StringReader(g);
		String found = exec(in);
		String expecting =
			"reach 210 = [210, 315, 326, 414]\n";
		assertEquals(expecting, found);
	}

	public void testRoots() throws IOException {
		String g = edges+"roots\n";
		StringReader in = new StringReader(g);
		String found = exec(in);
		String expecting =
			"roots = [110, 498]\n";
		assertEquals(expecting, found);
	}

	public static String exec(Reader in) throws IOException {
		Lexer lex = new Lexer(in);
		Parser parser = new Parser(lex);
		String output = parser.prog();
		return output;
	}
}
