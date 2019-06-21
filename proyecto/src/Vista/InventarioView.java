package Vista;

import Controlador.BotonInventario;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class InventarioView {

    private GridPane grid;
    Group root;
    private final int anchoGrid = 4;
    private final int altoGrid = 4;
    private static InventarioView instancia_unica = null;

    public static InventarioView instaciar(Group root, double ancho, double alto){
        if(instancia_unica==null){
            instancia_unica = new InventarioView(root, ancho, alto);
        }
        return instancia_unica;
    }

    private InventarioView(Group root, double ancho, double alto){

        this.grid = new GridPane();
        this.root = root;

        for(int i=0; i<altoGrid; i++){
            for(int j=0; j<anchoGrid; j++) {
                grid.add(new BotonInventario(ancho), j, i, 1, 1);
            }
        }
        grid.setLayoutX(ancho*0.825);
        grid.setLayoutY(alto*0.16);

        root.getChildren().add(grid);
    }

    public void actualizarInventario(){

        ObservableList<Node> botones = grid.getChildren();

        for(Node hijo:botones){
            BotonInventario boton = (BotonInventario)hijo;
            boton.actualizar();
        }
    }

}