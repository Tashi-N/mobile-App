package com.example.calculation;

import androidx.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
@SmallTest
public class ExampleUnitTest {
    private calcu mcal;
    @Before
    public void setUp(){
         mcal =new calcu();
    }
    @Test
    public void addNumbers(){
        double result=mcal.add(1d,2d);
        assertThat(result, is(equalTo(3d)));
    }
    @Test
    public  void addNumbersNegative(){
        double result=mcal.add(-1d,2d);
        assertThat(result, is(equalTo(1d)));
    }

    @Test
    public void addNumbersfloating(){
        double result=mcal.add(1.111f,2.222d);
        assertThat(result, is(closeTo(3.333,0.01)));
    }

    @Test
    public  void subtraction(){
        double result=mcal.sub(1d,2d);
        assertThat(result, is(equalTo(-1d)));
    }

    @Test
    public  void subNegative(){
        double result=mcal.sub(2d,-2d);
        assertThat(result, is(equalTo(4d)));
    }

    @Test
    public  void multiply(){
        double result=mcal.mul(1d,2d);
        assertThat(result, is(equalTo(2d)));
    }

    @Test
    public  void multiplyZero(){
        double result=mcal.mul(0d,2d);
        assertThat(result, is(equalTo(0d)));
    }

    @Test
    public  void division(){
        double result=mcal.div(4d,2d);
        assertThat(result, is(equalTo(2d)));
    }

    @Test
    public  void divisionZero(){
        double result=mcal.div(0d,2d);
        assertThat(result, is(equalTo(0d)));
    }




}

