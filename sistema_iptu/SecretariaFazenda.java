package sistema_iptu;

public class SecretariaFazenda {
    public static void main(String[] args) {
        Municipio municipio = new Municipio("Brasília", "DF", 31.5);
        Apartamento apt = new Apartamento(municipio, 63.0, 0, true);
        Chacara chacara = new Chacara(municipio, 150.0, 2, true);
        Casa casa = new Casa(municipio, 100.0, 1);

        System.out.println("IPTU Apartamento: " + apt.calcularIPTU());
        System.out.println("IPTU Chacara: " + chacara.calcularIPTU());
        System.out.println("IPTU Casa: " + casa.calcularIPTU());
    }
}