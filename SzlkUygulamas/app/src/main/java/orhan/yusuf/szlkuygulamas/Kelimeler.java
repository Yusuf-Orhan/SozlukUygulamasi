package orhan.yusuf.szlkuygulamas;

public class Kelimeler {
    private String ingilizce;
    private String turkce_kelime;
    private int kelime_id;

    public Kelimeler() {
    }

    public Kelimeler(String ingilizce, String turkce_kelime) {
        this.ingilizce = ingilizce;
        this.turkce_kelime = turkce_kelime;
    }

    public String getIngilizce() {
        return ingilizce;
    }

    public void setIngilizce(String ingilizce) {
        this.ingilizce = ingilizce;
    }

    public String getTurkce_kelime() {
        return turkce_kelime;
    }

    public void setTurkce_kelime(String turkce_kelime) {
        this.turkce_kelime = turkce_kelime;
    }

    public int getKelime_id() {
        return kelime_id;
    }

    public void setKelime_id(int kelime_id) {
        this.kelime_id = kelime_id;
    }
}
