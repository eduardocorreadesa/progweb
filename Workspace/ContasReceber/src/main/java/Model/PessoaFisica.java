/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.net.UnknownHostException;
import com.mongodb.*;
/**
 *
 * @author eduardocorreadesa
 */
public class PessoaFisica {

	public void createPessoaFisica(String nome, 
			String cpf, String dataNascimento, 
			String sexo, String estadoCivil, 
			String conta, String agencia) throws UnknownHostException{

		BasicDBObject pessoaFisica = new BasicDBObject();
		pessoaFisica.put("nome", nome);
		pessoaFisica.put("cpf", cpf);
		pessoaFisica.put("dataNascimento", dataNascimento);
		pessoaFisica.put("sexo", sexo);
		pessoaFisica.put("estadoCivil", estadoCivil);
		pessoaFisica.put("agencia", agencia);
		pessoaFisica.put("conta", conta);

		try{     

			MongoClientURI uri; 
			uri = new MongoClientURI("mongodb://eduardodesaa:cbr1000rr@ds017256.mlab.com:17256/projetoproweb");
			MongoClient client = new MongoClient(uri);
			DB db = client.getDB(uri.getDatabase());

			DBCollection financeiro = db.getCollection("financeiro");
			financeiro.insert(pessoaFisica);
		}catch(Exception e){
			System.out.print("Deu ruim! "+e);
		}
	}

}
