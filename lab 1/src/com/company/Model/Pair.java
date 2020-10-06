package com.company.Model;

public class Pair<T, T1> {
    private T object1;
    private T1 object2;

    public Pair(T t, T1 t1){
        this.object1 = t;
        this.object2 = t1;
    }

    public void setObject1(T newObject){
        this.object1 = newObject;
    }

    public void setObject2(T1 newObject){
        this.object2 = newObject;
    }

    public T getObject1(){
        return this.object1;
    }

    public T1 getObject2(){
        return this.object2;
    }


}
