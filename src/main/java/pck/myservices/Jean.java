package pck.myservices;

import pck.Service;

@Service(msgReq = "jeanReq", msgResp = "jeanResp")
public class Jean extends AbsMyService {

    public Jean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void process() {
        System.out.println("hello from jean ::::" + age + "::::" + name);
    }
}
