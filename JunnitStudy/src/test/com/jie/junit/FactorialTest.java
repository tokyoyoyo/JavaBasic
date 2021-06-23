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
* @since <pre>6�� 22, 2021</pre> 
* @version 1.0 
*/ 
public class FactorialTest { 

@Before
public void before() throws Exception {

    System.out.println("׼������");
} 

@After
public void after() throws Exception {

    System.out.println("�������");
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



@Disabled           //����@Disabled��JUnit��Ȼʶ������Ǹ����Է�����ֻ����ʱ�����С������ڲ��Խ������ʾ��
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
        ��������

            ֻ����Java 9����߰汾ִ�еĲ��ԣ����Լ���@DisabledOnJre(JRE.JAVA_8)
            ����Windowsƽִ̨�еĲ��ԣ����Լ���@DisabledOnOs(OS.WINDOWS)
            ֻ����64λ����ϵͳ��ִ�еĲ��ԣ�������@EnabledIfSystemProperty�жϣ�
            ��Ҫ���뻷������DEBUG=true����ִ�еĲ��ԣ�������@EnabledIfEnvironmentVariable


 */