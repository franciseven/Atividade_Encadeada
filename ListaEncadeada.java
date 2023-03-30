public class ListaEncadeada extends No implements Lista  {
	
	//definindo os atributos
	private No cabeca;
	private int tamanho;
	
	//fazendo com que a variavel No cabeca aponte para null e que a lista receba tamanho 0
	public ListaEncadeada() {
		this.cabeca = null;
		this.tamanho = 0;
	}
	
//verificando se a lista está vazia, retornando true caso esteja
@Override
public boolean vazia() {
	if(this.tamanho == 0) 
	
	return true; 
	
	else return false;
}


//Verifica se a lista está cheia
@Override
public boolean cheia() {
	return false;
}


//verifica o tamanho da lista
@Override
public int tamanho() {
	return this.tamanho;
}


/*
 * Obtém o i-ésimo elemento de uma lista e retorna o valor encontrado
 */
@Override
public int elemento(int pos) {
	No aux = this.cabeca;
	int cont = 1;
	
	if(vazia()) return -1; //retornando -1 caso a lista esteja vazia
	
	if(pos < 1 || pos > this.tamanho) return -1; //posição inválida
	
	//percorrendo a lista do 1º elemento até o pos
	while(cont < pos) {
		
		aux = aux.getProximo();
		cont++;
	}
	
	return aux.getConteudo();
	
}
	
/*
 * modificando o valor da posição encontrada pelo valor passado, retornando false se a lista estiver vazia e se a posição for menor do que 1 ou maior do que o tamanho
 */
public boolean modificaElemento(int valor, int pos) {
	No aux = this.cabeca;
	int cont = 1;
	
	if(vazia()) return false;
	
	if(pos < 1 || pos > this.tamanho) return false;
	
	while(cont < pos) {
		
		aux = aux.getProximo();
		cont++;
	}

	aux.setConteudo(valor);

return true;
	
}


/*
 * função que retorna a posição de um elemento específico, retornando -1 caso não seja encontrado
 */
@Override
public int posição(int dado) {
	int cont = 1;
	No aux;
	
	if(vazia()) return 0;
	
	aux = cabeca;
	while(aux != null) {
		
		if(aux.getConteudo() == dado) return cont;
		
		aux = aux.getProximo();
		cont++;
	}
	
	return -1;
}

/*
 * inserindo um elemento em uma determinada posição, retornando true caso seja possível inserir e retornando false caso não consiga
 */
@Override
public boolean insere(int pos, int dado) {

	if(vazia() && pos != 1) return false;
	
	if(pos == 1) { //inserindo no início da lista
		return insereInicioDaLista(dado);
	}
	else if(pos == tamanho) { //inserindo no fim da lista
		return insereFimDaLista(dado);
	}
	else{ //inserindo no meio da lista
		return insereMeioLista(pos, dado);
	}
	
}

/*
 * inserindo nó na lista vazia
 */
private boolean insereInicioDaLista(int valor) {
	No novoNo = new No();
	
	//inserindo um novo elemento na cabeça da lista
	novoNo.setConteudo(valor);
	novoNo.setProximo(this.cabeca);
	this.cabeca = novoNo;
	this.tamanho++;
	
	return true;
}

/*
 * inserindo nó no meio da lista
 */
private boolean insereMeioLista(int pos, int dado) {
	int cont = 1;
	No novoNo = new No(); //instanciando novoNo
	novoNo.setConteudo(dado);
	
	//localizando a posição onde será inserido o novo nó
	No aux = this.cabeca;
	while(cont < pos-1 && aux != null) {
	
		aux = aux.getProximo();
		cont++;
		
	}
	
	if(aux == null) return false;
	
	novoNo.setProximo(aux.getProximo());
	aux.setProximo(novoNo);
	tamanho++;
	
	return true;
	
}

/*
 * inserindo nó no fim da lista
 */
private boolean insereFimDaLista(int dado) {
	No novoNo = new No();
	novoNo.setConteudo(dado);
	
	//procurando o final da lista
	No aux = this.cabeca;
	while(aux.getProximo() != null) {
		aux = aux.getProximo();
	}
	
	novoNo.setProximo(null);
	aux.setProximo(novoNo);
	this.tamanho++;
	
	return true;
}

/*
 * remove um elemento de uma determinada posição
 * retorna o valor a ser removido.
 * retorna -1 se a posição for inválida ou se a lista for vazia 
 */
@Override
public int remove(int pos) {
	
	if (vazia()) return -1;
	
	//removendo elemento da cabeça da lista
	if(pos == 1) {
		return removeInicioDaLista();
	}
	
	//removendo em outro lugar da lista
	else {
		return removeNaLista(pos);
	}
}


/*
 * remove elemento no início da lista
 */
private int removeInicioDaLista() {
	
	No p = this.cabeca;
	int dado = p.getConteudo();
	
	//remove o 1º elemento na lista (p)
	this.cabeca = p.getProximo();
	this.tamanho--;
	//liberando memória na região apontada por p
	p = null;
	
	return dado;
}

/*
 * remove um elemento no meio da lista
 */
private int removeNaLista(int pos) {
	
	No atual = null;
	No antecessor = null;
	int dado = -1;
	int cont = 1;
	
	atual = this.cabeca;
	
	while(cont < pos && atual != null) {
		
		antecessor = atual;
		atual = atual.getProximo();
		cont++;
		
	}
	
	if(atual == null) return -1;
	
	//retirando o elemento da lista
	dado = atual.getConteudo();
	antecessor.setProximo(atual.getProximo());
	this.tamanho++;
	//liberando a memória da região apontada
	atual = null;
	return dado;
}

}
