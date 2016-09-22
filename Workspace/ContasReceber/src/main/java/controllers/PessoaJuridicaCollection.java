package controllers;

import java.net.UnknownHostException;
import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import model.PessoaJuridica;

public class PessoaJuridicaCollection {

	public void createPessoaJuridica(PessoaJuridica pessoa) throws UnknownHostException{

		BasicDBObject pessoaJuridica = new BasicDBObject();
		pessoaJuridica.put("nomeFantasia", pessoa.getNomeFantasia());
		pessoaJuridica.put("cnpj", pessoa.getCnpj());

		try{     

			MongoClientURI uri; 
			uri = new MongoClientURI("mongodb://eduardodesaa:senhasenha@ds017256.mlab.com:17256/projetoproweb");
			MongoClient client = new MongoClient(uri);
			DB db = client.getDB(uri.getDatabase());

			DBCollection financeiro = db.getCollection("pessoaJuridica");
			financeiro.insert(pessoaJuridica);
		}catch(Exception e){
			System.out.print("Deu ruim! "+e);
		}
	}

	public static ArrayList<PessoaJuridica> getPessoaJuridica() throws UnknownHostException{
		DBObject docsDBObject = null;
		ArrayList<PessoaJuridica> listPessoaJuridica = new ArrayList<PessoaJuridica>();
		PessoaJuridica pessoaJuridica = new PessoaJuridica();
		try{     

			MongoClientURI uri; 
			uri = new MongoClientURI("mongodb://eduardodesaa:senhasenha@ds017256.mlab.com:17256/projetoproweb");
			MongoClient client = new MongoClient(uri);
			DB db = client.getDB(uri.getDatabase());
			DBCollection financeiro = db.getCollection("pessoaJuridica");

			BasicDBObject findQuery = new BasicDBObject();
			DBCursor docs = financeiro.find(findQuery);

			while(docs.hasNext()){
				docsDBObject = docs.next();
				pessoaJuridica.setNomeFantasia(docsDBObject.get("nomeFantasia").toString());
				pessoaJuridica.setCnpj(docsDBObject.get("cnpj").toString());
				listPessoaJuridica.add(pessoaJuridica);
				pessoaJuridica = new PessoaJuridica();
			}

		}catch(Exception e){
			System.out.print("Deu ruim! "+e);
		}

		return listPessoaJuridica;
	}

}
