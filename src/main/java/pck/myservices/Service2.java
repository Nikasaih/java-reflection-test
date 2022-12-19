package pck.myservices;

import pck.ServiceAnno;

@ServiceAnno(msgReq = "S2REQ", msgResp = "S2RESP")
public class Service2 extends ServiceAbs {
    public Service2(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public void process() {
        System.out.printf("hello I am %s and I am %d years old%n", name, age);
    }
}
