public class Test {
    //饿汉式
    private String name;
    private Test(){
    }
    private static Test test = new Test();

    public static Test getTest() {
        return test;
    }
}
