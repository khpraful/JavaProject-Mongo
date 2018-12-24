package com.mongo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;

public class mongoDbTest {

	public static void main(String args[]) throws Exception {
		try {
			MongoClient mongoClient = new MongoClient("18.224.7.9", 27017);
			/*
			 * MongoClient mongoClient = new MongoClient(Arrays.asList( new
			 * ServerAddress("52.14.184.1", 27017), new
			 * ServerAddress("18.222.203.6", 27017), new
			 * ServerAddress("18.218.3.255", 27017)));
			 */
			/*
			 * MongoClient mongoClient = new MongoClient( new MongoClientURI(
			 * "mongodb://18.217.204.80:27017,18.188.219.160:27017,3.16.89.104:27017/?replicaSet=mongodb-rs"
			 * ));
			 */

			/*List<ServerAddress> addr = new ArrayList<ServerAddress>();
			addr.add(new ServerAddress("13.59.173.78", 27017));
			addr.add(new ServerAddress("18.224.7.9", 27017));
			addr.add(new ServerAddress("18.223.2.136", 27017));
			System.out.println(addr);
			MongoClient mongoClient = new MongoClient(addr);*/

			DB db = mongoClient.getDB("testdb");
			DBCollection col = db.getCollection("testCollection");
			DBCursor cursor = col.find();
			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}
			mongoClient.close();

		} catch (Exception e) {
			System.out.println(e);

		}

	}

}
