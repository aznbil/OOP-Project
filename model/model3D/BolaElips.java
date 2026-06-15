/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.model3D;

import model.Elips;

/**
 *
 * @author purcell
 */
public class BolaElips extends Elips{
    public double cSemiMayor, volumeBola, luasPermukaanBola, bagianRumus;
    public final double p = 1.6075; // pendekatan Knud Thomsen
    
    public BolaElips(double aSemiMayor, double bSemiMinor, double cSemiMayor, boolean isManual) {
        super(aSemiMayor, bSemiMinor, isManual);
        
        if(cSemiMayor <= 0){
            throw new IllegalArgumentException("Sumbu c harus lebih besar dari 0!");
        }
        
        this.cSemiMayor = cSemiMayor;
    }
    
    
    public double hitungVolumeBola(){
        
        super.hitungLuas();
        
        volumeBola = (4.0 / 3.0) * (super.luas * cSemiMayor);
        return volumeBola;
    }
    
    public double hitungVolumeBola(double aSemiMayor, double bSemiMinor, double cSemiMayor){
        if(cSemiMayor <= 0){
            throw new IllegalArgumentException("Sumbu c harus lebih besar dari 0!");
        }
        
        volumeBola = (4.0/3.0) * (super.hitungLuas(aSemiMayor, bSemiMinor) * cSemiMayor);
        return volumeBola;
    }
    
    public double hitungLuasPermukaanBola(){
        
        bagianRumus = (
                Math.pow(super.aSemiMayor * super.bSemiMinor, p) + Math.pow(super.aSemiMayor * cSemiMayor, p) + Math.pow(super.bSemiMinor * cSemiMayor, p)
                ) / 3.0;
        
        luasPermukaanBola = (4 * super.PI) * Math.pow(bagianRumus, 1.0 / p);
        return luasPermukaanBola;
    }
    
    public double hitungLuasPermukaanBola(double aSemiMayor, double bSemiMinor, double cSemiMayor){
        if(cSemiMayor <= 0){
            throw new IllegalArgumentException("Sumbu c harus lebih besar dari 0!");
        }
        
        bagianRumus = (
                Math.pow(aSemiMayor * bSemiMinor, p) + Math.pow(aSemiMayor * cSemiMayor, p) + Math.pow(bSemiMinor * cSemiMayor, p)
                ) / 3.0;
        
        luasPermukaanBola = (4 * super.PI) * Math.pow(bagianRumus, 1.0 / p);
        return luasPermukaanBola;
    }
    
    @Override
    public void run(){
        super.run();
        if(this.isManual){
            this.hitungVolumeBola(aSemiMayor, bSemiMinor, cSemiMayor);
            this.hitungLuasPermukaanBola(aSemiMayor, bSemiMinor, cSemiMayor);
        }else{
            this.hitungVolumeBola();
            this.hitungLuasPermukaanBola();
        }
    }
}
