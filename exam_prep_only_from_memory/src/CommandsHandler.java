import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class CommandsHandler implements Runnable {
    private Socket socket;
    private ExecutorService pool;

    public CommandsHandler(Socket socket, ExecutorService pool) {
        this.socket = socket;
        this.pool = pool;
    }

    @Override
    public void run() {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)){

            String command = bufferedReader.readLine();
            if (command == null || command.trim().isEmpty()) return;

            String[] current = command.split(" ");
            String action = current[0].toUpperCase();

            switch (action){
                case "PRICE":
                    String targetId = current[1];
                    int noDays = Integer.parseInt(current[2]);

                    pool.execute(() ->{
                       Vehicle found = TCPServerCommands.globalInventory.stream().filter(v->v.getId().equals(targetId))
                               .findFirst().orElse(null);

                       if (found != null){
                           float totalPrice = found.getPrice() * noDays;
                           writer.println("Total price for " + targetId + ": " + totalPrice + " EUR");
                       }
                    });
                    break;
                case "TOP":
                    int limit = Integer.parseInt(current[1]);
                    pool.execute(()->{
                        List<Vehicle> top = TCPServerCommands.globalInventory.stream()
                                .sorted((v1,v2)-> Float.compare(v2.getMileage(), v1.getMileage()))
                                .limit(limit)
                                .toList();
                        writer.print("Top " + limit + " rented cars by mileage: ");
                        for (Vehicle v : top){
                            writer.println(v.getMake() + " " + v.getModel() + " " + v.getMileage() + "km");
                        }
                    });
                    break;
                case "AVAILABLE":
                    String targetCity = current[1];
                    pool.execute(() ->{
                       List<Vehicle> availableInCity = TCPServerCommands.globalInventory.stream()
                               .filter(v->v.getCity().equalsIgnoreCase(targetCity))
                               .toList();
                       writer.println("Cars available in " + targetCity + ":");
                       for(Vehicle v : availableInCity){
                           writer.println(v.getId() + " " + v.getMake() + " " + v.getModel());
                       }
                    });
                    break;
                default:
                    writer.println("ERROR: INVALID COMMAND.");
                    break;
            }
            Thread.sleep(200);


        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        } finally{
            try{
                socket.close();
                } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
