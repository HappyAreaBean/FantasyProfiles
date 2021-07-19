package cc.happyareabean.fantasyprofiles.databases;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.ConnectionString;
import com.mongodb.ServerAddress;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.UpdateOptions;
import lombok.Getter;
import org.bson.Document;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MongoDB {

	@Getter public MongoClient mongoClient;
	@Getter public MongoDatabase mongoDatabase;
	@Getter public MongoCollection<Document> serverCollection;

	public MongoDB() {
		//Connect to the specified ip and port
		//Default is localhost, 27017
		System.setProperty("DEBUG.GO", "true");
		System.setProperty("DB.TRACE", "true");
		Logger mongoLobber = Logger.getLogger("org.mongodb.driver");
		mongoLobber.setLevel(Level.WARNING);

		MongoCredential credential = MongoCredential.createScramSha256Credential("bean", "admin", "MT$Em_-Pk=7!TzqG5FKpXML%y48Sf#u_".toCharArray());
		mongoClient = MongoClients.create(
				MongoClientSettings.builder()
						.applyToClusterSettings(builder ->
								builder.hosts(Arrays.asList(new ServerAddress("127.0.0.1", 27017))))
						.credential(credential)
						.build());
		mongoDatabase = mongoClient.getDatabase("fantasyprofiles");
		serverCollection = mongoDatabase.getCollection("settings");
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Connected to MongoDB!");
	}
}
