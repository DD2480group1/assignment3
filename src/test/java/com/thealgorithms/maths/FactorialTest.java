package com.thealgorithms.maths;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {
    // Testing the factorial function
    @Test
    void factorialTest(){
        Long answer = Factorial.factorial(5);
        assertEquals(120, answer);
    }

    // Testing the Exception that function won't return an answer for negative answers
    @Test
    void testException() throws Exception{
        Factorial.factorial(-15);
    } 
}