package com.kuzi.core.microservice.studies;

import com.kuzi.core.microservice.entity.User;
import com.kuzi.core.microservice.repository.UserRepository;
import com.kuzi.core.microservice.service.TestCasesService;
import com.kuzi.core.microservice.service.UserService;
import junitparams.JUnitParamsRunner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.reflect.Whitebox;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class CommonTestCases {

  /*
  Common Annotations
    - assertEquals
    - assertTrue
    - assertNull
    - assertSame
    - assertArrayEquals
    - Mock - InjectMock - When - ThenReturn
    - Mock - Stub and Spies ?
    - assertThat().isEqualTo()...
    - assertThat().isTrue() - isFalse() - isNull() - isNotNull() - hasSameClass() - hasSameHashCode()
    - @Before - @BeforeAll - @BeforeEach - @After
    - @Rule
    - anyString() or any() - this is for generalize argument
    - thenReturn() readibility/type check/runtime check/other operation perform - doReturn()
   */



  TestCasesService testCasesService;


  /*
  private static Object[] testValues() {
    return new Object[] {new Object[] {50, 50, 2500}, new Object[] {-10, 50, -1}};
  }

  @BeforeEach
  public void setup() {
    testCasesService = new TestCasesService();
    System.out.println("Called before each method");
  }

  @Test
  public void shouldBeSameUserName() {

    User user = User.builder().firstName("Hakan").build();
    User user_2 = User.builder().firstName("Kuzi").build();

    // Jupiter Api Assertions (assertEquals())
    //  assertEquals(user, user_2); // first (expected) - second (actual)

    assertThat(user).isEqualTo(user_2);
  }

  @ParameterizedTest
  @MethodSource("testValues")
  public void studentScoreCalculator(int mathsScore, int literacyScore, int expectedScore) {
    testCasesService.calculateSATScore(mathsScore, literacyScore);
    assertEquals(expectedScore, testCasesService.getSatScore());
  }

  @Test
  public void validateMethod() {

    IllegalArgumentException exception =
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
              testCasesService.testException();
            });

    assertEquals("Illegal Argument Exception", exception.getMessage());
  }

  @Test // Private Method with Reflection
  public void computeGradeWithReflection()
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

    // Preparing Method
    Class[] parameters = new Class[1];
    parameters[0] = Integer.class;
    Method methodCall = testCasesService.getClass().getDeclaredMethod("computeGrade", parameters);
    methodCall.setAccessible(true);

    // Preparing Value
    Object[] methodArgument = new Object[1];
    methodArgument[0] = 70;
    String actualGrade = (String) methodCall.invoke(testCasesService, methodArgument);
    String expected = "Fail";

    assertEquals(expected, actualGrade);
  }

  @Test
  public void computeGradeWithPowermock() throws Exception {
    String actual = Whitebox.invokeMethod(testCasesService, "computeGrade", 70);
    String expected = "Fail";
    assertEquals(expected, actual);
  }

   */


}
