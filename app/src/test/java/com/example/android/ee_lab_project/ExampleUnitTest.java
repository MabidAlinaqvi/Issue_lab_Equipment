package com.example.android.ee_lab_project;


import com.example.android.ee_lab_project.Controller.S_search_component;
import com.example.android.ee_lab_project.Controller.issue_adapter;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
        S_search_component s_search_component;



 @Before
 public void setup()
 {  //S_search_component
     s_search_component=new S_search_component();
     s_search_component.list1=new ArrayList<>();
     s_search_component.list5=new ArrayList<>();
     s_search_component.list4=new ArrayList<>();
     for(int i=0;i<10;i++)
     {
         s_search_component.list1.add(i+"");
         s_search_component.list5.add(10-i+"");
         s_search_component.list4.add(i+"");
     }

 }
 //S_search_component testing
 //tesing list1
    @Test
    public void list_length() throws Exception {
        assertEquals(10, s_search_component.list1.size());
    }
    @Test
    public void valueAtnine() throws Exception{
     assertEquals(9+"",s_search_component.list1.get(9));
    }
//testing list5
    @Test
    public void list_leng() throws Exception{
     assertEquals(10,s_search_component.list5.size());
    }
    @Test
    public void fifthIndexVaue() throws Exception
    {
        assertEquals(5+"",s_search_component.list5.get(5));
    }
//tesing list4
    @Test
    public void list4_lenth() throws Exception{
    assertEquals(10,s_search_component.list5.size());
    }
    @Test
    public void fourthIndexVaue() throws Exception
    {
        assertEquals(6+"",s_search_component.list5.get(4));
    }

}