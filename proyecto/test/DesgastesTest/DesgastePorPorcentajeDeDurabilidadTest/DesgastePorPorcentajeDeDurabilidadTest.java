package DesgastesTest.DesgastePorPorcentajeDeDurabilidadTest;

import Modelo.Desgastes.*;
import Modelo.Excepciones.HerramientaRotaException;
import org.hamcrest.CoreMatchers;
import org.junit.*;
import org.junit.rules.ExpectedException;

public class DesgastePorPorcentajeDeDurabilidadTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01DesgastePorPorcentajeDeDurabilidadSeCreaCorrectamente() {
        DesgastePorPorcentajeDeDurabilidad desgaste = new DesgastePorPorcentajeDeDurabilidad(5);
        Assert.assertNotNull(desgaste);
    }

    @Test
    public void test02DesgastePorPorcentajeDeDurabilidadHeredaDeDesgaste() {
        Assert.assertThat(new DesgastePorPorcentajeDeDurabilidad(5), CoreMatchers.instanceOf(DesgastePorPorcentaje.class));
    }

    @Test
    public void test03DesgastePorPorcentajeDeDurabilidadSeInicializaCon2DePorcentaje() {
        DesgastePorPorcentajeDeDurabilidad desgaste = new DesgastePorPorcentajeDeDurabilidad(2);
        Assert.assertEquals(desgaste.getPorcentaje(), 2, 0.0000001);
    }

    @Test
    public void test04DesgastePorPorcentajeDeDurabilidadAplicaBienElDesgaste() {
        int durabilidad = 110;
        DesgastePorPorcentajeDeDurabilidad desgaste = new DesgastePorPorcentajeDeDurabilidad(9);

        durabilidad = desgaste.aplicar(durabilidad);

        Assert.assertEquals(97, durabilidad);
    }

    @Test
    public void test05DesgastePorPorcentajeDeDurabilidadDevuelveErrorSiRecibe0DeDurabilidad(){
        int durabilidad = 0;
        DesgastePorPorcentajeDeDurabilidad desgaste = new DesgastePorPorcentajeDeDurabilidad(0.5);

        thrown.expect(HerramientaRotaException.class);
        desgaste.aplicar(durabilidad);
    }

}
