public class HachaDePiedra extends Hacha {

    public HachaDePiedra(){

        durabilidad = 200;
        fuerza = 5;
        desgaste = new DesgastePorPorcentajeDeFuerza(1, fuerza);

    }

    @Override
    public void golpear(Material material) {
        try {
            desgastar();
            material.gastarCon(this);
        } catch (MaterialNoSeDanioException e){}
    }
}