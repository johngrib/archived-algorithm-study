package sedgewick._1_fundamentals;

import java.util.Stack;

/**
 * 산술 표현식 계산을 위한 데이크스트라의 2중 스택 알고리즘.
 * 이 알고리즘은 ( a + b ) 와 같이 연산자 하나와 두 숫자를 괄호로 감싸는 형식의 표현식만 계산할 수 있다.
 * ( a + b + c ) 같은 형태의 표현식은 잘못된 값을 리턴한다.
 */
public class DoubleStack {
  public static double calc(final String expression) {
    final String[] input = expression.split("\\s");
    final Stack<String> operators = new Stack<>();
    final Stack<Double> values = new Stack<>();

    for (String token : input) {
      switch (token) {
        case "+", "-", "*", "/", "sqrt" -> operators.push(token);
        case "(" -> {
          // do nothing
        }
        case ")" -> {
          String op = operators.pop();
          double v = values.pop();
          switch (op) {
            case "+" -> v = values.pop() + v;
            case "-" -> v = values.pop() - v;
            case "*" -> v = values.pop() * v;
            case "/" -> v = values.pop() / v;
            case "sqrt" -> v = Math.sqrt(v);
          }
          values.push(v);
        }
        default -> values.push(Double.parseDouble(token));
      }
    }
    return values.pop();
  }
}
