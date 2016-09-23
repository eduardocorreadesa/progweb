package controllers;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class ConnectCollection {

	public static DBCollection connectCollection(String collection){
		DBCollection dbCollection = null;
		try {
			MongoClientURI uri; 
			uri = new MongoClientURI("mongodb://eduardodesaa:senhasenha@ds017256.mlab.com:17256/projetoproweb");
			MongoClient client;
			client = new MongoClient(uri);
			DB db = client.getDB(uri.getDatabase());
			dbCollection = db.getCollection(collection);
		} catch (Exception e) {
			System.out.println("Deu ruim pra conectar no banco! "+e);

		}
		return dbCollection;
	}
}
