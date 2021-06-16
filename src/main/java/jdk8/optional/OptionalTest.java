package jdk8.optional;

import org.junit.Test;

import java.util.Optional;

public class OptionalTest {

    @Test
    public void test1(){
        //of()
        Girl girl = new Girl();
        Optional<Girl> optionalGirl = Optional.of(girl);

        //ofNullable()可以为空
        girl = null;
        Optional<Girl> optionalGirl2 = Optional.ofNullable(girl);
    }

    public String getGirlName(Boy boy){
        return boy.getGirl().getName();
    }
    //Optional优化
    public String getGirlName1(Boy boy){
        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("克里斯汀娜")));

        Girl girl = boy1.getGirl();

        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        Girl girl1 = girlOptional.orElse(new Girl("克里斯蒂娜"));
        return girl1.getName();
    }

    @Test
    public void test2(){
        Boy boy = new Boy();
        String girlName = getGirlName1(boy);
        System.out.println(girlName);
    }
}
