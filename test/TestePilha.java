/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author filipe.veber
 */
public class TestePilha {

    private Pilha _pilha;

    @Before
    public void inicializarPilha() {
        _pilha = new Pilha(10);
    }

    @Test
    public void pilhaVazia() {
        assertTrue(_pilha.estahVazia());
        assertEquals(0, _pilha.tamanho());
    }

    @Test
    public void pilhaCheia() {
        for (int i = 0; i < 10; i++) {
            _pilha.empilha("Elemento " + i);
        }
        assertFalse(_pilha.estahVazia());
        assertEquals(10, _pilha.tamanho());
        assertTrue(_pilha.estahCheia());
    }

    @Test
    public void empilhaUmElemento() {
        _pilha.empilha("primeiro");
        assertFalse(_pilha.estahVazia());
        assertEquals(1, _pilha.tamanho());
        assertEquals("primeiro", _pilha.topo());
    }

    @Test
    public void empilhaEDesempilha() {
        _pilha.empilha("primeiro");
        _pilha.empilha("segundo");
        assertEquals(2, _pilha.tamanho());
        assertEquals("segundo", _pilha.topo());
        Object desempilhado = _pilha.desempilha();
        assertEquals(1, _pilha.tamanho());
        assertEquals("primeiro", _pilha.topo());
        assertEquals("segundo", desempilhado);
    }

    @Test(expected = PilhaVaziaException.class)
    public void removeDaPilhaVazia() {
        _pilha.desempilha();
    }

    @Test
    public void adicionaNaPilhaCheia() {
        for (int i = 0; i < 10; i++) {
            _pilha.empilha("Elemento " + i);
        }

        try {
            _pilha.empilha("Boom");
            fail();
        } catch (PilhaCheiaException e) {
        }
    }
}
