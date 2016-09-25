package controllers;

import java.net.UnknownHostException;
import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import model.PessoaFisica;

import model.PessoaJuridica;

public class PessoaJuridicaCollection {

	public void createPessoaJuridica(PessoaJuridica pessoa) throws UnknownHostException{
		try{
			BasicDBObject pessoaJuridica = new BasicDBObject();
			pessoaJuridica.put("nomeFantasia", pessoa.getNomeFantasia());
			pessoaJuridica.put("cnpj", pessoa.getCnpj());
			pessoaJuridica.put("saldo", pessoa.getSaldo());
			pessoaJuridica.put("limite", pessoa.getLimite());
			pessoaJuridica.put("conta", pessoa.getConta());
			pessoaJuridica.put("agencia", pessoa.getAgencia());

			DBCollection financeiro = ConnectCollection.connectCollection("pessoaJuridica");

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
			DBCollection financeiro = ConnectCollection.connectCollection("pessoaJuridica");

			BasicDBObject findQuery = new BasicDBObject();
			DBCursor docs = financeiro.find(findQuery);

			while(docs.hasNext()){
				docsDBObject = docs.next();
				pessoaJuridica.setNomeFantasia(docsDBObject.get("nomeFantasia").toString());
				pessoaJuridica.setCnpj(docsDBObject.get("cnpj").toString());
				pessoaJuridica.setSaldo(docsDBObject.get("saldo").toString());
				pessoaJuridica.setLimite(docsDBObject.get("limite").toString());
				pessoaJuridica.setAgencia(docsDBObject.get("agencia").toString());
				pessoaJuridica.setConta(docsDBObject.get("conta").toString());

				listPessoaJuridica.add(pessoaJuridica);
				pessoaJuridica = new PessoaJuridica();
			}

		}catch(Exception e){
			System.out.print("Deu ruim! "+e);
		}

		return listPessoaJuridica;
	}
        
        public static PessoaJuridica getPessoaJuridicaPorCNPJ(String cnpj) throws UnknownHostException{
		DBObject docsDBObject = null;
		
		PessoaJuridica pessoaJuridica = new PessoaJuridica();
		try{     
			DBCollection financeiro = ConnectCollection.connectCollection("pessoaJuridica");

			BasicDBObject findQuery = new BasicDBObject("cnpj", cnpj);
			DBCursor docs = financeiro.find(findQuery);

			while(docs.hasNext()){
				docsDBObject = docs.next();
				pessoaJuridica.setNomeFantasia(docsDBObject.get("nomeFantasia").toString());
				pessoaJuridica.setCnpj(docsDBObject.get("cnpj").toString());
				pessoaJuridica.setSaldo(docsDBObject.get("saldo").toString());
				pessoaJuridica.setLimite(docsDBObject.get("limite").toString());
				pessoaJuridica.setAgencia(docsDBObject.get("agencia").toString());
				pessoaJuridica.setConta(docsDBObject.get("conta").toString());

				
			}

		}catch(Exception e){
			System.out.print("getPessoaJuridicaPorCNPJ "+e);
		}

		return pessoaJuridica;
	}
        
                   public static void updatePessoaJuridicaPorCNPJ(String cnpj, PessoaJuridica juridica) throws UnknownHostException{
		DBObject docsDBObject = null;
		
		try{     

			DBCollection financeiro = ConnectCollection.connectCollection("pessoaJuridica");
			BasicDBObject findQuery = new BasicDBObject("cnpj", cnpj);
			

        financeiro.update(findQuery, new BasicDBObject("$set", 
                new BasicDBObject("nomeFantasia", juridica.getNomeFantasia() ))); 
            financeiro.update(findQuery, new BasicDBObject("$set", 
                new BasicDBObject("agencia", juridica.getAgencia())));
            financeiro.update(findQuery, new BasicDBObject("$set", 
                new BasicDBObject("conta", juridica.getConta())));
           financeiro.update(findQuery, new BasicDBObject("$set", 
                new BasicDBObject("limite", juridica.getLimite())));
			
        
        
 
				
        
        
        
        
        

		}catch(Exception e){
			System.out.print("updatePessoaJuridica "+e);
		}

		
	}


}
