package br.com.agenda.aplicacao;

import java.util.Date;
import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;
import br.com.agenda.mostraDados.MostraDados;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		MostraDados mostrar = new MostraDados();
		ContatoDAO contatoDAO = new ContatoDAO();			
		Contato contato = new Contato();
		Contato c1 = new Contato();
		
		System.out.print("##---Opções do Programa----##\n\n");
		System.out.print("|-----------------------------|\n");
		System.out.print("| Opção 1 - Novo Cadastro     |\n");
		System.out.print("| Opção 2 - Atualizar         |\n");
		System.out.print("| Opção 3 - Mostrar           |\n");
		System.out.print("| Opção 4 - Deletar           |\n");
		System.out.print("| Opção 5 - Sair              |\n");
		System.out.print("|-----------------------------|\n");
		System.out.print("Digite uma opção: ");
		
		int opcao = sc.nextInt();
		
		switch (opcao) {
		case 1:
			System.out.print("\nOpção Novo Cadastro Selecionado\n");
			
			System.out.print("\nDigite o nome: \n");
			
			String nome = sc.next();
			contato.setNome(nome);
			
			System.out.print("\nDigite a idade: \n");
			int idade = sc.nextInt();
			contato.setIdade(idade);
			contato.setDataCadastro(new Date());
			contatoDAO.save(contato);
			
			break;
		
		case 2:
			System.out.print("\nOpção Atualizar Selecionado\n");
			mostrar.mostraDados();
			System.out.print("\nDigite o ID que deseja atualizar: \n");
			int id = sc.nextInt();
			c1.setId(id);
			
			System.out.print("\nDigite o novo nome: \n");
			String newnome = sc.next();
			c1.setNome(newnome);
			
			System.out.print("\nDigite a nova idade: \n");
			int newidade = sc.nextInt();
			c1.setIdade(newidade);
			c1.setDataCadastro(new Date());
			
			contatoDAO.update(c1);
			break;
		
		case 3:
			System.out.print("\nOpção Mostrar Selecionada\n");
			mostrar.mostraDados();
			break;
			
		case 4:
			System.out.print("\nOpção Delete Selecionado\n");
			mostrar.mostraDelete();
			System.out.print("\n\nDigite o ID que deseja deletar: \n");
			int iddelete = sc.nextInt();
			contatoDAO.deleteById(iddelete);
			break;
		default:
			System.out.print("\nOpção Inválida!");
			break;
			
		case 5:
			System.out.print("\nAté logo!");
			sc.close();		
		}
		
		
		
		//add contato
		//contato.setNome("David");
		//contato.setIdade(28);
		//contato.setDataCadastro(new Date());
		
		//contatoDAO.save(contato);
		
		//Atalizar contato

		//c1.setNome("Daniel Santos");
		//c1.setIdade(22);
		//c1.setDataCadastro(new Date());
		//c1.setId(1);
		
		//contatoDAO.update(c1);
		
		//delete pelo id
		//contatoDAO.deleteById(4);
		
		//Visualizar Registros
		
	}

}
