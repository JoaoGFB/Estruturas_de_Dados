package Dinamicas;

import InterfacesAtividade.IEstruturaDinamica;
import Nos.No;
import Nos.NoInteger;

import java.util.List;

public class PhilaDinamicaInteger implements IEstruturaDinamica {
    private NoInteger  primeiro;
    private NoInteger ultimo;

    //Métodos da interface

    @Override
    public void inserirElemento(Object elemento) {
        //Gabriel
    }

    @Override
    public void inserirSequencia(Object elementos) {
        //Gabriel
    }

    @Override
    public boolean removerElemento(Object elemento) {
        //Existe algo simmilar, mas é a remoção considerando a regra da estrutura
        //João
        if (vazia()) {
            return false;
        }

        Integer valor = (Integer) elemento;
        NoInteger aux = primeiro;

        while (aux != null) {
            if (aux.getConteudo().equals(valor)) {
                if (aux.getAnterior() != null) {
                    aux.getAnterior().setProximo(aux.getProximo());
                } else {
                    this.primeiro = aux.getProximo();
                }

                if (aux.getProximo() != null) {
                    aux.getProximo().setAnterior(aux.getAnterior());
                } else {
                    this.ultimo = aux.getAnterior();
                }

                return true;
            }
            aux = aux.getProximo();
        }
        return false;
    }

    @Override
    public void removerSequencia(Object elementos) {
        //João
        if (vazia()) {
            System.out.println("A pilha está vazia. Nada a remover.");
            return;
        }
        List<Integer> lista = (List<Integer>) elementos;
        for (int i = 0; i < lista.size(); i++) {
            removerTodasOcorrencias(lista.get(i));
        }
        System.out.println("Sequência removida da pilha.");
    }

    @Override
    public void removerTodasOcorrencias(Object elemento) {
        //João
        int removidos = 0;
        while (removerElemento(elemento)) {
            removidos++;
        }
        System.out.println(removidos + " ocorrência(s) do elemento [" + elemento + "] removida(s).");
    }

    @Override
    public void limpar() {
        //João
        this.primeiro = null;
        this.ultimo = null;
    }

    @Override
    public boolean estaCheia() {
        return false;
        //Não precisa fazer
    }



    //Importante lembrar que este buscar elemento também buscará pelo peso então se tiver peso é bom saber.
    //Caso o usuário não saiba o peso por padrão sempre é bom lembrar que o peso é 1
    //E mais importante o peso também poderia ser boolena (true), (false), caso tena mais de um nivel
    // de peso ao invez de apenas 0 e 1.
    @Override
    public boolean buscarElemento(Integer conteudo, Integer peso) {
        NoInteger aux = this.primeiro;

        if (vazia()){
            return false;
        } else {
            do {
                if (aux.getConteudo()==conteudo&&aux.getPeso()==peso){
                    return true;
                }
                aux= aux.getProximo();
            }while (aux!=ultimo.getProximo());
            return false;
        }

    }

    @Override
    public void ordenarCrescente() {
        //Yuri
    }

    @Override
    public void ordenarDecrescente() {
        //Yuri
    }

    @Override
    public int quantidadeElementos() {
        return 0;
        //Yuri
    }

    @Override
    public void editarElemento(Object elementoAntigo, Object elementoNovo) {
        //Gabriel
    }

    @Override
    public void exibir() {
        //Já existem com outro nome
    }

    @Override
    public No obterPrimeiroElemento() {
        return null;
        //Já existem com outro nome
    }

    @Override
    public No obterUltimoElemento() {
        return null;
        //Já existem com outro nome
    }

    //Metodos Normais

    public void mostrarPhila (){
        NoInteger aux = this.primeiro;

        if (vazia()) {
            System.out.println("A Pilha está vazia");
        }
        else {
            System.out.println("Phila:");
            do {
                System.out.println("Conteudo[" + aux.getConteudo() + "] " +  "Peso["+aux.getPeso()+"]");
                aux = aux.getProximo();
            } while (aux!=ultimo.getProximo());

        }
    }

    public void adicionarPilha (Integer conteudo, Integer peso){
        NoInteger novoNo = new NoInteger();
        novoNo.setConteudo(conteudo);
        novoNo.setPeso(peso);
        if(vazia()) {
            this.primeiro = novoNo;
            this.ultimo = this.primeiro;
        } else {
            this.ultimo.setProximo(novoNo);
            novoNo.setAnterior(this.ultimo);
            this.ultimo=novoNo;
        }
    }

    public void removerPhila () {
        NoInteger aux = ultimo;
        NoInteger aux2;
        if (!vazia()) {

            if (this.ultimo == this.primeiro) {
                this.primeiro = null;
            } else if (this.ultimo.getAnterior().getPeso() > 0) {
                // problema acontece quando o peso for no primero.
                if (this.ultimo.getAnterior()==this.primeiro){
                    aux = this.primeiro;
                    this.primeiro=this.ultimo;
                    this.primeiro.setProximo(null);
                    aux=null;
                } else {
                    aux2=aux.getAnterior();
                    aux = aux.getAnterior().getAnterior();
                    this.ultimo.setAnterior(ultimo.getAnterior().getAnterior());
                    aux.setProximo(ultimo);
                    aux2=null;
                }
            } else {
                this.ultimo = ultimo.getAnterior();
                this.ultimo.setProximo(null);
            }
        } else {
            System.out.println("A pilha está vazia");
        }
    }




    // Metodos segundarios
    public boolean vazia () {
        if (this.primeiro == null) {
            return true;
        }else {return false;}
    }

    public void ultimoElemento (){
        System.out.println("O ultimo da fila é "+ultimo.getConteudo()+" com peso de"+ultimo.getPeso());
    }



    //Get and Set

    public NoInteger getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(NoInteger primeiro) {
        this.primeiro = primeiro;
    }

    public NoInteger getUltimo() {
        return ultimo;
    }

    public void setUltimo(NoInteger ultimo) {
        this.ultimo = ultimo;
    }

}


