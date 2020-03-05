package binary_tree;

import binary_tree.No;

public class ArvoreBinaria {
	  /* Atributo de classe: variável que possui referência para o nó raiz da arvore binária */
	  private No raiz;

	  /* Método para inserção ordenada na árvore binária */
	  public void insereAluno(int mat, String nome){
	    insere(mat, nome, raiz);
	  }
	  
	  /* Metodo recursivo  */
	  private void insere(int mat, String nome, No no){ 
		//código Java faltando!!!
	  }   

	  /* Metodo recursivo para pesquisar o nome de um Aluno pela matrícula */
	  public String pesquisaAluno(int mat){
		return pesquisa(mat, raiz);
	  }
	  
	  private String pesquisa(int mat, No no){ 
			//código Java faltando!!!
		  return null;
	  }   
	  
	  public void removeAluno(int mat){
		//código Java faltando - apagar o return abaixo!!!		
	  }	  
	  
	  /* Métodos de acesso  */
	  private No getRaiz(){  
		//código Java faltando - apagar o return abaixo!!!
		  return null;
	  }

	  /* Métodos de consulta  */
	  private boolean ehInterno(No no){    
		//código Java faltando - apagar o return abaixo!!!
		  return false;
	  }
	  
	  private boolean ehExterno(No no){    
		//código Java faltando - apagar o return abaixo!!!
		  return false;
	  }
	  
	  private boolean ehRaiz(No no){   
		//código Java faltando - apagar o return abaixo!!!
		  return false;
	  }  
	  
	  public void pecorrerPreOrdem(){
		visitarPreOrdem(raiz);
	  }
	  
	  private void visitarPreOrdem(No no){    
		//código Java faltando
	  }

	  public void pecorrerInOrdem(){
		visitarInOrdem(raiz);
	  }
	  
	  private void visitarInOrdem(No no){
		//código Java faltando
	  }
	  
	  public void pecorrerPosOrdem(){
		visitarPosOrdem(raiz);
	  }
	  
	  private void visitarPosOrdem(No no){    
		//código Java faltando
	  }
	}