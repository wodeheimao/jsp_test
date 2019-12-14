package com.hu.test;

class Student {

    private Integer id;
    private String name;

    Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "[id="+id + ", name=" + name + "]";
    }

}