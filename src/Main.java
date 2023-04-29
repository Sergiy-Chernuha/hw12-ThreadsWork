import global.goit.Chronometer;
import global.goit.NumberArrayModifier;

public class Main {
    public static void main(String[] args) throws Exception {
////_____________first exercise___________
//        Chronometer.startChronometer(50);

//        ________second exercise_______

        NumberArrayModifier numberModifier= new NumberArrayModifier(150);

        System.out.println(numberModifier.buildModifiedString());
        System.out.println("end ");
        System.out.println(Thread.activeCount());
        System.exit(0);
    }
}
