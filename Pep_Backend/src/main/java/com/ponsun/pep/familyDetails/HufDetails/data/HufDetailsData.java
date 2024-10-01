package com.ponsun.pep.familyDetails.HufDetails.data;

import lombok.Data;

@Data
public class HufDetailsData {
        //private Integer id;
        private Integer pepId;
        private String hufName;
        private String hufPan;
        private Integer uid;
        private Integer euid;

        public HufDetailsData (final Integer pepId,  String hufName , String hufPan ,  final Integer uid , final Integer euid ) {
            this.pepId = pepId;
            this.hufName = hufName;
            this.hufPan = hufPan;
            this.uid = uid;
            this.euid = euid;
        }
        public static HufDetailsData newInstance (final Integer pepId,  String hufName , String hufPan ,  final Integer uid , final Integer euid ) {
            return new HufDetailsData(pepId,hufName,hufPan,uid,euid);
        }
}

