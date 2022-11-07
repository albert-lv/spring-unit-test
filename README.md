# Spring-Unit-Test

Programmers often ignore the unit tests of the interception layer, like ignoring the elephant in the room, 
but changes in the interception layer are often fatal.

So here I will show you how to construct suitable unit tests for Filter, Interceptor and Spring AOP.

**Think in depth: We should write codes which is easy to test.**

In the interception layer, we need to extract codes of the core logic to single method which is easy to test. 
Then we don't need to write complicated unit tests of the interception layer.


**Direct links**

* [Filter](https://github.com/albert-lv/Spring-Unit-Test/blob/4cf5398c4fa2964a984fcbff7ff2a2862a416468/src/test/java/study/albert/spring/unit/test/filter/CustomerFilterTest.java)
* [Interceptor](https://github.com/albert-lv/Spring-Unit-Test/blob/4cf5398c4fa2964a984fcbff7ff2a2862a416468/src/test/java/study/albert/spring/unit/test/interceptor/CustomerInterceptorTest.java)
* [Spring AOP](https://github.com/albert-lv/Spring-Unit-Test/blob/4cf5398c4fa2964a984fcbff7ff2a2862a416468/src/test/java/study/albert/spring/unit/test/aop/CustomerAspectTest.java)
