import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {

  private Utilities util;

  @BeforeEach
  public void setUp() {
     util = new Utilities();
  }

  @Test
  public void everyNthChar() {
    char[] output = util.everyNthChar(new char[] {'h', 'e', 'l', 'l', 'o'}, 2);
    assertArrayEquals(new char[] { 'e', 'l' }, output);
    char[] output2 = util.everyNthChar(new char[] {'h', 'e', 'l', 'l', 'o'}, 8);
    assertArrayEquals(new char[] {'h', 'e', 'l', 'l', 'o'}, output2);
  }

  @Test
  public void removePairs() {
    assertEquals("ABCDEF", util.removePairs("AABCDDEFFF"));
    assertEquals("ABCABDEF", util.removePairs("ABCCABDEEF"));
    assertNull(util.removePairs(null), "Did not get null returned when argument apssed was null");
    assertEquals("A", util.removePairs("A"));
    assertEquals("", util.removePairs(""));
  }

  @Test
  public void converter() {
    assertEquals(300, util.converter(10, 5));
  }

  @Test
  public void converter_arithmeticException() throws Exception {
    assertThrows(ArithmeticException.class, () -> {
      util.converter(10, 0);
    });
  }

  @Test
  public void nullIfOddLength() {
    assertNull(util.nullIfOddLength("odd"));
    assertNotNull(util.nullIfOddLength("even"));
  }

  @ParameterizedTest(name = "파라미터 테스트")
  @CsvSource(value = {"ABCDEFF:ABCDEF", "AB88EFFG:AB8EFG", "112233445566:123456", "A:A"}, delimiter = ':')
  public void aa(String input, String expected) {
    assertEquals(expected, util.removePairs(input));
  }
}
