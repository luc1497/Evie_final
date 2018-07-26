package projeto;

import java.io.Serializable;
import java.util.ArrayList;

import serie.Serie;

public class ColecaoSeries implements Serializable {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private ArrayList <Serie> coles;
	
	
	/**
	 * INICIA COLECAO DE SERIE
	 */
	public ColecaoSeries () {
		coles = new ArrayList <Serie>();
	}
	
	/**
	 * METODO QUE ADICIONA OBJETO NA COLECAO
	 * @param serie
	 */
	public void adcionaSerie (Serie serie) {
		coles.add(serie);
		
	}
	
	/**
	 * METODO QUE REMOVE OBJETO NA COLECAO
	 * @param serie
	 */
	public void removeSerie (Serie serie) {
		coles.remove(serie);
		
	}
	
	
	/**
	 * METODO PARA PESQUISAR UM OBJETO DA COLECAO PELO NOME, PASSANDO-O COMO PARAMETRO
	 * @param nome
	 * @return
	 * @throws Exception
	 */
	public Serie pesquisaSeriePorNome (String nome) throws Exception{
		
		for (Serie serie: coles) {
			if (serie.getNome().equalsIgnoreCase(nome)) {
				return serie;
			}				
		}
		throw new Exception ("A serie com o nome " + nome + " nao foi encontrado" );
	}
	
	/**
	 * METODO PARA PESQUISAR SE UM DETERMINADO OBJETO EXISTE NA COLECAO, PASSANDO O SEU NOME COMO PARAMETRO 
	 * @param nome
	 * @return
	 */
	public boolean pesquisaSerieExistente (String nome ) {
		
		for (Serie serie: coles) {
			if (serie.getNome().equalsIgnoreCase(nome)) {
				System.out.println("A serie: " + nome +  " ja existe");
				return false;				
			}	
		} return true;
	}
	
	
	/**
	 * METODO PARA ADICIONAR UM VALOR EM UM OBJETO EXISTENTE NA COLECAO
	 * @param serie
	 * @param num
	 */
	public void adicionaEp (Serie serie, int num) {	

		int atual = serie.getEpAtual() +num;
		serie.setEpAtual(atual);	
	}
	
	
	/**
	 * METODO PARA REMOVER UM VALOR EM UM OBJETO EXISTENTE NA COLECAO
	 * @param serie
	 * @param num
	 */
	public void removeEp (Serie serie, int num) {	

		int atual = serie.getEpAtual() -num;
		serie.setEpAtual(atual);	
	}
	
	/**
	 * METODO PARA LISTAR A COLECAO DO USUARIO
	 */
	public void listaSeries () {
		for (Serie serie: coles) {
			System.out.println(serie);
		}	
	}
		
	/**
	 * METODO PARA ATUALIZAR STATUS DO OBJETO, LEVANDO EM CONSIDERACAO OS VALORES DO MESMO
	 * @param qtdatual
	 * @param qtdmax
	 * @param serie
	 * @return
	 */
	public String atualizaStatus (int qtdatual, int qtdmax, Serie serie ) {
		String status = "";
		if(qtdmax < qtdatual) {
			qtdmax=qtdatual;
			serie.setEpMax(qtdmax);
		}
		
		if (qtdatual == 0) {
			status = "A comecar";
			return status;
			} if (qtdatual > 0 && qtdatual < qtdmax ) {
				status = "Em andamento";
				return status;
			}if(qtdatual == qtdmax) {
				status = "Serie encerrada";
				return status;
			}
			return status;
		
	}
	
	
	
	
	
	
}

