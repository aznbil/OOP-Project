/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author purcell
 */
public class CincinElips extends Elips{
    public double a1Luar, b1Luar, a2Dalam, b2Dalam, luasLuar, luasDalam, luasCincin;
    public double kelilingLuar, kelilingDalam, kelilingCincin;
    
    public CincinElips(double a1Luar, double b1Luar, double a2Dalam, double b2Dalam, boolean isManual) {
        super(a1Luar, b1Luar, isManual);
        
        if(a1Luar <= a2Dalam || b1Luar <= b2Dalam){
            throw new IllegalArgumentException( "Dimensi elips luar harus lebih besar dari elips dalam!");
        }
        
        this.a1Luar = a1Luar;
        this.b1Luar = b1Luar;
        this.a2Dalam = a2Dalam;
        this.b2Dalam = b2Dalam;
    }
    
    @Override
    public double hitungLuas(){
        
        luasLuar = super.hitungLuas(a1Luar, b1Luar);
        luasDalam = super.hitungLuas(a2Dalam, b2Dalam);
        
        luasCincin = (luasLuar - luasDalam);
        return luasCincin;
    }
    
    public double hitungLuas(double a1Luar, double b1Luar, double a2Dalam, double b2Dalam){
        if(a1Luar <= a2Dalam || b1Luar <= b2Dalam){
            throw new IllegalArgumentException( "Dimensi elips luar harus lebih besar dari elips dalam!");
        }
        
        luasLuar = super.hitungLuas(a1Luar, b1Luar);
        luasDalam = super.hitungLuas(a2Dalam, b2Dalam);
        
        luasCincin = (luasLuar - luasDalam);
        return luasCincin;
    }
    
    @Override
    public double hitungKeliling(){
        kelilingLuar = super.hitungKeliling(a1Luar, b1Luar);
        kelilingDalam = super.hitungKeliling(a2Dalam, b2Dalam);
        
        kelilingCincin = kelilingLuar + kelilingDalam;
        return kelilingCincin;
    }
    
    public double hitungKeliling(double a1Luar, double b1Luar, double a2Dalam, double b2Dalam){
        if(a1Luar <= a2Dalam || b1Luar <= b2Dalam){
            throw new IllegalArgumentException( "Dimensi elips luar harus lebih besar dari elips dalam!");
        }
        
        kelilingLuar = super.hitungKeliling(a1Luar, b1Luar);
        kelilingDalam = super.hitungKeliling(a2Dalam, b2Dalam);
        
        kelilingCincin = kelilingLuar + kelilingDalam;
        return kelilingCincin;
    }
    
    @Override
    public void run(){
        super.run();
        if(this.isManual){
            this.hitungLuas(a1Luar, b1Luar, a2Dalam, b2Dalam);
            this.hitungKeliling(a1Luar, b1Luar, a2Dalam, b2Dalam);
        }else{
            this.hitungLuas();
            this.hitungKeliling();
        } 
    }
}
