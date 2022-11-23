package serialization;

import java.io.*;
import java.util.Calendar;

public class DeserializeTime {

    public static void main(String[] args) {

        String filename = "time.ser";
        if (args.length > 0) {
            filename = args[0];
        }

        // Deserialize the previously save PersistentTime object instance.
        PersistentTime time = null;
        FileInputStream fis = null;
        ObjectInputStream in = null;

        try {
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);
            time = (PersistentTime) in.readObject();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // print out the restored time
        System.out.println("Previously stored time:  " + time.getTime());

        // print out the current time
        System.out.println("Current time:  " + Calendar.getInstance().getTime());
    }
}
