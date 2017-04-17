package com.passstorer.contraseasseguras;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class DatosUsuarioTest {

    public FixtureDummyPassw f = new FixtureDummyPassw(5);
    @Test
    public void fixtureListaTest() throws Exception {
        assertEquals(5,f.getListaDummyPassw().size());
    }

    @Test
    public void fixtureDatosGeneradosTest(){
        assertNotNull(f.getListaDummyPassw().get(0).getNombreServicio());
        assertEquals(5,f.getListaDummyPassw().get(0).getNombreServicio().length());
    }

    @Test
    public void fixtureDatosGeneradosTest2(){
        assertNull(f.getListaDummyPassw().get(0).getEmail());
        assertNull(f.getListaDummyPassw().get(0).getDatosExtras());
    }

    /*
    @Test
    public void verdatoscreados(){
        assertEquals("",f.getListaDummyPassw().get(0).getUsuario());
    }
    */
}