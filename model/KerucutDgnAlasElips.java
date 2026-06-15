/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author purcell
 */
public class KerucutDgnAlasElips extends Elips{
    public double luasAlas, kelilingAlas, s1, s2, volume, luasSelimut, luasPermukaan, tinggiKerucut;

    public KerucutDgnAlasElips(double aSemiMayor, double bSemiMinor, double tinggiKerucut, boolean isManual) {
        super(aSemiMayor, bSemiMinor, isManual);
        
        if (tinggiKerucut <= 0) {
        throw new IllegalArgumentException(
            "Tinggi kerucut harus lebih besar dari 0!"
            );
        }
        
        if (aSemiMayor < bSemiMinor) {
            throw new IllegalArgumentException("Semi mayor harus lebih besar atau sama dengan semi minor!");
        }

        this.tinggiKerucut = tinggiKerucut;
    }
    
    public double hitungVolume() throws IllegalStateException{
        if (super.luas <= 0) {
            throw new IllegalStateException("Luas alas belum dihitung.");
        }
        
        volume = (1.0/3.0) * (super.luas * tinggiKerucut);
        return volume;
    }
    
    public double hitungVolume(double aSemiMayor, double bSemiMinor, double tinggiKerucut) throws IllegalStateException {
        if (aSemiMayor <= 0 || bSemiMinor <= 0) {
            throw new IllegalArgumentException("Nilai semi mayor dan semi minor elips harus lebih besar dari 0!");
        }
        
        if (aSemiMayor < bSemiMinor) {
            throw new IllegalArgumentException("Semi mayor harus lebih besar atau sama dengan semi minor!");
        }
        
        if (tinggiKerucut <= 0) {
            throw new IllegalArgumentException("Tinggi kerucut harus lebih besar dari 0!");
        }
        
        luasAlas = super.hitungLuas(aSemiMayor, bSemiMinor);
        
        volume = (1.0/3.0) * (luasAlas * tinggiKerucut);
        return volume;
    }
    
    public double hitungGarisPelukisMayor(){
        s1 = Math.sqrt(Math.pow(aSemiMayor, 2) + Math.pow(this.tinggiKerucut, 2));
        return s1;
    }
    
    public double hitungGarisPelukisMinor(){
        s2 = Math.sqrt(Math.pow(bSemiMinor, 2) + Math.pow(this.tinggiKerucut, 2));
        return s2;
    }
    
    public double hitungGarisPelukisMayor(double aSemiMayor){
        s1 = Math.sqrt(Math.pow(aSemiMayor, 2) + Math.pow(this.tinggiKerucut, 2));
        return s1;
    }
    
    public double hitungGarisPelukisMinor(double bSemiMinor){
        s2 = Math.sqrt(Math.pow(bSemiMinor, 2) + Math.pow(this.tinggiKerucut, 2));
        return s2;
    }
    
    public double hitungLuasPermukaan() {
        hitungGarisPelukisMayor();
        hitungGarisPelukisMinor();
        
        if (super.luas <= 0 || super.keliling <= 0) {
            throw new IllegalStateException("Luas atau keliling alas belum dihitung.");
        }
        
        luasSelimut = super.keliling * ((s1 + s2) / 2);
        luasPermukaan = super.luas + luasSelimut;
        return luasPermukaan;
    }
    
    public double hitungLuasPermukaan(double aSemiMayor, double bSemiMinor) {
        if (aSemiMayor <= 0 || bSemiMinor <= 0) {
            throw new IllegalArgumentException("Nilai semi mayor dan semi minor elips harus lebih besar dari 0!");
        }
        
        if (aSemiMayor < bSemiMinor) {
            throw new IllegalArgumentException("Semi mayor harus lebih besar atau sama dengan semi minor!");
        }
        
        luasAlas = super.hitungLuas(aSemiMayor, bSemiMinor);
        kelilingAlas = super.hitungKeliling(aSemiMayor, bSemiMinor);
        s1 = hitungGarisPelukisMayor(aSemiMayor);
        s2 = hitungGarisPelukisMinor(bSemiMinor);
        luasSelimut = kelilingAlas * ((s1 + s2) / 2);
        
        luasPermukaan = luasAlas + luasSelimut;
        return luasPermukaan;
    }
    
    @Override
    public void run(){
        super.run();
        if(this.isManual){
            this.hitungVolume(aSemiMayor, bSemiMinor, tinggiKerucut);
            this.hitungLuasPermukaan(aSemiMayor, bSemiMinor);
        }else{
            this.hitungVolume();
            this.hitungLuasPermukaan();
        }
    }
}