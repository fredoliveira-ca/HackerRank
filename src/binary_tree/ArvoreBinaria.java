package binary_tree;

import binary_tree.No;

public class ArvoreBinaria {
	  /* Atributo de classe: vari�vel que possui refer�ncia para o n� raiz da arvore bin�ria */
	  private No raiz;

	  /* M�todo para inser��o ordenada na �rvore bin�ria */
	  public void insereAluno(int mat, String nome){
	    insere(mat, nome, raiz);
	  }
	  
	  /* Metodo recursivo  */
	  private void insere(int mat, String nome, No no){ 
		//c�digo Java faltando!!!
	  }   

	  /* Metodo recursivo para pesquisar o nome de um Aluno pela matr�cula */
	  public String pesquisaAluno(int mat){
		return pesquisa(mat, raiz);
	  }
	  
	  private String pesquisa(int mat, No no){ 
			//c�digo Java faltando!!!
		  return null;
	  }   
	  
	  public void removeAluno(int mat){
		//c�digo Java faltando - apagar o return abaixo!!!		
	  }	  
	  
	  /* M�todos de acesso  */
	  private No getRaiz(){  
		//c�digo Java faltando - apagar o return abaixo!!!
		  return null;
	  }

	  /* M�todos de consulta  */
	  private boolean ehInterno(No no){    
		//c�digo Java faltando - apagar o return abaixo!!!
		  return false;
	  }
	  
	  private boolean ehExterno(No no){    
		//c�digo Java faltando - apagar o return abaixo!!!
		  return false;
	  }
	  
	  private boolean ehRaiz(No no){   
		//c�digo Java faltando - apagar o return abaixo!!!
		  return false;
	  }  
	  
	  public void pecorrerPreOrdem(){
		visitarPreOrdem(raiz);
	  }
	  
	  private void visitarPreOrdem(No no){    
		//c�digo Java faltando
	  }

	  public void pecorrerInOrdem(){
		visitarInOrdem(raiz);
	  }
	  
	  private void visitarInOrdem(No no){
		//c�digo Java faltando
	  }
	  
	  public void pecorrerPosOrdem(){
		visitarPosOrdem(raiz);
	  }
	  
	  private void visitarPosOrdem(No no){    
		//c�digo Java faltando
	  }
	}