public class No {

	//definição dos atributos
	private int conteudo;
	private No proximo;
	
	//construtor No, o qual aponta proximo para null
	public No() {
		 this.proximo = null;
	}

	//pega o conteudo presente no No
	public int getConteudo() {
		return conteudo;
	}

	//atribui o conteudo do No
	public void setConteudo(int conteudo) {
		this.conteudo = conteudo;
	}

	//aponta para o proximo No
	public No getProximo() {
		return proximo;
	}

	//escolhe para qual No apontar
	public void setProximo(No proximo) {
		this.proximo = proximo;
	}
}
