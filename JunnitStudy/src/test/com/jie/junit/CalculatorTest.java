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
* @since <pre>6�� 22, 2021</pre> 
* @version 1.0 
*/ 
public class CalculatorTest {

    Calculator calculator;


@Before
public void before() throws Exception {

    //����ʵ����������@BeforeEach�г�ʼ������@AfterEach������
    // �����ڸ���@Test�����л���Ӱ�죬��Ϊ�ǲ�ͬ��ʵ����

    //���ھ�̬��������@BeforeAll�г�ʼ������@AfterAll������
    // �����ڸ���@Test�����о���Ψһʵ������Ӱ�����@Test������

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
