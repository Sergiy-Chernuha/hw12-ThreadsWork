import global.goit.Chronometer;
import global.goit.NumberArrayModifier;

public class Main {
    public static void main(String[] args) throws Exception {
////_____________first exercise___________
//        Chronometer.startChronometer(50);

//        _______________

        NumberArrayModifier numberModifier= new NumberArrayModifier(15);
Thread.sleep(500);
        System.out.println(numberModifier.buildModifiedString());
        System.out.println("end ");

    }
}
