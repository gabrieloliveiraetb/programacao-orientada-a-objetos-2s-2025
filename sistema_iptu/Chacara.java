package sistema_iptu;

public class Chacara extends Imovel {
    private Boolean possuiPoçoArtesiano;

    public Chacara(Municipio municipio, Double areaM2, Integer vagas, Boolean possuiPoçoArtesiano) {
        super(municipio, areaM2, vagas);
        this.possuiPoçoArtesiano = possuiPoçoArtesiano;
    }

    public Boolean getPossuiPoçoArtesiano() {
        return this.possuiPoçoArtesiano;
    }

    public void setPossuiPoçoArtesiano(Boolean possuiPoçoArtesiano) {
        this.possuiPoçoArtesiano = possuiPoçoArtesiano;
    }
}