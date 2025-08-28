package sistema_radar;

public class Simulacao {
    public static void main(String[] args) {
        System.out.println("Simulação");

        Carro fiat = new Carro();
        fiat.ano = 76; 
        fiat.modelo = "uno";
        fiat.placa = "UNO-2025";
        fiat.velocidade = 0;

        Radar radar = new Radar();
        radar.limiteVelocidade = 60;
        radar.localizacao = "Pistão Sul";

        radar.avaliarVelocidade(fiat);

        fiat.acelerar();
        fiat.acelerar();
        fiat.acelerar();
        fiat.acelerar();
        fiat.acelerar();
        fiat.acelerar();
        fiat.acelerar();

        radar.avaliarVelocidade(fiat);

        fiat.frear();

        radar.avaliarVelocidade(fiat);

    }
}
