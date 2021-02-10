package com.tata.storeapp.tests;

import com.google.common.base.Strings;
import com.tata.storeapp.facades.CustomArgumentsProvider;
import com.tata.storeapp.facades.StringArgumentConverter;
import com.tata.storeapp.models.Transaction;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.*;

import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TransactionTypeTest {
    @ParameterizedTest
    @EnumSource(value = com.tata.storeapp.models.TransactionType.class, names = { "CARD", "WALLET","UPI" })
    void testWithEnumSourceTransactionTypeInclude(com.tata.storeapp.models.TransactionType transactionType) {
        assertTrue(EnumSet.of(com.tata.storeapp.models.TransactionType.CARD, com.tata.storeapp.models.TransactionType.WALLET, com.tata.storeapp.models.TransactionType.UPI).
                contains(transactionType));
    }

    @ParameterizedTest
    @NullSource
   // @MethodSource("stringProvider")
    void isBlank_ShouldReturnTrueForNullInputs(String input) {

        assertTrue(Strings.isNullOrEmpty(input));
    }

    @ParameterizedTest(name="#{index} - Test with Argument={0}")
    @NullSource
    void test_null_source(String arg) {

        System.out.println("arg => "+arg);
        assertTrue(arg == null);
    }

    @ParameterizedTest(name="#{index} - Test with Argument={0}")
    @EmptySource
    void test_empty_source(String arg) {

        System.out.println("arg => "+arg);
        assertTrue(arg.isEmpty());
    }

    @ParameterizedTest
    @EnumSource(value = Month.class, names = {"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"})
    void someMonths_Are30DaysLong(Month month) {
        final boolean isALeapYear = false;
        assertEquals(30, month.length(isALeapYear));
    }

    static Stream<Arguments> arguments = Stream.of(
            Arguments.of(null, true)// null strings should be considered blank

    );

    @ParameterizedTest
    @MethodSource("stringProvider")
    void testWith_MethodSource(String arg) {
        System.out.println("testWith_MethodSource(arg) => "+arg);
        assertNotNull(arg);
    }

    @ParameterizedTest
    @MethodSource
    void testWith_Default_local_MethodSource(String arg) {
        System.out.println("testWith_Default_local_MethodSource(arg) => "+arg);
        assertNotNull(arg);
    }



    static Stream<String> stringProvider() {

        return Stream.of("admin", "subscriber", "author","anonymous");
    }

    static Stream<String> testWith_Default_local_MethodSource() {
        return Stream.of("Peter", "Philip", "John");
    }

    @ParameterizedTest
    @MethodSource("stringIntAndListProvider")
    void testWithMultiArgMethodSource(String str, int length, List<String> list) {
        assertTrue(str.length() > 0);
        assertEquals(length, list.size());
    }

    static Stream<Arguments> stringIntAndListProvider() {
        return Stream.of(
                arguments("abc", 3, Arrays.asList("a", "b", "c")),
                arguments("lemon", 2, Arrays.asList("x", "y"))
        );
    }

    @ParameterizedTest
    @ArgumentsSource(CustomArgumentsProvider.class)
    void test_argument_custom(Transaction arg) {

       assertTrue(arg.getAmount()>0);
    }

    @ParameterizedTest
    @EnumSource(ChronoUnit.class)
    void testCaseWithExplicitArgumentConversion(
            @ConvertWith(StringArgumentConverter.class) String arg) {

        assertNotNull(ChronoUnit.valueOf(arg));
    }

}
