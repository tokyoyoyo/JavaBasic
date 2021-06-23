package test.com.jie.junit;

import com.jie.junit.Calculator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/** 
* Calculator Tester. 
* 
* @author <Authors name> 
* @since <pre>6月 22, 2021</pre> 
* @version 1.0 
*/ 
public class CalculatorTest {

    Calculator calculator;


@Before
public void before() throws Exception {

    //对于实例变量，在@BeforeEach中初始化，在@AfterEach中清理，
    // 它们在各个@Test方法中互不影响，因为是不同的实例；

    //对于静态变量，在@BeforeAll中初始化，在@AfterAll中清理，
    // 它们在各个@Test方法中均是唯一实例，会影响各个@Test方法。

    this.calculator = new Calculator();
    System.out.println("1");
} 

@After
public void after() throws Exception {



    this.calculator = null;
    System.out.println("2");
} 

/** 
* 
* Method: add(long x) 
* 
*/ 
@Test
public void testAdd() throws Exception { 
//TODO: Test goes here...
    assertEquals(100, this.calculator.add(100));
    assertEquals(150, this.calculator.add(50));
    assertEquals(130, this.calculator.add(-20));
} 

/** 
* 
* Method: sub(long x) 
* 
*/ 
@Test
public void testSub() throws Exception { 
//TODO: Test goes here...
    assertEquals(-100, this.calculator.sub(100));
    assertEquals(-150, this.calculator.sub(50));
    assertEquals(-130, this.calculator.sub(-20));
}


} 
