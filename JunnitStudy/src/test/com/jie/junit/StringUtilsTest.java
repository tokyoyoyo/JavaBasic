package test.com.jie.junit;

import com.jie.junit.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/** 
* StringUtils Tester. 
* 
* @author <Authors name> 
* @since <pre>6月 22, 2021</pre> 
* @version 1.0 
*/ 
public class StringUtilsTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
}


@ParameterizedTest
@ValueSource(ints = { 0, 1, 5, 100 })
void testAbs(int x) {
    assertEquals(x, Math.abs(x));
}


@ParameterizedTest
@ValueSource(ints = { -1, -5, -100 })
void testAbsNegative(int x) {
    assertEquals(-x, Math.abs(x));
}


@ParameterizedTest
@MethodSource                   //@MethodSource注解，它允许我们编写一个同名的静态方法来提供测试参数：
void testCapitalize(String input, String result) {
    assertEquals(result, StringUtils.capitalize(input));
}

static List<Arguments> testCapitalize() {

    List<Arguments> list = new ArrayList<>();
    list.add(Arguments.arguments("abc", "Abc"));
    list.add(Arguments.arguments("APPLE", "Apple"));
    list.add(Arguments.arguments("gooD", "Good"));
    return list;
}


@ParameterizedTest
@CsvSource({ "abc, Abc", "APPLE, Apple", "gooD, Good" })
void testCapitalizeCsv(String input, String result) {
    assertEquals(result, StringUtils.capitalize(input));
}


@ParameterizedTest
@CsvFileSource(resources = { "/test/test-capitalize.csv" })
void testCapitalizeUsingCsvFile(String input, String result) {
    assertEquals(result, StringUtils.capitalize(input));
}

} 
