import view.Home;

public class Main {
    /**
     * @Param args the command line arguments
     */

    public static void main(String[] args) {

        Home ventana =  new Home();
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(ventana);

    }
}
