package br.com.agenda.mostraDados;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

public class MostraDados {
	
	public void mostraDados() {
		ContatoDAO contatoDAO = new ContatoDAO();
		for(Contato c: contatoDAO.getContatos()) {
			System.out.println("Contato: " +c.getNome()+ " | Idade: " +c.getIdade()+ " | Data do Cadastro: " +c.getDataCadastro());
		}
	}
	public void mostraDelete() {
		ContatoDAO contatoDAO = new ContatoDAO();
		for(Contato c: contatoDAO.getContatos()) {
			System.out.println("Id: "+c.getId()+" | Contato: " +c.getNome()+ " | Idade: " +c.getIdade()+ " | Data do Cadastro: " +c.getDataCadastro());
		}
	}

}
