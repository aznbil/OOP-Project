/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author purcell
 */
public class KerucutTerpancung extends KerucutDgnAlasElips{
    public double a1Bawah, b1Bawah, a2Atas, b2Atas, tinggiFrustum, luasAtas, luasBawah;
    public double kelilingAtas, kelilingBawah, garisPelukis;
    
    public KerucutTerpancung(double a1Bawah, double b1Bawah,double a2Atas, double b2Atas, double tinggiFrustum, boolean isManual) {
        super(a1Bawah, b1Bawah,tinggiFrustum, isManual);
        
        if(a1Bawah <= 0 || b1Bawah <= 0 || a2Atas <= 0 || b2Atas <= 0 ||tinggiFrustum <= 0){
            throw new IllegalArgumentException( "Semua dimensi harus lebih besar dari 0!");
        }
        
        if(a1Bawah < b1Bawah){
            throw new IllegalArgumentException("Semi mayor alas bawah harus lebih besar atau sama dengan semi minor!");
        }
        
        if(a2Atas < b2Atas){
            throw new IllegalArgumentException("Semi mayor alas atas harus lebih besar atau sama dengan semi minor!");
        }
        
        if(a2Atas >= a1Bawah){
            throw new IllegalArgumentException("Semi mayor alas atas harus lebih kecil dari alas bawah!");
        }
        
        if(b2Atas >= b1Bawah){
            throw new IllegalArgumentException("Semi minor alas atas harus lebih kecil dari alas bawah!");
        }
        
        this.a1Bawah = a1Bawah;
        this.b1Bawah = b1Bawah;

        this.a2Atas = a2Atas;
        this.b2Atas = b2Atas;

        this.tinggiFrustum = tinggiFrustum;
    }
    
    @Override
    public double hitungVolume(){
        if(a1Bawah <= 0 || b1Bawah <= 0 || a2Atas <= 0 || b2Atas <= 0){
            throw new IllegalStateException("Dimensi frustum belum valid.");
        }

        
        volume = ((super.PI * tinggiFrustum) / 3) * ((a1Bawah * b1Bawah) + (super.aSemiMayor * super.bSemiMinor) + (Math.sqrt(a1Bawah * b1Bawah * a2Atas * b2Atas)));
        return volume;
    }
    
    public double hitungVolume(double a1Bawah, double b1Bawah, double a2Atas, double b2Atas, double tinggiFrustum){
        if(a1Bawah <= 0 || b1Bawah <= 0 || a2Atas <= 0 || b2Atas <= 0 || tinggiFrustum <= 0){
            throw new IllegalArgumentException("Semua dimensi harus lebih besar dari 0!");
        }
        
        volume = ((super.PI * tinggiFrustum) / 3) * ((a1Bawah * b1Bawah) + (a2Atas * b2Atas) + (Math.sqrt(a1Bawah * b1Bawah * a2Atas * b2Atas)));
        return volume;
    }
    
    @Override
    public double hitungLuasPermukaan(){
        if(a1Bawah <= 0 || b1Bawah <= 0 || a2Atas <= 0 || b2Atas <= 0){
            throw new IllegalStateException("Dimensi alas atas atau alas bawah belum valid.");
        }
        
        luasBawah = super.hitungLuas(a1Bawah, b1Bawah);
        luasAtas = super.hitungLuas(a2Atas, b2Atas);
        kelilingBawah = super.hitungKeliling(a1Bawah, b1Bawah);
        kelilingAtas = super.hitungKeliling(a2Atas, b2Atas);
        garisPelukis = Math.sqrt(Math.pow(tinggiFrustum, 2) + (Math.pow(a1Bawah - a2Atas, 2)) + (Math.pow(b1Bawah - b2Atas, 2)) );
        luasSelimut = ((kelilingBawah + kelilingAtas) / 2) * garisPelukis;
        
        luasPermukaan = luasBawah + luasAtas + luasSelimut;
        return luasPermukaan;
    }
    
    public double hitungLuasPermukaan(double a1Bawah, double b1Bawah, double a2Atas, double b2Atas, double tinggiFrustum){
        if(a1Bawah <= 0 || b1Bawah <= 0 || a2Atas <= 0 || b2Atas <= 0 || tinggiFrustum <= 0){
             throw new IllegalArgumentException("Semua dimensi harus lebih besar dari 0!");
        }
        
        luasBawah = super.hitungLuas(a1Bawah, b1Bawah);
        luasAtas = super.hitungLuas(a2Atas, b2Atas);
        kelilingBawah = super.hitungKeliling(a1Bawah, b1Bawah);
        kelilingAtas = super.hitungKeliling(a2Atas, b2Atas);
        garisPelukis = Math.sqrt(Math.pow(tinggiFrustum, 2) + (Math.pow(a1Bawah - a2Atas, 2)) + (Math.pow(b1Bawah - b2Atas, 2)) );
        luasSelimut = ((kelilingBawah + kelilingAtas) / 2) * garisPelukis;
        
        luasPermukaan = luasBawah + luasAtas + luasSelimut;
        return luasPermukaan;
    }
    
    @Override
    public void run(){
        super.run();
         if(this.isManual){
            this.hitungVolume(a1Bawah, b1Bawah, a2Atas, b2Atas, tinggiFrustum);
            this.hitungLuasPermukaan(a1Bawah, b1Bawah, a2Atas, b2Atas, tinggiFrustum);
        }else{
            this.hitungVolume();
            this.hitungLuasPermukaan();
        }
    }
}
