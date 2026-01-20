import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

//Estamos en la clase "Ventana" y la clase Ventana -extiende- la clase JFrame
//La clase JFrame es una de las clases que nos da Java para crear ventanas de
//interfaz de usuario.
public class Ventana extends JFrame{

    //La ventana tendrá un campo de texto donde se desplegarán los resultados
    private JTextField tfRespuesta;
    //Un arreglo de botones donde meteremos a los números
    private JButton[] bNumeros;

    //Aquí, agregar los botones que usaremos para las operaciones
    //Por ejemplo
    private JButton bSumar;
    private JButton bLimpiar;

    Ventana(){
        //------Código cubierto durante la clase----------
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);

        this.tfRespuesta = new JTextField("Calculadora");
        this.tfRespuesta.setBorder(new LineBorder(Color.RED, 5));
        this.tfRespuesta.setPreferredSize(new Dimension(300, 300));

        this.bNumeros = generaBotonesNumeros();

        //--------------- nuevo código ------------------

        this.bLimpiar = new JButton("C");
        this.bSumar = new JButton("+");

        //TAREA
        //faltan los botones de restar, multiplicar, dividir y dar resultado 'igual'

        //---------- código de clase ----------------

        JPanel panelResultado = new JPanel();
        JPanel panelBotones = new JPanel();

        panelResultado.setLayout(new BorderLayout());
        panelBotones.setLayout(new GridLayout(4, 4));

        panelResultado.add(tfRespuesta);

        //------------ Tarea ----------------
        //Recordar que se tienen que agregar todos los botones a al panel de botones

        /*      Resultado deseado

            +---+---+---+---+
            |   Resultado   |
            +---+---+---+---+
            | 7 | 8 | 9 | C |
            +---+---+---+---+
            | 4 | 5 | 6 | + |
            +---+---+---+---+
            | 1 | 2 | 3 | - |
            +---+---+---+---+
            | 0 | = | * | / |
            +---+---+---+---+

         */

        //Hay que jugar un poco con el orden en el que se agregan los botones para
        //que se vea la calculadora como se desea
        //ATENCION : la gradilla es de 4*4 entonces sino están los 16 elementos
        //           es posible que se vean movidos todos los elementos, hay que agregar todos
        panelBotones.add(bNumeros[7]);
        panelBotones.add(bNumeros[8]);
        panelBotones.add(bNumeros[9]);
        panelBotones.add(bLimpiar);
        panelBotones.add(bNumeros[4]);
        panelBotones.add(bNumeros[5]);
        panelBotones.add(bNumeros[6]);
        panelBotones.add(bSumar);

        //----------- Código de la clase ------------
        this.setLayout(new BorderLayout());
        this.add(panelResultado, BorderLayout.NORTH);
        this.add(panelBotones, BorderLayout.CENTER);

        this.setVisible(true);
    }

    //Función para generar los botones del 0 -> 9
    public JButton[] generaBotonesNumeros(){
        JButton[] botones  = new JButton[10];
        for(int i = 0; i < 10; i++){
            botones[i] = new JButton(""+ i);
        }

        return botones;
    }

    public static void main(String[] args) {
        Ventana v = new Ventana();
    }

}

