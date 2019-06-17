package HerramientasTest.PicosTest;

import Algocraft.Herramientas.Herramienta;
import Algocraft.Herramientas.PicoDePiedra;
import Algocraft.Materiales.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class PicoDePiedraTest {

    @Test
    public void test01PicoDePiedraSeCreaCon200DeDurabilidad() {
        Herramienta pico = new PicoDePiedra();
        assertEquals(200, pico.getDurabilidad());
    }

    @Test
    public void test02PicoDePiedraSeCreaCon4DeFuerza() {
        Herramienta pico = new PicoDePiedra();
        assertEquals(4, pico.getFuerza());
    }

    @Test
    public void test03SeUsaPicoDePiedraContraMaderaYPierde3DeDurabilidad(){

        Herramienta pico = new PicoDePiedra();
        Material madera = new Madera();
        pico.usarContra(madera);

        assertEquals(197, pico.getDurabilidad());

    }

    @Test
    public void test04SeUsaPicoDePiedraContraPiedraYPierde3DeDurabilidad(){

        Herramienta pico = new PicoDePiedra();
        Material piedra = new Piedra();
        pico.usarContra(piedra);

        assertEquals(197, pico.getDurabilidad());

    }

    @Test
    public void test05SeUsaPicoDePiedraContraMetalYPierde3DeDurabilidad(){

        Herramienta pico = new PicoDePiedra();
        Material metal = new Metal();
        pico.usarContra(metal);

        assertEquals(197, pico.getDurabilidad());

    }

    @Test
    public void test06SeUsaPicoDePiedraContraDiamanteYPierde3DeDurabilidad(){
        Herramienta pico = new PicoDePiedra();
        Material diamante = new Diamante();
        pico.usarContra(diamante);

        assertEquals(197, pico.getDurabilidad());

    }

}
