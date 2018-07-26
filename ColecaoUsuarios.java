package projeto;

import java.io.Serializable;
import java.util.ArrayList;

import serie.Usuario;

public class ColecaoUsuarios implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList <Usuario> colesUser;
	
/**
 * INICIAR COLECAO DE USUARIO
 */
	public ColecaoUsuarios () {
		colesUser = new ArrayList <Usuario>();
	}

	/**
	 * METODO PARA ADICIONAR OBJETO NA COLECAO
	 * @param user
	 */
	public void adicionaUsuario (Usuario user) {
		colesUser.add(user);
	}

	/**
	 * METODO PARA REMOVER OBJETO NA COLECAO
	 * @param user
	 */
	public void removeUsuario (Usuario user) {
		colesUser.remove(user);
		
	}
 
	/**
	 * METODO PARA PESQUISAR UM OBJETO NA COLECAO, PASSANDO O NOME COMO PARAMETRO
	 * @param nome
	 * @return
	 * @throws Exception
	 */
	public Usuario pesquisaUserPorNome (String nome) throws Exception{
		
		for (Usuario user: colesUser) {
			if (user.getNome().equalsIgnoreCase(nome)) {
				return user;
			}				
		}
		throw new Exception ("O Usuario com o nome " + nome + " nao foi encontrado" );
	}
	
	/**
	 * METODO PARA VERIFICAR A EXISTENCIA DE UM OBJETO, PASSANDO O NOME COMO PARAMETRO
	 * @param nome
	 * @return
	 */
	public boolean pesquisaUserExistente (String nome ) {
		
		for (Usuario user: colesUser) {
			if (user.getNome().equalsIgnoreCase(nome)) {
				System.out.println("O usuario: " + nome +  " ja existe");
				return false;				
			}	
		} return true;
	}
	
	
	/**
	 * METODO PARA COMPARAR SENHA DO OBJETO USUARIO, PASSANDO UM SENHA COMO PARAMETRO E COMPARANDO COM A SENHA SALVA NA COLECAO
	 * @param senha
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean comparaSenha (String senha, Usuario user) throws Exception{
			if (user.getSenha().equals(senha)){
				return true;
			}
			
		throw new Exception ("Senha incorreta" );
		
	}
	/**
	 * METODO PARA LISTAR OS OBJETOS USUARIOS
	 */
	public void listaUsuarios(){
		for (Usuario user: colesUser) {
			System.out.println (user);
			
		}
	
		
		
		
	}
}
