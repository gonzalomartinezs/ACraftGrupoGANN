public abstract class Herramienta {

    protected int fuerza;

    protected int durabilidad;

    Desgaste desgaste;


   public void golpear(Material material){

       //material.gastarCon(this);
       durabilidad = desgastar();

    }


    public int desgastar(){
       return desgaste.aplicar(durabilidad, fuerza);
    }

    public int getDurabilidad(){

       return durabilidad;
    }

    public int getFuerza(){
        return fuerza;
    }

}
