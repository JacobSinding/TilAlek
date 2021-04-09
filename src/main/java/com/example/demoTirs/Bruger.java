package com.example.demoTirs;

import java.util.List;
import java.util.Set;

public class Bruger {

    String navn;
    String password;

    List<String> brugerHuskeliste;

    public Bruger(String navn, String password) {
        this.navn = navn;
        this.password = password;
    }

    public String getNavn() {
        return navn;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getBrugerHuskeliste() {
        return brugerHuskeliste;
    }

    public void setBrugerHuskeliste(List<String> brugerHuskeliste) {
        this.brugerHuskeliste = brugerHuskeliste;
    }
}
