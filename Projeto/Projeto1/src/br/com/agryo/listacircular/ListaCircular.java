package br.com.agryo.listacircular;

public class ListaCircular<T> {
    private No<T> cabeca;
    private No<T> cauda;
    private int tamanhoLista;

    public ListaCircular() {
        this.cabeca = null;
        this.cauda = null;
        this.tamanhoLista = 0;
    }

    public void add(T conteudo){
        No<T> novoNo = new No<>(conteudo);
        if (this.tamanhoLista == 0){
            this.cabeca = novoNo;
            this.cauda = this.cabeca;
            this.cabeca.setPriximoNo(cauda);
        }else {
            novoNo.setPriximoNo(this.cauda);
            this.cabeca.setPriximoNo(novoNo);
            this.cauda = novoNo;
        }
        this.tamanhoLista++;
    }
    public void remove(int index){
        if (index >= tamanhoLista)
            throw new IndexOutOfBoundsException("O indice é maior que o tamanho da lista.");
        No<T> noAuxiliar = this.cauda;
        if (index == 0){
            this.cauda = this.cauda.getPriximoNo();
            this.cabeca.setPriximoNo(this.cauda);
        }else if(index == 1){
            this.cauda.setPriximoNo(this.cauda.getPriximoNo().getPriximoNo());
        }else {
            for (int i = 0; (i < index-1); i++){
                noAuxiliar = noAuxiliar.getPriximoNo();
            }
            noAuxiliar.setPriximoNo(noAuxiliar.getPriximoNo().getPriximoNo());
        }
        this.tamanhoLista--;
    }
    public T get(int index){
        return this.getNo(index).getConteudo();
    }

    private No<T> getNo(int index){
        if (this.isEmpty()){
            throw new IndexOutOfBoundsException("A lista está vazia.");
        }
        if (index == 0){
            return this.cauda;
        }
        No<T> noAuxiliar = this.cauda;
        for (int i = 0; (i < index) && (noAuxiliar != null); i++){
            noAuxiliar = noAuxiliar.getPriximoNo();
        }
        return noAuxiliar;
    }

    public boolean isEmpty(){
        return this.tamanhoLista == 0 ? true : false;
    }

    public int size(){
        return this.tamanhoLista;
    }

    @Override
    public String toString() {
        String strRetorno = "";
        No<T> noAuxiliar = this.cauda;
        for (int i = 0; i < this.size(); i++){
            strRetorno += "[No{conteudo= " + noAuxiliar.getConteudo() + " }]--->";
            noAuxiliar = noAuxiliar.getPriximoNo();
        }
        strRetorno += this.size() != 0 ? "(Retorna ao inicio)" : "[ VAZIO ]";
        return strRetorno;
    }
}
