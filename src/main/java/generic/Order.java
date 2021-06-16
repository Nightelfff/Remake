package generic;

import java.util.ArrayList;
import java.util.List;

public class Order<T> {

    String name;
    int id;

    T t;

    public Order(){}

    public Order(String name, int id, T t) {
        this.name = name;
        this.id = id;
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", t=" + t +
                '}';
    }

    public void show(){

    }

    //泛型方法
    public <E> List<E> copy(E[] arr){

        ArrayList<E> list = new ArrayList<>();

        for (E e:arr){
            list.add(e);
        }
        return list;
    }
}
