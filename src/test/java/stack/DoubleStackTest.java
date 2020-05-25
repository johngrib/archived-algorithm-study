package stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("DoubleStack")
class DoubleStackTest {

  @Nested
  @DisplayName("calc 메소드는")
  class Describe_calc {
    @Nested
    @DisplayName("괄호 안에 한 개의 연산자가 있는 표현식이 주어지면")
    class Context_with_normal_case {
      final List<Expression> givenExpressions = List.of(
          new Expression("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )", (1 + ((2 + 3) * (4 * 5)))),
          new Expression("( ( 1 + 2 ) + 3 )", ((1 + 2) + 3)),
          new Expression("( ( 1 + sqrt ( 5.0 ) ) / 2.0 )", ((1 + Math.sqrt(5.0D)) / 2.0D))
      );

      @Test
      @DisplayName("올바른 계산 결과를 리턴한다")
      void it_returns_valid_result() {
        for (var givenExp : givenExpressions) {
          assertEquals(givenExp.result, DoubleStack.calc(givenExp.exp));
        }
      }
    }

    @Nested
    @DisplayName("괄호 안에 두 개 이상의 연산자가 있는 경우")
    class Context_with_two_ops {
      @Test
      @DisplayName("잘못된 계산 결과를 리턴한다")
      void it_returns_invalid_result() {
        double result = DoubleStack.calc("( 1 + 2 + 3 )");
        assertNotEquals(result, (1 + 2 + 3));
      }
    }
  }

  class Expression {
    String exp;
    double result;

    public Expression(String exp, double result) {
      this.exp = exp;
      this.result = result;
    }
  }
}
