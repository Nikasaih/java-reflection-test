package pck.myservices;

import pck.ServiceAnno;

@ServiceAnno(msgReq = "S1REQ", msgResp = "S1RESP")
public class Service1 extends ServiceAbs {

    public Service1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void process() {
        System.out.printf("hello I am %s and I am %d years old%n", name, age);
    }
}
