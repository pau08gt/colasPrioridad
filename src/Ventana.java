import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

public class Ventana {
    private JPanel principal;
    private JButton btnAtender;
    private JButton btnAgregar;
    private JTextArea txtListado;
    private JSpinner spiPrioridad;
    private JTextField txtNombre;
    private JTextField txtSintomas;
    Clinica cl=new Clinica();

    public Ventana() {
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int p = Integer.parseInt(spiPrioridad.getValue().toString());
                String nombre = txtNombre.getText();
                String sintomas = txtSintomas.getText();
                Paciente pa = new Paciente(p, nombre, sintomas);
                cl.encolar(pa);
                txtListado.setText("");
                List<Paciente> orden=cl.listarPacientes();
                Collections.sort(orden);
                for (Paciente paciente : orden) {
                    txtListado.append(paciente.toString() + "\n");
                }
            }
        });
        btnAtender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Paciente p=cl.desencolar();
                    txtListado.setText("");
                    List<Paciente> orden=cl.listarPacientes();
                    Collections.sort(orden);
                    for (Paciente paciente : orden) {
                        txtListado.append(paciente.toString() + "\n");
                    }
                    JOptionPane.showMessageDialog(null,
                            "Atendido: "+p.toString());
                } catch (Exception ex) {
                  JOptionPane.showMessageDialog(null,
                          ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
