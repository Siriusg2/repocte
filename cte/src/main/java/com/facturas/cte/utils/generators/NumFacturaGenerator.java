package com.facturas.cte.utils.generators;

import java.util.List;



import com.facturas.cte.models.FacturaModel;



public class NumFacturaGenerator {
    

    
    public String generarNumeroFactura(List<FacturaModel> allFacturas) throws Exception{



            
        String firstFact = "001-001-000000001";
        int size = allFacturas.size();
        
        if (size > 0) {
            FacturaModel lastFactura = allFacturas.get(size - 1);

            String numfactura = lastFactura.getNumeroFactura();

            String[] components = numfactura.split("-"); // Separar por guiones
            int establecimientoNumber = Integer.parseInt(components[0]);
            int puntoEmisionNumber = Integer.parseInt(components[1]);
            int facturaNumber = Integer.parseInt(components[2]);
            int newFacturaNumber = facturaNumber + 1;
if(newFacturaNumber < 10){
    String newFactNumber = String.format("00%s-00%s-00000000%s", establecimientoNumber,puntoEmisionNumber, newFacturaNumber );

    return newFactNumber;
}
if(newFacturaNumber >= 10 && newFacturaNumber < 100 ){
    String newFactNumber = String.format("00%s-00%s-0000000%s", establecimientoNumber,puntoEmisionNumber, newFacturaNumber );

    return newFactNumber;
}
if(newFacturaNumber >= 100){
    String newFactNumber = String.format("00%s-00%s-000000%s", establecimientoNumber,puntoEmisionNumber, newFacturaNumber );

    return newFactNumber;
}
if(newFacturaNumber >= 1000){
    String newFactNumber = String.format("00%s-00%s-00000%s", establecimientoNumber,puntoEmisionNumber, newFacturaNumber );

    return newFactNumber;
}
if(newFacturaNumber >= 10000){
    String newFactNumber = String.format("00%s-00%s-0000%s", establecimientoNumber,puntoEmisionNumber, newFacturaNumber );

    return newFactNumber;
}
if(newFacturaNumber >= 100000){
    String newFactNumber = String.format("00%s-00%s-000%s", establecimientoNumber,puntoEmisionNumber, newFacturaNumber );

    return newFactNumber;
}
if(newFacturaNumber >= 1000000){
    String newFactNumber = String.format("00%s-00%s-00%s", establecimientoNumber,puntoEmisionNumber, newFacturaNumber );

    return newFactNumber;
}
if(newFacturaNumber >= 10000000){
    String newFactNumber = String.format("00%s-00%s-0%s", establecimientoNumber,puntoEmisionNumber, newFacturaNumber );

    return newFactNumber;
}



        } 
        return firstFact;
            
       


    }
    
  
}

