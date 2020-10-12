package com.example.myapplication;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "voce")
public class Voce {
    public static final String Polje_naziv="naziv";
    public static final String Polje_opis="opis";
    public static final String Polje_slika="slika";

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = Polje_naziv,canBeNull = false)
    private String naziv;
    @DatabaseField(columnName = Polje_opis,canBeNull = false)
    private String opis;
    @DatabaseField(columnName = Polje_slika,canBeNull = false)
    private String slika;

    public Voce(String naziv, String opis, String slika) {
        this.naziv = naziv;
        this.opis = opis;
        this.slika = slika;
    }

    public int getId() {
        return id;
    }



    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }
}
