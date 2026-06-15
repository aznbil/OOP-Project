/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author purcell
 */
public class TemberengElips extends Elips{
    public double luasTembereng, tinggiTembereng, bagian1, bagian2;
    public double panjangBusur, taliBusur, kelilingTembereng;
    
    public TemberengElips(double aSemiMayor, double bSemiMinor,double tinggiTembereng, boolean isManual) {
        super(aSemiMayor, bSemiMinor, isManual);
        
        if(tinggiTembereng <= 0){
            throw new IllegalArgumentException("Tinggi tembereng harus lebih besar dari 0!");
        }

        if(tinggiTembereng > (2 * bSemiMinor)){
            throw new IllegalArgumentException("Tinggi tembereng maksimal 2 × semi minor!");
        }
        
        this.tinggiTembereng = tinggiTembereng;
    }
    
    
    @Override
    public double hitungLuas(){
        
        bagian1 = (super.aSemiMayor * super.bSemiMinor) * (Math.acos((super.bSemiMinor - tinggiTembereng) / super.bSemiMinor));
        bagian2 = (super.bSemiMinor - tinggiTembereng) * Math.sqrt(2 * (super.bSemiMinor * tinggiTembereng) - (tinggiTembereng * tinggiTembereng)) * (super.aSemiMayor / super.bSemiMinor);
        
        luasTembereng = bagian1 - bagian2;
        return luasTembereng;
    }
    
    public double hitungLuas(double aSemiMayor, double bSemiMinor, double tinggiTembereng){
        if(aSemiMayor <= 0 || bSemiMinor <= 0){
            throw new IllegalArgumentException("Semi mayor dan semi minor harus lebih besar dari 0!");
        }
        
        if(tinggiTembereng <= 0){
            throw new IllegalArgumentException("Tinggi tembereng harus lebih besar dari 0!");
        }

        if(tinggiTembereng > (2 * bSemiMinor)){
            throw new IllegalArgumentException("Tinggi tembereng maksimal 2 × semi minor!");
        }
        
        
        bagian1 = (aSemiMayor * bSemiMinor) * (Math.acos((bSemiMinor - tinggiTembereng) / bSemiMinor));
        bagian2 = (bSemiMinor - tinggiTembereng) * Math.sqrt(2 * (bSemiMinor * tinggiTembereng) - (tinggiTembereng * tinggiTembereng)) * (aSemiMayor / bSemiMinor);
        
        luasTembereng = bagian1 - bagian2;
        return luasTembereng;
    }
    
    public double hitungPanjangBusur(){
        super.hitungKeliling();
        
        panjangBusur = (tinggiTembereng / (2 * super.bSemiMinor)) * super.keliling;
        return panjangBusur;
    }
    
    public double hitungPanjangBusur(double tinggiTembereng, double aSemiMayor, double bSemiMinor){
        if(aSemiMayor <= 0 || bSemiMinor <= 0){
            throw new IllegalArgumentException("Semi mayor dan semi minor harus lebih besar dari 0!");
        }
        
        if(tinggiTembereng <= 0){
            throw new IllegalArgumentException("Tinggi tembereng harus lebih besar dari 0!");
        }

        if(tinggiTembereng > (2 * bSemiMinor)){
            throw new IllegalArgumentException("Tinggi tembereng maksimal 2 × semi minor!");
        }
        
        panjangBusur = (tinggiTembereng / (2 * bSemiMinor)) * super.hitungKeliling(aSemiMayor, bSemiMinor);
        return panjangBusur;
    }
    
    public double hitungTaliBusur(){
        
        taliBusur = (2 * super.aSemiMayor) * Math.sqrt(1 - ((Math.pow(super.bSemiMinor - tinggiTembereng, 2)) / Math.pow(super.bSemiMinor, 2)));
        return taliBusur;
    }
    
    public double hitungTaliBusur(double aSemiMayor, double bSemiMinor, double tinggiTembereng){
        if(aSemiMayor <= 0 || bSemiMinor <= 0){
            throw new IllegalArgumentException("Semi mayor dan semi minor harus lebih besar dari 0!");
        }
        
        taliBusur = (2 * aSemiMayor) * Math.sqrt(1 - ((Math.pow(bSemiMinor - tinggiTembereng, 2)) / Math.pow(bSemiMinor, 2)));
        return taliBusur;
    }
    
    @Override
    public double hitungKeliling(){
        
        kelilingTembereng = hitungPanjangBusur() + hitungTaliBusur();
        return kelilingTembereng;
    }
    
    public double hitungKeliling(double aSemiMayor, double bSemiMinor, double tinggiTembereng){
        if(aSemiMayor <= 0 || bSemiMinor <= 0){
            throw new IllegalArgumentException("Semi mayor dan semi minor harus lebih besar dari 0!");
        }
        
        kelilingTembereng = hitungPanjangBusur(tinggiTembereng, aSemiMayor, bSemiMinor) + hitungTaliBusur(aSemiMayor, bSemiMinor, tinggiTembereng);
        return kelilingTembereng;
    }
    
    @Override
    public void run(){
        super.run();
        if(this.isManual){
            this.hitungLuas(aSemiMayor, bSemiMinor, tinggiTembereng);
            this.hitungKeliling(aSemiMayor, bSemiMinor, tinggiTembereng);
        }else{
            this.hitungLuas();
            this.hitungKeliling();
        }
    }
}
