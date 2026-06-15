/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.model3D;
import model.*;
/**
 *
 * @author purcell
 */
public class Tembereng3D extends BolaElips{
    public double tinggiTembereng, volumeTembereng, luasPermukaanTembereng, luasAlasPerpotongan, rasioTinggi;
    public double a1, b1, luasElips, luasBola;
    
    public Tembereng3D(double aSemiMayor, double bSemiMinor, double cSemiMayor, double tinggiTembereng, boolean isManual) {
        super(aSemiMayor, bSemiMinor, cSemiMayor, isManual);
        
        if(tinggiTembereng <= 0){
            throw new IllegalArgumentException("Tinggi tembereng harus lebih besar dari 0!");
        }

        if(tinggiTembereng > (2 * cSemiMayor)){
            throw new IllegalArgumentException("Tinggi tembereng maksimal 2 × sumbu c!");
        }
        
        this.tinggiTembereng = tinggiTembereng;
    }
    
    public double hitungVolumeTembereng(){
        luasElips = super.hitungLuas();
        
        volumeTembereng = luasElips * ((Math.pow(tinggiTembereng, 2) / super.cSemiMayor) - (Math.pow(tinggiTembereng, 3) / (3 * Math.pow(super.cSemiMayor, 2))));
        return volumeTembereng;
    }
    
    public double hitungVolumeTembereng(double aSemiMayor, double bSemiMinor, double cSemiMayor, double tinggiTembereng){
        if(tinggiTembereng <= 0){
            throw new IllegalArgumentException("Tinggi tembereng harus lebih besar dari 0!");
        }

        if(tinggiTembereng > (2 * cSemiMayor)){
            throw new IllegalArgumentException("Tinggi tembereng maksimal 2 × sumbu c!");
        }
        
        luasElips = super.hitungLuas(aSemiMayor, bSemiMinor);
        
        volumeTembereng = luasElips * ((Math.pow(tinggiTembereng, 2) / cSemiMayor) - (Math.pow(tinggiTembereng, 3) / (3 * Math.pow(cSemiMayor, 2))));
        return volumeTembereng;
    }
    
    public double hitungLuasAlasPerpotongan(){
        
        a1 = super.aSemiMayor * Math.sqrt(1- (Math.pow((super.cSemiMayor - tinggiTembereng) / super.cSemiMayor, 2)));
        b1 = super.bSemiMinor * Math.sqrt(1- (Math.pow((super.cSemiMayor - tinggiTembereng) / super.cSemiMayor, 2)));
        
        luasAlasPerpotongan = super.PI * a1 * b1;
        return luasAlasPerpotongan;
    }
    
    public double hitungLuasAlasPerpotongan(double aSemiMayor, double bSemiMinor, double cSemiMayor, double tinggiTembereng){
        if(tinggiTembereng <= 0){
            throw new IllegalArgumentException("Tinggi tembereng harus lebih besar dari 0!");
        }

        if(tinggiTembereng > (2 * cSemiMayor)){
            throw new IllegalArgumentException("Tinggi tembereng maksimal 2 × sumbu c!");
        }
        
        a1 = aSemiMayor * Math.sqrt(1- (Math.pow((cSemiMayor - tinggiTembereng) / cSemiMayor, 2)));
        b1 = bSemiMinor * Math.sqrt(1- (Math.pow((cSemiMayor - tinggiTembereng) / cSemiMayor, 2)));
        
        luasAlasPerpotongan = super.PI * a1 * b1;
        return luasAlasPerpotongan;
    }
    
    public double hitungLuasPermukaanTembereng(){
        
        rasioTinggi = tinggiTembereng / (2 * super.cSemiMayor);
        luasBola = super.hitungLuasPermukaanBola();
        luasAlasPerpotongan = hitungLuasAlasPerpotongan();
        
        // pendekatan luas selimut tembereng ellipsoid
        luasPermukaanTembereng = luasAlasPerpotongan + (rasioTinggi * luasBola);
        return luasPermukaanTembereng;
    }
    
    public double hitungLuasPermukaanTembereng(double aSemiMayor, double bSemiMinor, double cSemiMayor, double tinggiTembereng){
        if(tinggiTembereng <= 0){
            throw new IllegalArgumentException("Tinggi tembereng harus lebih besar dari 0!");
        }

        if(tinggiTembereng > (2 * cSemiMayor)){
            throw new IllegalArgumentException("Tinggi tembereng maksimal 2 × sumbu c!");
        }
        
        rasioTinggi = tinggiTembereng / (2 * cSemiMayor);
        luasBola = super.hitungLuasPermukaanBola(aSemiMayor, bSemiMinor, cSemiMayor);
        luasAlasPerpotongan = hitungLuasAlasPerpotongan(aSemiMayor, bSemiMinor, cSemiMayor, tinggiTembereng);
        
        // pendekatan luas selimut tembereng ellipsoid
        luasPermukaanTembereng = luasAlasPerpotongan + (rasioTinggi * luasBola);
        return luasPermukaanTembereng;
    }
    
    @Override
    public void run(){
        super.run();
        if(this.isManual){
            this.hitungVolumeTembereng(aSemiMayor, bSemiMinor, cSemiMayor, tinggiTembereng);
            this.hitungLuasPermukaanTembereng(aSemiMayor, bSemiMinor, cSemiMayor, tinggiTembereng);
        }else{
            this.hitungVolumeTembereng();
            this.hitungLuasPermukaanTembereng();
        }
    }
}
