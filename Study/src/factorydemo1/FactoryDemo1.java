package factorydemo1;
interface Run{
    public void run();
}
class Dog implements Run{
    @Override
    public void run() {
        System.out.println("四条腿跑");
    }
}
class Person implements Run{
    @Override
    public void run() {
        System.out.println("两条腿跑");
    }
}
class Factory{
    public static Run getInstence(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> cls = Class.forName(className);
        return (Run)cls.newInstance();
    }
}
public class FactoryDemo1 {
    public static void main(String args[]){
        Run run = null;
        try {
            run = Factory.getInstence("factorydemo1.Dog");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        run.run();
    }
}
