package reflection;

@MyAnnotation(value="hi")
public class Animals extends Creature<String> implements Comparable<String>,MyInterface{

    private String name;
    int age;
    public int id;
    public Animals(){}
    @MyAnnotation
    private Animals(String name) {
        this.name = name;
    }

    public Animals(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @MyAnnotation
    private String show(String nation){
        System.out.println("国籍");
        return nation;
    }

    public String display(String ins){
        return ins;
    }
    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("我是动物");
    }
}
