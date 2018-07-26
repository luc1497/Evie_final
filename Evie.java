package projeto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import serie.Serie;
import serie.Usuario;


public class Evie {

	public static void main(String[] args) throws Exception {
		
		
		ColecaoUsuarios coleUser = new ColecaoUsuarios();
		
		
		
		
		
		try {
			coleUser = loadUser();
			}catch(Exception e) {
				System.out.println("Carregando...");
				System.out.println("Dados de usuarios não encontrados");
				
			}
		
		
		menulogin(coleUser);
	
		
	}
		
	//====================================================================================================//
									  	//MÉTODOS MAIN//
	
	
	

	/**
	 * METODO DE MENU DE GERENCIAMENTO DA BIBLIOTECA DE UM USUÁRIO
	 * @param coleUser
	 * @param userLogado
	 * @throws Exception
	 */
	
	public static void menu(ColecaoUsuarios coleUser, Usuario userLogado) throws Exception {
		Scanner ler = new Scanner(System.in);	
		int opcao;
		
		
		System.out.println("\n#### ESCOLHA UMA OPCAO #####\n");
        System.out.println("1. ADICIONAR SERIE");
        System.out.println("2. LISTAR TODAS AS SERIES");
        System.out.println("3. REMOVER SERIE");
        System.out.println("4. ADICIONAR EPISODIO");
        System.out.println("5. REMOVER EPISODIO");
        System.out.println("6. DESLOGAR");
        ColecaoSeries coles = userLogado.getCole();
        opcao = leinteiro(ler);
       
        do {
        switch (opcao) {
        
       
        case 1:
        		
        		adcionarSerie(ler, coles);
            	saveUser(coleUser);
        		
        		menu(coleUser, userLogado);
        
        		
        case 2:
        	
        		coles.listaSeries();
        		menu(coleUser, userLogado);
       
        case 3:
        		ler.nextLine();
        		Serie serie = null;
        		System.out.println("INFORME O NOME DA SERIE");
        		String nome = lestring(ler);
        		
        		try{
        			serie = coles.pesquisaSeriePorNome(nome);
        			}catch(Exception e){
        				System.out.println(e.getMessage());
        				menu(coleUser, userLogado);
        		}
        		coles.removeSerie(serie);
        		System.out.println("A serie: " + nome + " foi removida "  );
        		saveUser(coleUser);
        		menu(coleUser, userLogado);
        
        case 4:
        		ler.nextLine();
        		Serie serie1 = null;
        		System.out.println("Informe o nome da serie que voce assistiu"  );
        		String nome1 = lestring(ler);
        		try{
        			serie1 = coles.pesquisaSeriePorNome(nome1);
        			}catch(Exception e){
        				System.out.println(e.getMessage());
        				menu(coleUser, userLogado);
        			}
        		System.out.println("Quantos episodios da serie voce assistiu?");
        		int num = leinteiro(ler);
			coles.adicionaEp(serie1, num);
			int atual = serie1.getEpAtual();
			System.out.println("\n A SERIE " + nome1 +  " AGORA POSSUI " + atual + " EPISODIOS ASSISTIDOS");
			int qtdatual1 = serie1.getEpAtual();
			int qtdmax1 = serie1.getEpMax();
			String status = coles.atualizaStatus(qtdatual1, qtdmax1, serie1);
			serie1.setStatus(status);
			saveUser(coleUser);
			menu(coleUser, userLogado);
      
        case 5: 
        		ler.nextLine();
        		Serie serie2 = null;
        		System.out.println("Informe o nome da serie que voce deseja remover episodios"  );
        		String nome2 = lestring(ler);
        		try{
        			serie2 = coles.pesquisaSeriePorNome(nome2);
        			}catch(Exception e){
        				System.out.println(e.getMessage());
        				menu(coleUser, userLogado);
        			}
        		System.out.println("Quantos episodios da serie voce deseja remover?");
        		int num1 = leinteiro(ler);
			coles.removeEp(serie2, num1);
			int atual1 = serie2.getEpAtual();
			System.out.println("\n A SERIE " + nome2 +  " AGORA POSSUI " + atual1 + " EPISODIOS ASSISTIDOS");
			int qtdatual = serie2.getEpAtual();
			int qtdmax = serie2.getEpMax();
			String status1 = coles.atualizaStatus(qtdatual, qtdmax, serie2);
			serie2.setStatus(status1);
			saveUser(coleUser);
			menu(coleUser, userLogado);
       
        case 6: 
        	saveUser(coleUser);
        	menulogin(coleUser);
        	
       default:
    	   System.out.print("Opcao invalida");
        } 
        
        	
      	
  	
        menu(coleUser, userLogado);
       
        
        	
        }while (opcao !=0);
      
	}
	
	
	
	
	
	/**
	 * METODO PARA ADICIONAR O OBJETO SERIE A BIBLIOTECA DO USUARIO
	 * @param ler
	 * @param coles
	 */
	
	public static void adcionarSerie(Scanner ler, ColecaoSeries coles) {
		ler.nextLine();
		
		System.out.println("INFORME O NOME DA SERIE");
		
		String nome = lestring(ler);
		if (coles.pesquisaSerieExistente(nome)==true) {
		System.out.println("INFORME A QUANTIDADE DE EPISODIOS DA SERIE, DIGITE 0 CASO NAO SAIBA");
		int qtdmax = leinteiro(ler);
		System.out.println("INFORME A NUMERACAO DO ULTIMO EPISODIO QUE ASSISTIU, DIGITE 0 CASO NAO TENHA COMECADO A ASSISTIR");
		int qtdatual = leinteiro(ler);
		String status = "";
		
			/**
			 * IF PARA DEFINIR O VALOR DE STATUS, CASO SEJA 0, A SERIE AINDA SERA INICIADA,
			 * CASO SEJA MAIOR QUE ZERO E MENOR QUE A QUANTIDADE MAXIMA DE EPISODIOS,
			 * A SERIE ESTA EM ANDAMENTO, CASO SEJA IGUAL AO NUMERO MAXIMO DE EPISODIOS, 
			 * A SERIE ESTA ENCERRADA.
			 */
			String nomediretor = null;
			int idadediretor = 0;
			String nacionalidade = null;
		
			if(qtdmax == 0) {
				Serie s = new Serie (nome, idadediretor, nacionalidade, nomediretor, qtdatual, status);
				status = coles.atualizaStatus(qtdatual, qtdmax, s );
				s.setStatus(status);
				coles.adcionaSerie(s);
			
			}else {
				Serie s = new Serie (nome, idadediretor, nacionalidade, nomediretor, qtdmax, qtdatual, status);
				status = coles.atualizaStatus(qtdatual, qtdmax, s );
				s.setStatus(status);
				coles.adcionaSerie(s);
			}
			System.out.println("A SERIE FOI ADICIONADA NA LISTA");

		}
					
	}

	/**
	 * METODO QUE CRIA UM ARQUIVO E SALVA A COLECAO DE USUARIOS CRIADOS
	 * @param user
	 * @return
	 * @throws FileNotFoundException
	 */

	public static ColecaoUsuarios saveUser (ColecaoUsuarios user) throws FileNotFoundException  {
		
		try {
			String diretorio = new File(".").getCanonicalPath();
			
			FileOutputStream arquivoGrav = new FileOutputStream (diretorio + "/arquivo.txt");
			ObjectOutputStream gravar = new ObjectOutputStream(arquivoGrav);
			gravar.writeObject(user);
			System.out.println("Dados Salvos!");
			gravar.close();
			arquivoGrav.close();
			} catch (Exception e) {
			
				e.printStackTrace();
			}
		return user;			
}	
	
	/**
	 * METODO PARA VERIFICAR A EXISTENCIA DE UM ARQUIVO CRIADO PELA METODO "saveUser", CASO EXISTA, CARREGAR OS SEUS DADOS
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */

	public static ColecaoUsuarios loadUser () throws IOException, ClassNotFoundException {
		
		// FileInputStream objLeitura = new FileInputStream("/Users/ifpb/eclipse-workspace/Evie beta/arquivo.txt");
		 String diretorio = new File(".").getCanonicalPath();
		 FileInputStream objLeitura = new FileInputStream(diretorio + "/arquivo.txt");
		 ObjectInputStream ler =  new ObjectInputStream(objLeitura);	
			ColecaoUsuarios coleUser;
		
				coleUser = (ColecaoUsuarios) ler.readObject();
				System.out.println("Carregando...");
				System.out.println("Dados de usuarios existente carregados");
				return coleUser;
	
	
}

/**
 * METODO DO PRIMEIRO MENU DO PROGRAMA, SERVINDO PARA GERENCIAR OS USUARIOS
 * @param coleUser
 * @throws FileNotFoundException
 */
	public static void menulogin (ColecaoUsuarios coleUser) throws FileNotFoundException {
		int opcao;
		Scanner ler = new Scanner(System.in);	
		
		
		System.out.println("\n#### ESCOLHA A OPCAO #####\n");
        System.out.println("1. LOGIN");
        System.out.println("2. ADICIONAR USUARIO");
        System.out.println("3. REMOVER USUARIO");
        System.out.println("4. LISTAR USUARIOS");
       
        opcao = leinteiro(ler);
        
        
		do {
	        switch (opcao) {
	       
	        case 1:
	        	ler.nextLine();
	        	System.out.println("DIgite o Username");
	        	String nomelogin = lestring(ler);
	        	System.out.println("Digite senha");
	        	String senhalogin = lestring(ler);
	        	
	        	
	        	try {
	        		Usuario user11 = coleUser.pesquisaUserPorNome(nomelogin);
					coleUser.comparaSenha(senhalogin, user11);
					System.out.println("\nSeja bem-vindo " + user11.getNome());
					menu(coleUser, user11);
				} catch (Exception e) {
					System.out.println(e.getMessage());
					menulogin(coleUser); 
				}
	        	
	        	
	        	
	        case 2:
	        	ler.nextLine();
	        	System.out.println("DIgite o Username");
	        	String nomeUser = lestring(ler);
	        	if (coleUser.pesquisaUserExistente(nomeUser) == true ) {
	        	System.out.println("Digite senha");
	        	String senha = lestring(ler);
	        	ColecaoSeries coles = new ColecaoSeries();	
	        	Usuario user = new Usuario (nomeUser, senha, coles);
	        	coleUser.adicionaUsuario(user);
	        	saveUser(coleUser);
	        	}
	        	
	        	menulogin(coleUser);
	        	
	        case 3: 	
	        	ler.nextLine();
	        	System.out.println("Informe o nome do usuario");
	        	String nome = lestring(ler);
	        	try {
					Usuario user1 = coleUser.pesquisaUserPorNome(nome);
					coleUser.removeUsuario(user1);
				} catch (Exception e) {
					System.out.println(e.getMessage());
					menulogin(coleUser);
				}    
	        	saveUser(coleUser);
	        	menulogin(coleUser);

	        
	        case 4:
	        	coleUser.listaUsuarios();
	        	menulogin(coleUser);
	        
	        default: 
	        	System.out.println("Esta não é uma opção válida");
	        }
	        
	        	menulogin(coleUser);
	        }while (opcao !=0);
		
		
	
		
		}
	/**
	 * METODO PARA GARANTIR A LEITURA DE UM NUMERO INTEIRO
	 * @param in
	 * @return
	 */
private static int leinteiro(Scanner in) {
		
		
		while(!in.hasNextInt()){
			in.nextLine();
			System.out.print("Tipo de dado inválido. Digite novamente: ");
		}
		int r = in.nextInt();
		return r;
		
	}

private static String lestring(Scanner in) {
	
	
	while(!in.hasNextLine()){
		in.nextLine();
		System.out.print("Tipo de dado inválido. Digite novamente: ");
	}
	String r = in.nextLine();
	return r;
	
}
}


