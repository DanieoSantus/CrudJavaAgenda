package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;

public class ContatoDAO {
	//CRUD
	
	public void save(Contato contato) {
		
		String sql = "INSERT INTO contatos (nome, idade, dataCadastro) values (?,?,?)";
		
		Connection conn = null; 
		PreparedStatement pstm = null;
		
		try {
			//criar conexão Banco
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//PreparedStatement executa Query
			pstm =(PreparedStatement) conn.prepareStatement(sql);
			
			//adciona valores
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
			
			//Executar a query
			pstm.execute();
			
			System.out.println("Contato Salvo Com Sucesso!!");
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			// fecha conexões
			try {
				if(pstm!= null) {
					pstm.close();
				}
				if(conn!= null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void update(Contato contato) {
		String sql = "UPDATE contatos Set nome = ?, idade =?, datacadastro=? WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//conexao
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//executa query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			//adiciona para atualização
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
			
			// Qual Id atualizar
			pstm.setInt(4, contato.getId());
			
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
		
	public void deleteById(int id) {
		String sql = "DELETE FROM contatos WHERE id = ?";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public List<Contato> getContatos(){
		String sql = "SELECT * FROM contatos";
		
		List<Contato> contatos = new ArrayList<Contato>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		// classe que recupera dados do banco
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Contato contato = new Contato();
				
				contato.setId(rset.getInt("id"));
				contato.setNome(rset.getString("nome"));
				contato.setIdade(rset.getInt("idade"));
				contato.setDataCadastro(rset.getDate("dataCadastro"));
				
				contatos.add(contato);
			}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					
					if(rset!=null) {
						rset.close();
					}
					if(pstm!=null) {
						pstm.close();
					}
					if(conn!=null) {
						conn.close();
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
			return contatos;
		}
	
		
	}

