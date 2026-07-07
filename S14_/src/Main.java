import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document; //important!!!!!!!!!!!!

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

public class Main {
    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase db = mongoClient.getDatabase("Business");
        MongoCollection<Document> collection = db.getCollection("Employees");

        collection.drop();
        Document employee1 = new Document("Name", "John Java")
                .append("Age", 30)
                .append("Salary", 99999)
                .append("Department", "Legal");

        collection.insertOne(employee1);

        List<Document> employees = Arrays.asList(
                new Document("Name", "Bob")
                        .append("Salary", 45960),
                new Document("Name", "Alice")
                        .append("Department", "IT")
                        .append("Subordinates", 3),
                new Document("Name", "Vinny")
                        .append("Salary", 45453)
        );

        collection.insertMany(employees);

        for (Document d : collection.find()) {
            System.out.println(d.toJson());
        }

        for (Document d : collection.find(new Document("Name", "Bob"))){
            System.out.println(d.toJson());
        }

        for(Document d: collection.find(eq("Name", "Vinny"))){
            System.out.println(d.toJson());
        }

        //gte = greater than or equal
        System.out.println("______________________________________");
        for (Document d : collection.find(new Document("Salary", new Document("$gte", 10000)))){
            System.out.println(d.toJson());
        }

        System.out.println("______________________________________");
        //Filters.gte
        for(Document d: collection.find(gte("Salary", 20000)).sort(new Document("Name", 1))){
            System.out.println(d.toJson());
        }

        //aggregates set
        collection.updateOne(new Document("Name", "John Java"), new Document("$set", new Document("Salary", 90000)));
        collection.updateOne(eq("Name", "John Java"), set("Salary", 1000000));
        collection.updateOne(eq("Name", "John Java"),
                combine(set("Salary", 1000000),
                        set("Name", "N/A")));

        collection.deleteOne(new Document("Name", "N/A"));
        collection.deleteOne(eq("Name", "Bob"));

        System.out.println("______________________________________");
        for (Document d : collection.find()) {
            System.out.println(d.toJson());
        }



    }
}
