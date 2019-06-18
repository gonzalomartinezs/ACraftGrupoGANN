package Algocraft.Herramientas;

import Algocraft.Desgastes.DesgastePorPorcentajeDeFuerza;
import Algocraft.Excepciones.MaterialNoSeDanioException;
import Algocraft.MateriaPrima.MateriaPrima;
import Algocraft.MateriaPrima.MateriaPrimaPiedra;
import Algocraft.Materiales.Material;

public class HachaDeMadera extends Hacha {

    public HachaDeMadera(){

        durabilidad = 100;
        fuerza = 2;
        desgaste = new DesgastePorPorcentajeDeFuerza(1, fuerza);
    }

    @Override
    public MateriaPrima usarContra(Material material) {

        MateriaPrima materiaPrima = new MateriaPrima();

        try {
            desgastar();
            materiaPrima = material.gastarCon(this);

        } catch (MaterialNoSeDanioException e){}

        return materiaPrima;
    }
}
