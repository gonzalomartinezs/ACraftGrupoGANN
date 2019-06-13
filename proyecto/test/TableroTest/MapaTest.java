package TableroTest;

import Algocraft.Excepciones.PosicionOcupadaException;
import Algocraft.Jugador.Jugador;
import Algocraft.Materiales.*;
import Algocraft.Posicion.Posicion;
import Algocraft.Tablero.Mapa;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MapaTest {

    private void limpiar(){
        int alto = 81;
        int ancho = 61;

        Mapa mapa = Mapa.instanciar();
        Posicion[][] _mapa = mapa.getMapa();

        for(int i = 0; i < ancho; i++){
            for(int j = 0; j < alto; j++){

            }
        }
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01MapaSeInstanciaConUnMetodoPropio(){
        Mapa mapa = Mapa.instanciar();
        Assert.assertNotNull(mapa);
    }

    @Test
    public void test02MapaNoPuedeInstanciarse2Veces(){
        limpiar();
        Mapa mapa1 = Mapa.instanciar();
        Mapa mapa2 = Mapa.instanciar();

        Assert.assertEquals(mapa1, mapa2);
    }

    @Test
    public void test03MapaSeCreaConUnaPosicionOcupadaEnElCentro(){
        limpiar();
        int alto = 81;
        int ancho = 61;

        Mapa mapa = Mapa.instanciar();
        Posicion[][] _mapa = mapa.getMapa();

        Assert.assertTrue((_mapa[ancho/2][alto/2]).estaOcupada());
    }

    @Test
    public void test04MapaSeCreaConElJugadorEnElCentro(){
        limpiar();
        int alto = 81;
        int ancho = 61;

        Mapa mapa = Mapa.instanciar();
        Posicion[][] _mapa = mapa.getMapa();

        Assert.assertTrue((_mapa[ancho/2][alto/2]).getOcupante() instanceof  Jugador);
    }

    @Test
    public void test05MapaTieneAlmenos1Madera(){
        limpiar();
        int alto = 81;
        int ancho = 61;

        Mapa mapa = Mapa.instanciar();
        mapa.inicializar();
        Posicion[][] _mapa = mapa.getMapa();
        int total = 0;

        for(int i = 0; i < ancho; i++){
            for(int j = 0; j < alto; j++){
                if((_mapa[i][j]).getOcupante() instanceof Madera){
                    total++;
                }
            }
        }

        Assert.assertTrue(total > 0);
    }

    @Test
    public void test06MapaTieneAlmenos1Metal(){
        limpiar();
        int alto = 81;
        int ancho = 61;

        Mapa mapa = Mapa.instanciar();
        mapa.inicializar();
        Posicion[][] _mapa = mapa.getMapa();
        int total = 0;

        for(int i = 0; i < ancho; i++){
            for(int j = 0; j < alto; j++){
                if((_mapa[i][j]).getOcupante() instanceof Metal){
                    total++;
                }
            }
        }

        Assert.assertTrue(total > 0);
    }

    @Test
    public void test07MapaTieneAlmenos1Piedra(){
        limpiar();
        int alto = 81;
        int ancho = 61;

        Mapa mapa = Mapa.instanciar();
        mapa.inicializar();
        Posicion[][] _mapa = mapa.getMapa();
        int total = 0;

        for(int i = 0; i < ancho; i++){
            for(int j = 0; j < alto; j++){
                if((_mapa[i][j]).getOcupante() instanceof Piedra){
                    total++;
                }
            }
        }

        Assert.assertTrue(total > 0);
    }

    @Test
    public void test08MapaTieneAlmenos1Diamante(){
        limpiar();
        int alto = 81;
        int ancho = 61;

        Mapa mapa = Mapa.instanciar();
        mapa.inicializar();
        Posicion[][] _mapa = mapa.getMapa();
        int total = 0;

        for(int i = 0; i < ancho; i++){
            for(int j = 0; j < alto; j++){
                if((_mapa[i][j]).getOcupante() instanceof Diamante){
                    total++;
                }
            }
        }

        Assert.assertTrue(total > 0);
    }

//    @Test
//    public void testintermedia(){
//        limpiar();
//        int alto = 81;
//        int ancho = 61;
//
//        Mapa mapa = Mapa.instanciar();
//        Posicion[][] _mapa = mapa.getMapa();
//        int total = 0;
//
//        for(int i = 0; i < ancho; i++){
//            for(int j = 0; j < alto; j++){
//                if((_mapa[i][j]).getOcupante() instanceof Diamante){
//                    total++;
//                }
//            }
//        }
//
//        Assert.assertTrue(total > 0);
//    }

    @Test
    public void test09MapaPermiteOcuparUnCasilleroVacioAUnJugador(){
        limpiar();
        Mapa mapa = Mapa.instanciar();
        Posicion[][] _mapa = mapa.getMapa();
        Posicion jugador = new Posicion(Jugador.crearUnico(), 3, 3);

        Assert.assertFalse(_mapa[3][3].estaOcupada());
        mapa.ubicar(jugador);
        Assert.assertTrue(_mapa[3][3].estaOcupada());
    }

    @Test
    public void test10MapaPermiteOcuparUnCasilleroVacioAUnMaterial(){
        limpiar();
        Mapa mapa = Mapa.instanciar();
        Posicion[][] _mapa = mapa.getMapa();
        Posicion material = new Posicion(new Metal(), 3, 3);

        Assert.assertFalse(_mapa[3][3].estaOcupada());
        mapa.ubicar(material);
        Assert.assertTrue(_mapa[3][3].estaOcupada());
    }

    @Test
    public void test11MapaNoPermitePosicionarUnObjetoPosicionableDondeYaSeEncuentraUnoPosicionable(){
        limpiar();
        Mapa mapa = Mapa.instanciar();
        Posicion material1 = new Posicion(new Madera(), 6, 8);
        Posicion material2 = new Posicion(new Diamante(), 6, 8);
        Posicion[][] _mapa = mapa.getMapa();

        mapa.ubicar(material1);
        Assert.assertTrue(_mapa[6][8].estaOcupada());

        thrown.expect(PosicionOcupadaException.class);
        mapa.ubicar(material2);
    }
}
