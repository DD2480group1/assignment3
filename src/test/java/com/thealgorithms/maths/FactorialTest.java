package com.thealgorithms.maths;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;



public class FactorialTest {
    // Testing the factorial function
    @Test
    void factorialTest(){
        Long answer = Factorial.factorial(5);
        assertEquals(120, answer);
    }

    // Testing the Exception that function won't return an answer for negative number
    @Test
    public void testException1()  {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Factorial.factorial(-15);
            }
        });
    }


}