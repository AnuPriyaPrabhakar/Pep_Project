package com.ponsun.pep.imageDet.data;

import lombok.Data;

@Data
public class ImageDetData {
    private Integer id;
    private Integer pepId;
    private String imageName;
    private String file_type;
    private Integer imageMasterId;
    private Integer uid;
    private Integer euid;
    public ImageDetData(final Integer id,final Integer pepId,final String imageName, final String file_type,final Integer imageMasterId,final Integer uid,final Integer euid) {
        this.id=id;
        this.pepId=pepId;
        this.imageName=imageName;
        this.file_type=file_type;
        this.imageMasterId=imageMasterId;
        this.uid= uid;
        this.euid = euid;
    }
    public static ImageDetData newInstance(final Integer id,final Integer pepId,final String imageName, final String file_type,final Integer imageMasterId,final Integer uid,final Integer euid) {
        return new ImageDetData(id,pepId,imageName,file_type,imageMasterId,uid,euid);
    }
}
