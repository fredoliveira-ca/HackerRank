package binary_tree;

public class No {
	private int mat;   /* armazena matricula do aluno - valor inteiro */
	private String nome; /* armazena nome do aluno */
	private No pai;      /* armazena referência para o binary_tree.No pai desse binary_tree.No */
	private No filhoEsq; /* armazena referência para o binary_tree.No filho da esquerda desse binary_tree.No */
	private No filhoDir; /* armazena referência para o binary_tree.No filho da direita desse binary_tree.No */
	public No(int mat, String nome){ /* construtor passando o valor inteiro do binary_tree.No */
		this.mat = mat;
		this.nome = nome;
	}
	public int getMatricula(){
		return mat;
	}
	public void setMatricula(int mat){
		this.mat = mat;
	}
	public String getNome(){
		return nome;
	}	
	public void setNome(String nome){
		this.nome = nome;
	}
	public No getFilhoEsq(){
		return filhoEsq;
	}
	public void setFilhoEsq(No no){
		filhoEsq = no;
	}
	public No getFilhoDir(){
		return filhoDir;
	}
	public void setFilhoDir(No no){
		filhoDir = no;
	}
	public No getPai(){
		return pai;
	}
	public void setPai(No no){
		pai = no;
	}


}
