package sistema_radar;

public class Simulacao {
    public static void main(String[] args) {
        System.out.println("Simulação");

        Carro fiat = new Carro("UNO-2025", "uno", 76, 0);

        Radar radar = new Radar(60, "Pistão Sul");

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
