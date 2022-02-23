package com.thealgorithms.maths;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AverageTest {
    @Test
    void arrayAverageTest(){
        double[] number_array = {1,2,3,4,5};
        double answer = Average.average(number_array);
        assertEquals(3, answer);
    }

    @Test
    void intAverageTest(){
        int[] number_array = {1,2,3,4,5};
        int answer = Average.average(number_array);
        assertEquals(3, answer);
    }

}
