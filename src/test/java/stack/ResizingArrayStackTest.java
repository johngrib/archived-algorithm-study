package stack;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("ResizingArrayStack 클래스")
class ResizingArrayStackTest {
  @Test
  void test() {
    ResizingArrayStack<String> stack = new ResizingArrayStack<>();
    stack.push("to");
    stack.push("be");
    stack.push("or");
    stack.push("not");
    stack.push("to");
    assertEquals(stack.size(), 5);
    assertEquals("to", stack.pop());

    stack.push("be");
    assertEquals("be", stack.pop());
    assertEquals("not", stack.pop());

    stack.push("that");
    assertEquals("that", stack.pop());
    assertEquals("or", stack.pop());
    assertEquals("be", stack.pop());

    stack.push("is");
    assertEquals(2, stack.size());
  }
}