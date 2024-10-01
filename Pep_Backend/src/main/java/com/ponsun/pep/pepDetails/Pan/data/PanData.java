
package com.ponsun.pep.pepDetails.Pan.data;

import lombok.Data;

@Data
public class PanData {
   private String pan;
    public  PanData( final String pan){
        this.pan = pan;
    }

    public static PanData newInstance (final String pan){
        return new PanData(pan);
    }
}
