/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturas;

import java.util.Iterator;
import java.util.List;
import model.Cidadao;
import model.GestaoAtendimento;
import model.Reparticao;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Raúl Correia <1090657@isep.ipp.pt>
 */
public class RegistoCidadaoIT {

    GestaoAtendimento ga;

    public RegistoCidadaoIT() {
        ga = new GestaoAtendimento();
        ga.lerFicheirosDados();
    }

    /**
     * Test of adicionarCidadao method, of class RegistoCidadao.
     */
    @Test
    public void testAdicionarCidadao() {
        System.out.println("adicionarCidadao");

        //Vamos adicionar um cidadão novo
        Cidadao c = new Cidadao("José", 1234567L, "email@email.pt", "4200-066", 1234);

        boolean expResult = true;
        boolean result = ga.adicionarCidadao(c);
        assertEquals(expResult, result);

        //Vamos adicionar um cidadão repetido
        Cidadao cd = new Cidadao("Ana", 111222333L, "ana@gmail.com", "4200-072", 1234);
        expResult = false;
        result = ga.adicionarCidadao(cd);
        assertEquals(expResult, result);
    }

    /**
     * Test of obterCidadaosPorCodigoPostal method, of class RegistoCidadao.
     */
    @Test
    public void testObterCidadaosPorCodigoPostal() {
        System.out.println("obterCidadaosPorCodigoPostal");
        RegistoCidadao reg = new RegistoCidadao();
        Reparticao porto = ga.obterReparticaoPorCodigoPostal("4200");
        Cidadao a = new Cidadao("Ana", 111222333L, "ana@gmail.com", "4200-072", 1234);
        Cidadao b = new Cidadao("Berta", 223344L, "berta@gmail.com", "4200-071", 1234);
        Cidadao c = new Cidadao("Manuel", 584769L, "manuel@gmail.com", "4715-357", 1235);
        Cidadao d = new Cidadao("Carlos", 11223344L, "carlos@gmail.com", "4300-010", 1236);
        
        reg.adicionarCidadao(a);
        reg.adicionarCidadao(b);
        reg.adicionarCidadao(c);
        reg.adicionarCidadao(d);
        
        List<Cidadao> expResult = reg.obterCidadaosPorCodigoPostal(porto);
        List<Cidadao> result = ga.obterCidadaosPorCodigoPostal(porto);
        assertEquals(expResult, result);
    }


}
