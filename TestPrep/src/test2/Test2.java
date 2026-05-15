package test2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.HashMap;

public class Test2 {
    public static void main(String[] args) {
        HashMap<String, Bodybuilder> collection = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/input/input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null){
                String[] current = line.split(":");
                String name = current[0];
                int weight = Integer.parseInt(current[1]);
                int liftedWeight = Integer.parseInt(current[2]);
                int reps = Integer.parseInt(current[3]);

                Bodybuilder individual = new Bodybuilder(name, weight, liftedWeight, reps);

                if (collection.containsKey(name)){
                    if (liftedWeight > collection.get(name).getLiftedWeight()){
                        individual.notify(System.currentTimeMillis());
                        collection.put(name, individual);
                    }
                }
                else{
                    collection.put(name, individual);
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (Bodybuilder b : collection.values()){
            System.out.println(b);
        }

        System.out.println("___Heavy lifters___");

        collection.values().stream().filter(Calculator::hasLiftedThreshold).forEach(System.out::println);



    }
}
