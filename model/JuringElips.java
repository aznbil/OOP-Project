/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author purcell
 */
public class JuringElips extends Elips {
    public double luasJuring, panjangBusur, kelilingJuring;
    public double sudut, radiusRata2;
    
    public JuringElips(double aSemiMayor, double bSemiMinor, int sudut, boolean isManual) {
        super(aSemiMayor, bSemiMinor, isManual);
        
        if(sudut <= 0 || sudut > 360){
            throw new IllegalArgumentException("Sudut harus lebih dari 0 dan maksimal 360 derajat!");
        }
        
        this.sudut = sudut;
    }
    
    @Override
    public double hitungLuas(){
        super.hitungLuas();
        
        luasJuring = (sudut / 360.0) * super.luas;
        return luasJuring;
    }
    
    public double hitungLuas(double sudut, double aSemiMayor, double bSemiMinor){
        if(sudut <= 0 || sudut > 360){
            throw new IllegalArgumentException("Sudut harus lebih dari 0 dan maksimal 360 derajat!");
        }
        
        luasJuring = (sudut / 360.0) * super.hitungLuas(aSemiMayor, bSemiMinor);
        return luasJuring;
    }
    
    public double hitungPanjangBusur(){
        super.hitungKeliling();
        
        panjangBusur = (sudut / 360.0) * super.keliling;
        return panjangBusur;
    }
    
    public double hitungPanjangBusur(double sudut, double aSemiMayor, double bSemiMinor) {
        if(sudut <= 0 || sudut > 360){
            throw new IllegalArgumentException("Sudut harus lebih dari 0 dan maksimal 360 derajat!");
        }
        
        panjangBusur = (sudut / 360.0) * super.hitungKeliling(aSemiMayor, bSemiMinor);
        
        return panjangBusur;
    }
    
    @Override
    public double hitungKeliling(){
        hitungPanjangBusur();
        
        radiusRata2 = (super.aSemiMayor + super.bSemiMinor) / 2;
        kelilingJuring = panjangBusur + (2 * radiusRata2);
        
        return kelilingJuring;
    }
    
    public double hitungKeliling(double aSemiMayor, double bSemiMinor, double sudut) {
        if(sudut <= 0 || sudut > 360){
            throw new IllegalArgumentException("Sudut harus lebih dari 0 dan maksimal 360 derajat!");
        }
        
       radiusRata2 = (aSemiMayor + bSemiMinor) / 2;
       kelilingJuring = hitungPanjangBusur(sudut, aSemiMayor, bSemiMinor) + (2 * radiusRata2);
       
       return kelilingJuring;
    }
    
    @Override
    public void run(){
        super.run();
        if(this.isManual){
            this.hitungLuas(sudut, aSemiMayor, bSemiMinor);
            this.hitungKeliling(aSemiMayor, bSemiMinor, sudut);
        }else{
            this.hitungLuas();
            this.hitungKeliling();
        } 
    }
}
