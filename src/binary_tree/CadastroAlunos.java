package binary_tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CadastroAlunos {

	public void limpaTela(){
		for (int i=0;i < 20;++i) System.out.println();
	}

	public void menu(ArvoreBinaria ab) throws Exception{
		int opcao = 0;
		int matricula;
		String nome;
		String enter = "";		
		    
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		limpaTela();	    
		while(opcao != 7) {
		    while (true) {
				System.out.println("APLICACAO DE CADASTRO DE ALUNOS");    
			    System.out.println("(1) Insere novo aluno");
			    System.out.println("(2) Pesquisa aluno");
			    System.out.println("(3) Percorre arvore em pre-ordem");
			    System.out.println("(4) Percorre arvore em in-ordem");
			    System.out.println("(5) Percorre arvore em pos-ordem");
			    System.out.println("(6) Remove aluno");
			    System.out.println("(7) Sair");
			    System.out.print("Escolha a opcao: ");
		    	enter = entrada.readLine();
		    	try{
		    		opcao = Integer.parseInt(enter);
		    		break;
		    	} catch (Exception e) {
		    		limpaTela();    
					continue;
				}
		    }
		    switch (opcao) {
		        case 1:
		        	System.out.print("Entre com a matricula do aluno: ");
		        	matricula = Integer.parseInt(entrada.readLine());
		        	System.out.print("Entre com o nome do aluno: ");
		        	nome = entrada.readLine();
		        	ab.insereAluno(matricula, nome);
		        	break;
		        case 2:
		        	System.out.print("Entre com a matricula do aluno: ");
		        	matricula = Integer.parseInt(entrada.readLine());
		        	System.out.println(ab.pesquisaAluno(matricula));
		        	break;
		        case 3:
		        	ab.pecorrerPreOrdem();
		        	break;
		        case 4:
		        	ab.pecorrerInOrdem();
		        	break;
		        case 5:
		        	ab.pecorrerPosOrdem();
		        	break;
		        case 6:
		        	System.out.print("Entre com a matricula do aluno: ");
		        	matricula = Integer.parseInt(entrada.readLine());
		        	ab.removeAluno(matricula);
		        	break;
		        case 7:
		        	System.out.println("\n  ...Programa encerrado!!!");
		            continue;
		        default:
		            System.out.println("Opção inválida!");                            
		    }      
		    System.out.print("\n\n              Tecle algo...");
		    entrada.readLine();              
		    limpaTela();      
		}
	}
	
	public static void main(String[] args) throws Exception  {
	    CadastroAlunos ca = new CadastroAlunos();
	    ArvoreBinaria ab = new ArvoreBinaria();
	    ca.menu(ab);		
	}

}
