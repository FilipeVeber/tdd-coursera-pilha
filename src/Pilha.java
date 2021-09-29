/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author filipe.veber
 */
public class Pilha {

    private final Object[] _elementos;
    private int _quantidade = 0;

    Pilha(int tamanho) {
        this._elementos = new Object[tamanho];
    }

    public Boolean estahVazia() {
        return this._quantidade == 0;
    }

    public Boolean estahCheia() {
        return this._quantidade == _elementos.length;
    }

    public int tamanho() {
        return this._quantidade;
    }

    public void empilha(Object elemento) {
        if (estahCheia()) {
            throw new PilhaCheiaException("Não é possível empilhar mais elementos.");
        }
        this._elementos[_quantidade] = elemento;
        this._quantidade++;
    }

    public Object topo() {
        return this._elementos[_quantidade - 1];
    }

    public Object desempilha() {
        if (estahVazia()) {
            throw new PilhaVaziaException("Não é possível desempilhar");
        }
        Object topo = this.topo();
        this._quantidade--;
        return topo;
    }
}
