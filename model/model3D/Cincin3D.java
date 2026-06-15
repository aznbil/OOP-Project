/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.model3D;

/**
 *
 * @author purcell
 */
public class Cincin3D extends BolaElips{
    public double aSemiMayorDalam, bSemiMinorDalam, cSemiMayorDalam, volumeCincin, luasCincin;
    public double luasLuar, luasDalam;
    
    public Cincin3D(double aSemiMayor, double bSemiMinor, double cSemiMayor, double aSemiMayorDalam, double bSemiMinorDalam, double cSemiMayorDalam, boolean isManual) {
        super(aSemiMayor, bSemiMinor, cSemiMayor, isManual);
        
        if(aSemiMayorDalam <= 0 || bSemiMinorDalam <= 0 || cSemiMayorDalam <= 0){
            throw new IllegalArgumentException("Dimensi ellipsoid dalam harus lebih besar dari 0!");
        }
        
        if(aSemiMayorDalam >= aSemiMayor || bSemiMinorDalam >= bSemiMinor || cSemiMayorDalam >= cSemiMayor){
            throw new IllegalArgumentException("Ellipsoid dalam harus lebih kecil dari ellipsoid luar!");
        }
        
        if(aSemiMayorDalam >= aSemiMayor){
            throw new IllegalArgumentException("Semi mayor dalam harus lebih kecil dari semi mayor luar!");
        }

        if(bSemiMinorDalam >= bSemiMinor){
            throw new IllegalArgumentException("Semi minor dalam harus lebih kecil dari semi minor luar!");
        }

        if(cSemiMayorDalam >= cSemiMayor){
            throw new IllegalArgumentException("Sumbu c dalam harus lebih kecil dari sumbu c luar!");
        }
        
        this.aSemiMayorDalam = aSemiMayorDalam;
        this.bSemiMinorDalam = bSemiMinorDalam;
        this.cSemiMayorDalam = cSemiMayorDalam;
    }
    
    public double hitungVolumeCincin(){
        
        volumeCincin = (4.0 / 3.0) * super.PI * ((super.aSemiMayor * super.bSemiMinor * super.cSemiMayor) - (aSemiMayorDalam * bSemiMinorDalam * cSemiMayorDalam));
        return volumeCincin;
    }
    
    public double hitungVolumeCincin(double aSemiMayorLuar, double bSemiMinorLuar, double cSemiMayorLuar, double aSemiMayorDalam, double bSemiMinorDalam, double cSemiMayorDalam){
        if(aSemiMayorDalam <= 0 || bSemiMinorDalam <= 0 || cSemiMayorDalam <= 0){
            throw new IllegalArgumentException("Dimensi ellipsoid dalam harus lebih besar dari 0!");
        }
        
        if(aSemiMayorLuar <= 0 || bSemiMinorLuar <= 0 || cSemiMayorLuar <= 0){
            throw new IllegalArgumentException("Dimensi ellipsoid luar harus lebih besar dari 0!");
        }
        
        if(aSemiMayorDalam >= aSemiMayorLuar || bSemiMinorDalam >= bSemiMinorLuar || cSemiMayorDalam >= cSemiMayorLuar){
            throw new IllegalArgumentException("Ellipsoid dalam harus lebih kecil dari ellipsoid luar!");
        }
        
        volumeCincin = (4.0 / 3.0) * super.PI * ((aSemiMayorLuar * bSemiMinorLuar * cSemiMayorLuar) - (aSemiMayorDalam * bSemiMinorDalam * cSemiMayorDalam));
        return volumeCincin;
    }
    
    public double hitungLuasPermukaanCincin(){
        luasLuar = super.hitungLuasPermukaanBola();
        luasDalam = super.hitungLuasPermukaanBola(aSemiMayorDalam, bSemiMinorDalam, cSemiMayorDalam);
        
        luasCincin = luasLuar + luasDalam;
        return luasCincin;
    }
    
    public double hitungLuasPermukaanCincin(double aSemiMayorLuar, double bSemiMinorLuar, double cSemiMayorLuar, double aSemiMayorDalam, double bSemiMinorDalam, double cSemiMayorDalam){
        if(aSemiMayorDalam <= 0 || bSemiMinorDalam <= 0 || cSemiMayorDalam <= 0){
            throw new IllegalArgumentException("Dimensi ellipsoid dalam harus lebih besar dari 0!");
        }
        
        if(aSemiMayorLuar <= 0 || bSemiMinorLuar <= 0 || cSemiMayorLuar <= 0){
            throw new IllegalArgumentException("Dimensi ellipsoid luar harus lebih besar dari 0!");
        }
        
        if(aSemiMayorDalam >= aSemiMayorLuar || bSemiMinorDalam >= bSemiMinorLuar || cSemiMayorDalam >= cSemiMayorLuar){
            throw new IllegalArgumentException("Ellipsoid dalam harus lebih kecil dari ellipsoid luar!");
        }
        
        luasLuar = super.hitungLuasPermukaanBola(aSemiMayorLuar, bSemiMinorLuar, cSemiMayorLuar);
        luasDalam = super.hitungLuasPermukaanBola(aSemiMayorDalam, bSemiMinorDalam, cSemiMayorDalam);
        
        luasCincin = luasLuar + luasDalam;
        return luasCincin;
    }
    
    @Override
    public void run(){
        super.run();
        if(this.isManual){
            this.hitungVolumeCincin(aSemiMayor, bSemiMinor, cSemiMayor, aSemiMayorDalam, bSemiMinorDalam, cSemiMayorDalam);
            this.hitungLuasPermukaanCincin(aSemiMayor, bSemiMinor, cSemiMayor, aSemiMayorDalam, bSemiMinorDalam, cSemiMayorDalam);
        }else{
            this.hitungVolumeCincin();
            this.hitungLuasPermukaanCincin();
        }
    }
}
