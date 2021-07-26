/*
 * Copyright (c) 2021 HappyAreaBean
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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
