package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.example.BoundaryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BoundaryServiceTest {

    @DisplayName("Поиск по пустому массиву")
    @Test
    public void testFindMinEmptyArray() {
        BoundaryService service = new BoundaryService();
        int[] marks = {};
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            service.findMin(marks);
        });
    }

    static Stream<Arguments> provideArraysForMinSearch() {
        return Stream.of(
                Arguments.of("Поиск по массиву с положительными числами", new int[]{5, 3, 8, 6, 2, 4}, 2),
                Arguments.of("Поиск по массиву с отрицательными числами", new int[]{-5, -3, -8, -6, -2, -4}, -8),
                Arguments.of("Поиск по массиву с одним элементом", new int[]{42}, 42)
        );
    }

    @DisplayName("Параметризированный тест поиска минимального значения в массиве")
    @ParameterizedTest(name = "{0}")
    @MethodSource("provideArraysForMinSearch")
    public void testFindMin(String name, int[] marks, int expectedResult) {
        BoundaryService service = new BoundaryService();
        int result = service.findMin(marks);
        assertEquals(expectedResult, result);
    }

}