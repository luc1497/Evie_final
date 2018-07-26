package serie;

import java.io.*;


public class Serie extends Diretor implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ATRIBUTOS
	 */
	
	private String nome;
	private int epMax;
	private  int epAtual;
	private String status;


	/**
 	* CONSTRUTOR PARA UMA SERIE PADRAO	
 	* @param nome
 	* @param epMax
 	* @param epAtual
 	* @param status
 	*/
	
	public Serie(String nome, int idade, String nacionalidade, String nomediretor, int epMax, int epAtual, String status) {
		super(nomediretor, idade, nacionalidade);
		this.nome = nome;
		this.epMax = epMax;
		this.epAtual = epAtual;
		this.status = status;
		
	}
	

	/**
	 * CONSTRUTOR PARA UMA SERIE A QUAL NAO SE CONHECE A QUANTIDADE MAXIMA DE EPISODIOS nao tem epmax
	 * @param nome
	 * @param epAtual
	 * @param status
	 */
	
	public Serie(String nome, int idade, String nacionalidade, String nomediretor, int epAtual, String status) {
		super(nomediretor, idade, nacionalidade);
		this.nome = nome;
		this.epAtual = epAtual;
		this.status = status;
		
	}

	/**
	 * CONSTRUTOR PARA UMA SERIE A QUAL NAO SE CONHECE A QUANTIDADE MAXIMA DE EPISODIOS E QUE AINDA NAO FOI INICIADA epatual = 0
	 * @param nome
	 * @param status
	 */
	
	public Serie(String nome, int idade, String nacionalidade, String nomediretor, String status) {
		super(nomediretor, idade, nacionalidade);
		this.nome = nome;
		this.epAtual = 0;
		this.status = status;

	}

	
	
/**
 * MÉTODOS GETS E SETS
 * @return
 */
	
	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getEpMax() {
		return epMax;
	}

	public void setEpMax(int epMax) {
		this.epMax = epMax;
	}

	public int getEpAtual() {
		return epAtual;
	}

	public void setEpAtual(int epAtual) {
		this.epAtual = epAtual;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	/**
	 * METODO TO STRING
	 */
	@Override
	public String toString() { 
		if(epMax == 0 && epAtual == 0 ) {
			return "Nome da serie: " + nome + "\nTotal de episodios: -\nEpisodios assistidos: " + epAtual + "\nStatus:Serie a comecar\n";
		}if (epMax == 0 && epAtual > epMax) {
			return "Nome da serie: " + nome + "\nTotal de episodios: -\nEpisodios assistidos: " + epAtual + "\nStatus:Serie em andamento\n";
		}
			return "Nome da serie: " + nome + "\nTotal de episodios: " + epMax + "\nEpisodios assistidos: " + epAtual + "\nStatus: " + status + "\n";
		
		}
	


@Override
public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + epAtual;
	result = prime * result + epMax;
	result = prime * result + ((nome == null) ? 0 : nome.hashCode());
	result = prime * result + ((status == null) ? 0 : status.hashCode());
	return result;
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (!super.equals(obj))
		return false;
	if (getClass() != obj.getClass())
		return false;
	Serie other = (Serie) obj;
	if (epAtual != other.epAtual)
		return false;
	if (epMax != other.epMax)
		return false;
	if (nome == null) {
		if (other.nome != null)
			return false;
	} else if (!nome.equals(other.nome))
		return false;
	if (status == null) {
		if (other.status != null)
			return false;
	} else if (!status.equals(other.status))
		return false;
	return true;
}



}



