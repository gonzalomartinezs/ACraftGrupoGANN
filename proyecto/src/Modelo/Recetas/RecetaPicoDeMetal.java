package Modelo.Recetas;

import Modelo.Herramientas.PicoDeMetal;

import java.util.ArrayList;
import java.util.Arrays;

public class RecetaPicoDeMetal extends Receta {

    public RecetaPicoDeMetal(){
        herramientaAsociada = new PicoDeMetal();
        receta = new ArrayList<>(Arrays.asList(METAL, METAL, METAL,
                                                      VACIO, MADERA, VACIO,
                                                      VACIO, MADERA, VACIO));
    }
}