public class Worker implements Workable, Eatable{
    public void eat() {
        System.out.println("I'm on my break now. Don't disturb me!");
    }
    public void work() {
        System.out.println("Anything task you want me to do?");
        String answer = System.console().readLine();
        if(!answer.equalsIgnoreCase("no")){
            System.out.println("Okay, I will work on that too");
        }
    }
}
