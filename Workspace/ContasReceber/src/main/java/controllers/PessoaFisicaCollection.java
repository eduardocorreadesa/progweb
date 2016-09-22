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

import model.PessoaFisica;
/**
 *
 * @author eduardocorreadesa
 */
public class PessoaFisicaCollection {

	public void createPessoaFisica(model.PessoaFisica pessoa) throws UnknownHostException{

		BasicDBObject pessoaFisica = new BasicDBObject();
		pessoaFisica.put("nome", pessoa.getNome());
		pessoaFisica.put("cpf", pessoa.getCpf());
		pessoaFisica.put("dataNascimento", pessoa.getDataNascimento());
		pessoaFisica.put("sexo", pessoa.getSexo());
		pessoaFisica.put("estadoCivil", pessoa.getEstadoCivil());
		pessoaFisica.put("agencia", pessoa.getAgencia());
		pessoaFisica.put("conta", pessoa.getConta());
                pessoaFisica.put("limite", pessoa.getLimite());
                pessoaFisica.put("saldo", pessoa.getSaldo());

		try{     

			MongoClientURI uri; 
			uri = new MongoClientURI("mongodb://eduardodesaa:senhasenha@ds017256.mlab.com:17256/projetoproweb");
			MongoClient client = new MongoClient(uri);
			DB db = client.getDB(uri.getDatabase());

			DBCollection financeiro = db.getCollection("pessoaFisica");
			financeiro.insert(pessoaFisica);
		}catch(Exception e){
			System.out.print("Deu ruim! "+e);
		}
	}

	public static ArrayList<PessoaFisica> getPessoaFisica() throws UnknownHostException{
		DBObject docsDBObject = null;
		ArrayList<PessoaFisica> listPessoa = new ArrayList<PessoaFisica>();
		PessoaFisica pessoa = new PessoaFisica();
		try{     

			MongoClientURI uri; 
			uri = new MongoClientURI("mongodb://eduardodesaa:senhasenha@ds017256.mlab.com:17256/projetoproweb");
			MongoClient client = new MongoClient(uri);
			DB db = client.getDB(uri.getDatabase());

			DBCollection financeiro = db.getCollection("pessoaFisica");

			BasicDBObject findQuery = new BasicDBObject();
			DBCursor docs = financeiro.find(findQuery);

			while(docs.hasNext()){
				docsDBObject = docs.next();
				pessoa.setNome(docsDBObject.get("nome").toString());
				pessoa.setCpf(docsDBObject.get("cpf").toString());
				pessoa.setAgencia(docsDBObject.get("agencia").toString());
				pessoa.setConta(docsDBObject.get("conta").toString());
				pessoa.setDataNascimento(docsDBObject.get("dataNascimento").toString());
				pessoa.setEstadoCivil(docsDBObject.get("estadoCivil").toString());
				pessoa.setSexo(docsDBObject.get("sexo").toString());
                                pessoa.setLimite(docsDBObject.get("limite").toString());
                                pessoa.setSaldo(docsDBObject.get("saldo").toString());
				listPessoa.add(pessoa);
				pessoa = new PessoaFisica();
				//				System.out.println(
				//						pessoa.getAgencia() + pessoa.getConta() + pessoa.getCpf() + pessoa.getDataNascimento() + pessoa.getEstadoCivil() +
				//						pessoa.getNome()+ pessoa.getSexo());
			}

		}catch(Exception e){
			System.out.print("Deu ruim pra salvar na Collection! "+e);
		}

		return listPessoa;
	}

}
