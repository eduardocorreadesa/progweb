package controllers;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import model.PessoaFisica;
import model.PessoaJuridica;

public class OperacaoFinanceira {

	public static String getSaldoPessoaJuridicaPessoaFisica(String cpfCnpj) throws UnknownHostException{

		String saldo = null;
		DBObject docsDBObject;
		PessoaFisica pessoa = new PessoaFisica();
		PessoaJuridica juridica = new PessoaJuridica();

		try{     
			if(cpfCnpj!=null){

				DBCollection financeiro = ConnectCollection.connectCollection("pessoaFisica");
				BasicDBObject findQueryPessoa = new BasicDBObject("cpf", cpfCnpj);
				DBCursor docs = financeiro.find(findQueryPessoa);

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
					System.out.println("CPF: "+pessoa.getCpf());
				}
				saldo = pessoa.getSaldo();

				if(pessoa.getCpf()==null){

					financeiro = ConnectCollection.connectCollection("pessoaJuridica");
					BasicDBObject findQueryJuridica = new BasicDBObject("cnpj", cpfCnpj);
					docs = financeiro.find(findQueryJuridica);

					while(docs.hasNext()){
						docsDBObject = docs.next();
						juridica.setNomeFantasia(docsDBObject.get("nomeFantasia").toString());
						juridica.setCnpj(docsDBObject.get("cnpj").toString());
						juridica.setLimite(docsDBObject.get("limite").toString());
						juridica.setSaldo(docsDBObject.get("saldo").toString());
						juridica.setConta(docsDBObject.get("conta").toString());
						juridica.setAgencia(docsDBObject.get("agencia").toString());
						System.out.println(juridica.getSaldo());

					}
					saldo = juridica.getSaldo();			
				}
			}
		}catch(Exception e){
			System.out.print("getSaldoPessoaJuridicaPessoaFisica "+e);
		}

		return saldo;

	}

	public static void debitarSaldo(String cpfCnpj, String valorDebitar){

		DBObject docsDBObject = null;
		PessoaFisica pessoa = new PessoaFisica();
		PessoaJuridica juridica = new PessoaJuridica();
		String saldo = null;
		try{     

			DBCollection financeiro = ConnectCollection.connectCollection("pessoaFisica");
			BasicDBObject findQuery = new BasicDBObject("cpf",cpfCnpj);
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


			if(pessoa.getSaldo()!=null){
				saldo = operacaoDebitar(pessoa.getSaldo(),valorDebitar);
				pessoa.setSaldo(saldo);
				updatePessoaFisica(pessoa);
			}

			if(pessoa.getSaldo() == null ||  pessoa.getSaldo().equals("")){

				financeiro = ConnectCollection.connectCollection("pessoaJuridica");
				findQuery = new BasicDBObject("cnpj", cpfCnpj);
				docs = financeiro.find(findQuery);

				while(docs.hasNext()){
					docsDBObject = docs.next();
					juridica.setNomeFantasia(docsDBObject.get("nomeFantasia").toString());
					juridica.setCnpj(docsDBObject.get("cnpj").toString());
					juridica.setLimite(docsDBObject.get("limite").toString());
					juridica.setSaldo(docsDBObject.get("saldo").toString());
					juridica.setAgencia(docsDBObject.get("agencia").toString());
					juridica.setConta(docsDBObject.get("conta").toString());

				}

				saldo = operacaoDebitar(juridica.getSaldo(),valorDebitar);
				juridica.setSaldo(saldo);
				updatePessoaJuridica(juridica);
			}
		}catch(Exception e){
			System.out.print("debitarSaldo "+e);
		}
	}

	public static void depositarSaldo(String cpfCnpj, String valorDepositar){

		DBObject docsDBObject = null;
		PessoaFisica pessoa = new PessoaFisica();
		PessoaJuridica juridica = new PessoaJuridica();
		String saldo = null;
		try{     

			DBCollection financeiro = ConnectCollection.connectCollection("pessoaFisica");
			BasicDBObject findQuery = new BasicDBObject("cpf",cpfCnpj);
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


			if(pessoa.getSaldo()!=null){
				saldo = operacaoDepositar(pessoa.getSaldo(),valorDepositar);
				pessoa.setSaldo(saldo);
				updatePessoaFisica(pessoa);
			}

			if(pessoa.getSaldo() == null ||  pessoa.getSaldo().equals("")){

				financeiro = ConnectCollection.connectCollection("pessoaJuridica");
				findQuery = new BasicDBObject("cnpj", cpfCnpj);
				docs = financeiro.find(findQuery);

				while(docs.hasNext()){
					docsDBObject = docs.next();
					juridica.setNomeFantasia(docsDBObject.get("nomeFantasia").toString());
					juridica.setCnpj(docsDBObject.get("cnpj").toString());
					juridica.setLimite(docsDBObject.get("limite").toString());
					juridica.setSaldo(docsDBObject.get("saldo").toString());
					juridica.setConta(docsDBObject.get("conta").toString());
					juridica.setAgencia(docsDBObject.get("agencia").toString());

				}

				saldo = operacaoDepositar(juridica.getSaldo(),valorDepositar);
				juridica.setSaldo(saldo);
				updatePessoaJuridica(juridica);
			}
		}catch(Exception e){
			System.out.print("depositarSaldo "+e);
		}
	}

	public static void updatePessoaFisica(PessoaFisica pessoa){

		DBCollection financeiro = ConnectCollection.connectCollection("pessoaFisica");
		BasicDBObject updateQuery = new BasicDBObject("cpf", pessoa.getCpf());
		financeiro.update(updateQuery, new BasicDBObject("$set", new BasicDBObject("saldo", pessoa.getSaldo())));

	}

	public static void updatePessoaJuridica(PessoaJuridica juridica){

		DBCollection financeiro = ConnectCollection.connectCollection("pessoaJuridica");
		BasicDBObject updateQuery = new BasicDBObject("cnpj", juridica.getCnpj()); 
		financeiro.update(updateQuery, new BasicDBObject("$set", new BasicDBObject("saldo", juridica.getSaldo())));

	}

	private static String operacaoDebitar(String saldo, String valorDebitar){
		String valor = "";
		double doubleValor = 0;
		double doubleSaldo = Double.parseDouble(saldo);
		double doubleValorDebitar = Double.parseDouble(valorDebitar);          
		doubleValor = doubleSaldo - doubleValorDebitar;
		valor = String.valueOf(doubleValor);
		return valor;
	}

	private static String operacaoDepositar(String saldo, String valorDebitar){
		String valor = "";
		double doubleValor = 0;
		double doubleSaldo = Double.parseDouble(saldo);
		double doubleValorDpositar = Double.parseDouble(valorDebitar);          
		doubleValor = doubleSaldo + doubleValorDpositar;
		valor = String.valueOf(doubleValor);
		return valor;
	}
}
