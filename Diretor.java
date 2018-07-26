package serie;

import java.io.Serializable;

public class Diretor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomediretor;
	private int idade;
	private String nacionalidade;
	
	public Diretor(String nome, int idade, String nacionalidade) {
		super();
		this.nomediretor = nome;
		this.idade = idade;
		this.nacionalidade = nacionalidade;
	}

	public String getNome() {
		return nomediretor;
	}

	public void setNome(String nome) {
		this.nomediretor = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idade;
		result = prime * result + ((nacionalidade == null) ? 0 : nacionalidade.hashCode());
		result = prime * result + ((nomediretor == null) ? 0 : nomediretor.hashCode());
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
		Diretor other = (Diretor) obj;
		if (idade != other.idade)
			return false;
		if (nacionalidade == null) {
			if (other.nacionalidade != null)
				return false;
		} else if (!nacionalidade.equals(other.nacionalidade))
			return false;
		if (nomediretor == null) {
			if (other.nomediretor != null)
				return false;
		} else if (!nomediretor.equals(other.nomediretor))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "Diretor [nome=" + nomediretor + ", idade=" + idade + ", nacionalidade=" + nacionalidade + "]";
	}
	
	
	
	
	
	
}
