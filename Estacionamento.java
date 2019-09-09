public class Estacionamento {
    /*ATRIBUTOS */
    private int box;
    private String placa;
    private String porte;
    private double entrada;
    private boolean ocupado;
    private double saida;

    /* Getters e Setters */
    public void setBox(int box) {
        this.box = box;
    }

    public int getBox() {
        return box;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getPorte() {
        return porte;
    }

    public void setEntrada(double entrada) {
        this.entrada = entrada;
    }

    public double getEntrada() {
        return entrada;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public boolean getOcupado() {
        return ocupado;
    }

    public void setSaida(double saida) {
        this.saida = saida;
    }

    public double getSaida() {
        return saida;
    }
    
    /*CONSTRUTOR*/
    public Estacionamento (int box, String placa, String porte, double entrada, boolean ocupado) {
        this.box = box;
        this.placa = placa;
        this.porte = porte;
        this.entrada = entrada;
        this.ocupado = ocupado;
        saida = 0;
    }

    

    /*CONSTRUTOR*/


    /*METODOS */
    private double  diferancaHora (double entrada, double saida){
        double retorno;
        retorno = saida - entrada;
        return retorno;
    }
    
    public double valorEstacionamento () {
        double valorAPagar = 0;
        if (porte.equals("P")){
            valorAPagar = (diferancaHora(entrada, saida)) * 3;
        }else if(porte.equals("M")){
            valorAPagar = (diferancaHora(entrada, saida)) * 5;
        }else if(porte.equals("G")){
            valorAPagar = (diferancaHora(entrada, saida)) * 10;
        }
        return valorAPagar;
    }


    public String toString () {
        String retorna = "";
        retorna +=  (getOcupado() ? " [ BOX = "+getBox() + ", Hora entrada = "+ getEntrada() + ", Placa= " + getPlaca() + ", Porte = " + getPorte() + " ]" : ""); 
        return retorna;
    }
    /*METODOS */
}