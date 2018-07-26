package serie;

import java.io.Serializable;

import projeto.ColecaoSeries;

public class Usuario implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private String nome;
	private String senha;
	private ColecaoSeries cole;
	

	
	public Usuario(String nome, String senha, ColecaoSeries cole) {
		super();
		this.nome = nome;
		this.senha = senha;
		this.cole = cole;
	}


	public ColecaoSeries getCole() {
		return cole;
	}


	public void setCole(ColecaoSeries cole) {
		this.cole = cole;
	}


	public Usuario(String nome) {
		this.nome = nome;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Usuario: " + nome;
	}
	
	
	
	
}
