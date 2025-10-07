import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Clinica {
    private PriorityQueue<Paciente> colaPacientes;

    public Clinica(){
        colaPacientes=new PriorityQueue<Paciente>();
    }

    public void encolar(Paciente p){
        colaPacientes.add(p);
    }

    public Paciente desencolar() throws Exception {
        if(colaPacientes.isEmpty()){
            throw new Exception("Cola sin elementos!");
        }
        return colaPacientes.poll();
    }

    public List<Paciente> listarPacientes(){
        return new ArrayList<>(colaPacientes);
    }
}
