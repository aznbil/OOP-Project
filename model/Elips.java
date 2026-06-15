/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author purcell
 */
public class Elips implements BendaGeometri2D, Runnable{
    public final double PI = 3.14;
    public double luas, keliling;
    public double aSemiMayor, bSemiMinor;
    public boolean isManual;
    
    public Elips(double aSemiMayor, double bSemiMinor, boolean isManual){
        if (aSemiMayor <= 0 || bSemiMinor <= 0) {
            throw new IllegalArgumentException("Nilai semi mayor dan semi minor elips harus lebih besar dari 0!");
        }
        
        if (aSemiMayor < bSemiMinor) {
            throw new IllegalArgumentException("Semi mayor tidak boleh lebih kecil dari semi minor!");
        }
        
        this.aSemiMayor = aSemiMayor;
        this.bSemiMinor = bSemiMinor;
        this.isManual = isManual;
    }
    
    @Override
    public double hitungLuas(){
        if (aSemiMayor <= 0 || bSemiMinor <= 0) {
            throw new IllegalArgumentException("Nilai semi mayor dan semi minor elips harus lebih besar dari 0!");
        }
        
        luas = PI * aSemiMayor * bSemiMinor;
        return luas;
    }
    
    @Override
    public double hitungLuas(double aSemiMayor, double bSemiMinor) throws IllegalStateException{
        if (aSemiMayor <= 0 || bSemiMinor <= 0) {
            throw new IllegalArgumentException("Input Nilai semi mayor dan semi minor elips harus lebih besar dari 0!");
        }
        
        luas = PI * aSemiMayor * bSemiMinor;
        return luas;
    }
    
    @Override
    public double hitungKeliling() {
        if (aSemiMayor <= 0 || bSemiMinor <= 0) {
            throw new IllegalArgumentException("Nilai semi mayor dan semi minor elips harus lebih besar dari 0!");
        }
        
        keliling = PI * (3*(aSemiMayor + bSemiMinor) - Math.sqrt((3 * aSemiMayor + bSemiMinor) * (aSemiMayor + 3 * bSemiMinor)));
        return keliling;
    }
    
    @Override
    public double hitungKeliling(double aSemiMayor, double bSemiMinor) {
        if (aSemiMayor <= 0 || bSemiMinor <= 0) {
            throw new IllegalArgumentException("Input Nilai semi mayor dan semi minor elips harus lebih besar dari 0!");
        }
        
        if (aSemiMayor < bSemiMinor) {
            throw new IllegalArgumentException("Semi mayor tidak boleh lebih kecil dari semi minor!");
        }
        
        keliling = PI * (3*(aSemiMayor + bSemiMinor) - Math.sqrt((3 * aSemiMayor + bSemiMinor) * (aSemiMayor + 3 * bSemiMinor)));
        return keliling;
    }
    
    @Override
    public void run(){
        if(this.isManual){
            this.hitungLuas(aSemiMayor, bSemiMinor);
            this.hitungKeliling(aSemiMayor, bSemiMinor);
        } else{
            this.hitungKeliling();
            this.hitungLuas();
        }
    }
}
