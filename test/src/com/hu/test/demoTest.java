package com.hu.test;

import java.io.InputStream;

import com.hu.proper.BeanFactory;
import org.junit.Test;

import java.io.File;
import java.util.*;

public class demoTest {

    @Test
    public void demo() {
        HashMap<Integer, Student> map = new HashMap<>();
        map.put(1003, new Student(1003, "Sam"));
        map.put(1005, new Student(1005, "Joseph"));
        map.put(1001, new Student(1001, "Kate"));
        map.put(1002, new Student(1002, "Miranda"));
        map.put(1004, new Student(1004, "Peter"));
        HashMap<Integer, Student> integerStudentHashMap = sortHashMap(map);
        System.out.println("integerStudentHashMap = " + integerStudentHashMap);

    }

    public HashMap<Integer, Student> sortHashMap(HashMap<Integer, Student> map) {
        //從HashMap中恢復entry集合，得到全部的鍵值對集合
        Set<Map.Entry<Integer, Student>> entey = map.entrySet();
        //將Set集合轉為List集合，為了實用工具類的排序方法
        List<Map.Entry<Integer, Student>> list = new ArrayList<Map.Entry<Integer, Student>>(entey);
        //使用Collections工具類對list進行排序
        Collections.sort(list, new Comparator<Map.Entry<Integer, Student>>() {
            @Override
            public int compare(Map.Entry<Integer, Student> o1, Map.Entry<Integer, Student> o2) {
                //按照age倒敘排列
                return o1.getKey() - o2.getKey();
            }
        });
        //創建一個HashMap的子類LinkedHashMap集合
        LinkedHashMap<Integer, Student> linkedHashMap = new LinkedHashMap<Integer, Student>();
        //將list中的數據存入LinkedHashMap中
        for (Map.Entry<Integer, Student> entry : list) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        return linkedHashMap;
    }

    @Test
    public void demo2() {
        File file = new File("C:/0/1/2");
        file.mkdirs();
    }
    @Test
    public void demo3() {
        File file = new File("C:/0");
        deleteFile(file);
    }

    public void deleteFile(File file) {
        System.out.println("file = " + file);
        if (file.isFile()) {
            file.delete();
        } else {
            File[] files = file.listFiles();
            if (files ==null){
                file.delete();
            }else{
                for (File file1 : files) {
                    deleteFile(file1);
                }
                file.delete();
            }

        }
    }

    @Test
    public void demo4() {
        Student student = (Student) BeanFactory.getBean("Student");
        System.out.println("student = " + student);
    }

    @Test
    public void demo5() throws Exception{
        Object object =  Class.forName("com.hu.test.Student").newInstance();
        System.out.println("object = " + object);
    }
}
