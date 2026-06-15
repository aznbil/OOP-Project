/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.model3D;

/**
 *
 * @author purcell
 */
public class Juring3D extends BolaElips{
    public double volumeJuring, luasJuring, sudut;
    
    public Juring3D(double aSemiMayor, double bSemiMinor, double cSemiMayor, double sudut, boolean isManual) {
        super(aSemiMayor, bSemiMinor, cSemiMayor, isManual);
        
        if(sudut <= 0 || sudut > 360){
            throw new IllegalArgumentException("Sudut harus lebih dari 0 dan maksimal 360 derajat!");
        }
        
        this.sudut = sudut;
    }
    
    public double hitungVolumeJuring(){
        super.hitungVolumeBola();
        
        volumeJuring = (sudut / 360.0) * super.volumeBola;
        return volumeJuring;
    }
    
    public double hitungVolumeJuring(double sudut, double aSemiMayor, double bSemiMinor, double cSemiMayor){
        if(sudut <= 0 || sudut > 360){
            throw new IllegalArgumentException("Sudut harus lebih dari 0 dan maksimal 360 derajat!");
        }
        
        volumeJuring = (sudut / 360.0) * super.hitungVolumeBola(aSemiMayor, bSemiMinor, cSemiMayor);
        return volumeJuring;
    }
    
    public double hitungLuasPermukaanJuring(){
        super.hitungLuasPermukaanBola();
        
        luasJuring = (sudut / 360.0) * super.luasPermukaanBola;
        return luasJuring;
    }
    
    public double hitungLuasPermukaanJuring(double sudut, double aSemiMayor, double bSemiMinor, double cSemiMayor){
        if(sudut <= 0 || sudut > 360){
            throw new IllegalArgumentException("Sudut harus lebih dari 0 dan maksimal 360 derajat!");
        }
        
        luasJuring = (sudut / 360.0) * super.hitungLuasPermukaanBola(aSemiMayor, bSemiMinor, cSemiMayor);
        return luasJuring;
    }
    
    @Override
    public void run(){
        super.run();
        if(this.isManual){
            this.hitungVolumeJuring(sudut, aSemiMayor, bSemiMinor, cSemiMayor);
            this.hitungLuasPermukaanJuring(sudut, aSemiMayor, bSemiMinor, cSemiMayor);
        }else{
            this.hitungVolumeJuring();
            this.hitungLuasPermukaanJuring();
        }
    }
}
