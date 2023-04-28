package next.reflection;

public class Junit4Test {
    @MyTest
    public void one() throws Exception {
        System.out.println("Running Test1");
        foo();
    }

    @MyTest
    public void two() throws Exception {
        System.out.println("Running Test2");
        foo();
    }

    public void testThree() throws Exception {
        System.out.println("Running Test3");
    }

    private void foo() throws InterruptedException {
        Thread.sleep(1000);
    }
}
