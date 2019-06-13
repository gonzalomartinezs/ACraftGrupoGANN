package JuegoTest;

import Algocraft.Juego.Juego;
import Algocraft.Jugador.Jugador;
import Algocraft.Posicion.Posicion;
import Algocraft.Tablero.Mapa;
import org.junit.*;
import org.hamcrest.*;


public class JuegoTest {

    @Test
    public void test01JuegoSeCrea() {
        Juego juego = Juego.crearUnico();
        Assert.assertNotNull(juego);
    }

    @Test
    public void test02SeCreanDosInstanciasDeJuegoYEsLaMisma(){
        Juego juegoUno = Juego.crearUnico();
        Juego juegoDos = Juego.crearUnico();

        Assert.assertEquals(juegoUno, juegoDos);
    }

    @Test
    public void test03JuegoInstanciaAMapaCorrectamente(){
        Juego juego = Juego.crearUnico();
        Mapa mapa = juego.getMapa();

        Assert.assertNotNull(mapa);
    }

    @Test
    public void test04SeMueveAlJugadorHaciaArriba(){  //Modificar a que juego le pase los parametros del campo al mapa
        int alto = 45;
        int ancho = 81;

        Juego juego = Juego.crearUnico();
        Mapa mapa = juego.getMapa();
        Posicion[][] _mapa = mapa.getMapa();

        mapa.moverJugadorArriba();

        Assert.assertFalse(_mapa[ancho/2][alto/2].estaOcupada());
        Assert.assertTrue(_mapa[ancho/2][(alto/2) - 1].estaOcupada());

    }

    @Test
    public void test05SeMueveAlJugadorHaciaAbajo(){
        int alto = 45;
        int ancho = 81;

        Juego juego = Juego.crearUnico();
        Mapa mapa = juego.getMapa();
        Posicion[][] _mapa = mapa.getMapa();

        mapa.moverJugadorAbajo();

        Assert.assertFalse(_mapa[ancho/2][alto/2].estaOcupada());
        Assert.assertTrue(_mapa[ancho/2][(alto/2) + 1].estaOcupada());
    }

    @Test
    public void test06SeMueveAlJugadorHaciaIzquierda(){
        int alto = 45;
        int ancho = 81;

        Juego juego = Juego.crearUnico();
        Mapa mapa = juego.getMapa();
        Posicion[][] _mapa = mapa.getMapa();

        mapa.moverJugadorIzquierda();

        Assert.assertFalse(_mapa[ancho/2][alto/2].estaOcupada());
        Assert.assertTrue(_mapa[(ancho/2) - 1][(alto/2)].estaOcupada());
    }

    @Test
    public void test07SeMueveAlJugadorHaciaDerecha(){
        int alto = 45;
        int ancho = 81;

        Juego juego = Juego.crearUnico();
        Mapa mapa = juego.getMapa();
        Posicion[][] _mapa = mapa.getMapa();

        mapa.moverJugadorDerecha();

        Assert.assertFalse(_mapa[ancho/2][alto/2].estaOcupada());
        Assert.assertTrue(_mapa[(ancho/2) + 1][(alto/2)].estaOcupada());
    }
}
