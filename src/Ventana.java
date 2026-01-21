import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JButton bRestar;
    private JButton bLimpiar;
    private JButton bMultiplicar;
    private JButton bDivision;
    private JButton bIgual;


    private boolean primerArgumentoListo = false;
    private double primerArgumento = 0;
    private char operador = 'N';
    private boolean segundoArgumentoListo = false;
    private boolean primeraOperacion = true;

    Ventana(){
        //------Código cubierto durante la clase----------
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(400, 600);
        this.setLocationRelativeTo(null);

        this.tfRespuesta = new JTextField("Calculadora");
        //this.tfRespuesta.setBorder(new LineBorder(Color.RED, 5));
        this.tfRespuesta.setPreferredSize(new Dimension(200, 200));
        this.tfRespuesta.setEnabled(false);
        this.tfRespuesta.setHorizontalAlignment(JTextField.RIGHT);

        this.bNumeros = generaBotonesNumeros();

        //--------------- nuevo código ------------------

        this.bLimpiar = new JButton("C");
        this.bSumar = new JButton("+");

        //TAREA
        //faltan los botones de restar, multiplicar, dividir y dar resultado 'igual'
        this.bRestar = new JButton("-");
        this.bDivision = new JButton("/");
        this.bMultiplicar = new JButton("*");
        this.bIgual = new JButton("=");

        new JButton();
        this.bLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                primerArgumento = 0;
                operador = 'N';
                tfRespuesta.setText("");
                primerArgumentoListo = false;
            }
        });

        this.bSumar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                primerArgumento = Double.parseDouble(tfRespuesta.getText());
                String textoActual = tfRespuesta.getText();
                tfRespuesta.setText("");
                operador = '+';
                primerArgumentoListo = true;
            }
        });

        this.bRestar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                primerArgumento = Double.parseDouble(tfRespuesta.getText());
                String textoActual = tfRespuesta.getText();
                tfRespuesta.setText("");
                operador = '-';
                primerArgumentoListo = true;
            }
        });

        this.bDivision.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                primerArgumento = Double.parseDouble(tfRespuesta.getText());
                String textoActual = tfRespuesta.getText();
                tfRespuesta.setText("");
                operador = '/';
                primerArgumentoListo = true;
            }
        });

        this.bMultiplicar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                primerArgumento = Double.parseDouble(tfRespuesta.getText());
                String textoActual = tfRespuesta.getText();
                tfRespuesta.setText("");
                operador = '*';
                primerArgumentoListo = true;
            }
        });

        this.bIgual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double resultado = 0;
                double segundoArgumento = Double.parseDouble(tfRespuesta.getText());


                switch (operador){
                    case '+':
                        resultado = primerArgumento + segundoArgumento;
                        break;
                    case '-':
                        resultado = primerArgumento - segundoArgumento;
                        break;
                    case '/':
                        resultado = primerArgumento / segundoArgumento;
                        break;
                    case '*':
                        resultado = primerArgumento * segundoArgumento;
                        break;
                }

                tfRespuesta.setText("" + resultado);
            }
        });





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
        panelBotones.add(bNumeros[1]);
        panelBotones.add(bNumeros[2]);
        panelBotones.add(bNumeros[3]);
        panelBotones.add(bRestar);
        panelBotones.add(bNumeros[0]);
        panelBotones.add(bIgual);
        panelBotones.add(bMultiplicar);
        panelBotones.add(bDivision);

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
            botones[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (primeraOperacion){
                        tfRespuesta.setText("");
                        primeraOperacion = false;

                    }
                    JButton botonNumero = (JButton) e.getSource();
                    String textoActual = tfRespuesta.getText();
                    tfRespuesta.setText(textoActual + botonNumero.getText());

                }
            });
        }

        return botones;
    }

    public static void main(String[] args) {

        FlatLightLaf.setup();


        Ventana v = new Ventana();
    }

}

