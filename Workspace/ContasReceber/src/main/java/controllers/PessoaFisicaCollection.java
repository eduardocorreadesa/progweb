package controllers;

import java.net.UnknownHostException;
import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;


import static java.util.Arrays.asList;

import model.PessoaFisica;
/**
 *
 * @author eduardocorreadesa
 */
public class PessoaFisicaCollection {

	public void createPessoaFisica(model.PessoaFisica pessoa) throws UnknownHostException{
		try{  
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

			DBCollection financeiro = ConnectCollection.connectCollection("pessoaFisica");
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

			DBCollection financeiro = ConnectCollection.connectCollection("pessoaFisica");
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
			}

		}catch(Exception e){
			System.out.print("Deu ruim pra salvar na Collection! "+e);
		}

		return listPessoa;
	}
        
        	public static PessoaFisica getPessoaFisicaPorCPF(String Cpf) throws UnknownHostException{
		DBObject docsDBObject = null;
		PessoaFisica pessoa = new PessoaFisica();
		try{     

			DBCollection financeiro = ConnectCollection.connectCollection("pessoaFisica");
			BasicDBObject findQuery = new BasicDBObject("cpf", Cpf);
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
				
			}

		}catch(Exception e){
			System.out.print("getPessoaFisicaPorCPF "+e);
		}

		return pessoa;
	}
                
           public static void updatePessoaFisicaPorCPF(String Cpf, PessoaFisica pessoa) throws UnknownHostException{
		DBObject docsDBObject = null;
		
		try{     

			DBCollection financeiro = ConnectCollection.connectCollection("pessoaFisica");
			BasicDBObject findQuery = new BasicDBObject("cpf", Cpf);
			

        financeiro.update(findQuery, new BasicDBObject("$set", 
                new BasicDBObject("nome", pessoa.getNome() ))); 
        financeiro.update(findQuery, new BasicDBObject("$set", 
                new BasicDBObject("dataNascimento", pessoa.getDataNascimento())));
        financeiro.update(findQuery, new BasicDBObject("$set", 
                new BasicDBObject("estadoCivil", pessoa.getEstadoCivil())));
         financeiro.update(findQuery, new BasicDBObject("$set", 
                new BasicDBObject("sexo", pessoa.getSexo())));
            financeiro.update(findQuery, new BasicDBObject("$set", 
                new BasicDBObject("agencia", pessoa.getAgencia())));
            financeiro.update(findQuery, new BasicDBObject("$set", 
                new BasicDBObject("conta", pessoa.getConta())));
           financeiro.update(findQuery, new BasicDBObject("$set", 
                new BasicDBObject("limite", pessoa.getLimite())));
			
        
        
 
				
        
        
        
        
        

		}catch(Exception e){
			System.out.print("updatePessoaFisicaPorCPF "+e);
		}

		
	}

}
