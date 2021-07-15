package com.example.restfulwebservice.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    // GET
    // /hello-world (endpoint)
    // @RequestMapping(method=RequestMethod.GET, path="/hello-world")
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-been")
    public HelloWorldBeen helloWorldBeen(){
        return new HelloWorldBeen("Hello World");
    }

    @GetMapping(path = "/hello-world-been/path-variable/{name}")
    public HelloWorldBeen helloWorldBeen(@PathVariable String name){
        return new HelloWorldBeen(String.format("HelloWorld, %s", name));
    }
}
