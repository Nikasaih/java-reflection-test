package pck.myservices;

import pck.Service;

@Service(msgReq = "ReqTest", msgResp = "RespTest")
public class Test extends AbsMyService {
    public Test(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public void process() {
        System.out.println("hello from test  ::::" + age + "::::" + name);
    }
}
