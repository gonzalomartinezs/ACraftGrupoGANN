package Algocraft.Herramientas;

import Algocraft.Construccion.MesaDeCrafteo;
import Algocraft.Desgastes.Desgaste;
import Algocraft.Excepciones.NoSePuedeAnadirUtilizableAMesa;
import Algocraft.Inventario.Utilizable;
import Algocraft.MateriaPrima.MateriaPrima;
import Algocraft.Materiales.Material;

public abstract class Herramienta implements Utilizable {

    //Atributos
    protected int fuerza;

    protected int durabilidad;

    protected Desgaste desgaste;


    //Métodos

    public void desgastar(){

        durabilidad = desgaste.aplicar(durabilidad);
    }

    public int getDurabilidad(){
       return durabilidad;
    }

    public int getFuerza(){
        return fuerza;
    }

    @Override
    public void ubicarse(MesaDeCrafteo mesa, int posicion){
        throw new NoSePuedeAnadirUtilizableAMesa();
    }

}
