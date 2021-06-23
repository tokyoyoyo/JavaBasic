package test.com.jie.junit;

import com.jie.junit.Factorial;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/** 
* Factorial Tester. 
* 
* @author <Authors name> 
* @since <pre>6月 22, 2021</pre> 
* @version 1.0 
*/ 
public class FactorialTest { 

@Before
public void before() throws Exception {

    System.out.println("准备测试");
} 

@After
public void after() throws Exception {

    System.out.println("测试完成");
    System.out.println();
} 

/** 
* 
* Method: fact(long n) 
* 
*/ 
@Test
public void testFact() throws Exception {
//TODO: Test goes here...
    assertEquals(1, Factorial.fact(1));
    assertEquals(2, Factorial.fact(2));
    assertEquals(6, Factorial.fact(3));
    assertEquals(3628800, Factorial.fact(10));
    assertEquals(2432902008176640000L, Factorial.fact(20));

}



@Disabled           //加上@Disabled，JUnit仍然识别出这是个测试方法，只是暂时不运行。它会在测试结果中显示：
@Test
public void testNegative() {
    assertThrows(IllegalArgumentException.class, () -> {
        Factorial.fact(-1);
    });
}

@EnabledOnOs({OS.MAC , OS.WINDOWS})
@Test
public void testRange() {
    assertThrows(ArithmeticException.class, () -> {
        Factorial.fact(21);
    });
}



} 

/*
        条件测试

            只能在Java 9或更高版本执行的测试，可以加上@DisabledOnJre(JRE.JAVA_8)
            不在Windows平台执行的测试，可以加上@DisabledOnOs(OS.WINDOWS)
            只能在64位操作系统上执行的测试，可以用@EnabledIfSystemProperty判断：
            需要传入环境变量DEBUG=true才能执行的测试，可以用@EnabledIfEnvironmentVariable


 */