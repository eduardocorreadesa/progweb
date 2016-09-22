/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.net.UnknownHostException;
import com.mongodb.*;
/**
 *
 * @author eduardocorreadesa
 */
public class PessoaJuridica {

	public void createPessoaJuridica(String nomeFantasia, 
			String cnpj) throws UnknownHostException{

		BasicDBObject pessoaJuridica = new BasicDBObject();
		pessoaJuridica.put("nomeFantasia", nomeFantasia);
		pessoaJuridica.put("cnpj", cnpj);

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

}
