package com.ponsun.pep.relativeDetails.RelativesCommonService.service;

import com.ponsun.pep.common.entity.Status;
import com.ponsun.pep.relativeDetails.Relative.data.RelativeData;
import com.ponsun.pep.relativeDetails.Relative.domain.RelativeRepository;
import com.ponsun.pep.relativeDetails.RelativeChildrenDet.domain.ChildrenDetRepository;
import com.ponsun.pep.relativeDetails.RelativeChildrenDet.services.ChildrenDetWritePlatformService;
import com.ponsun.pep.relativeDetails.Relativedet.domain.RelativeDetRepository;
import com.ponsun.pep.relativeDetails.Relativedet.services.RelativeDetWritePlatformService;
import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeChildrenDTO;
import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeCombineDTO;
import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeDTO;
import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeDetDTO;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class RelativeCommonReadServiceImpl implements  RelativeCommonReadService {
    private final RelativeRepository relativeRepository;
    private final RelativeDetRepository relativeDetRepository;
    private final ChildrenDetRepository childrenDetRepository;
    private final ChildrenDetWritePlatformService childrenDetWritePlatformService;
    private final RelativeDetWritePlatformService relativeDetWritePlatformService;

    public  List<RelativeCombineDTO> getRelativeActivity(Integer pepId) {
        List<RelativeData> relativeList = relativeRepository.findByPepIdAndStatus(pepId , Status.ACTIVE);
        ModelMapper modelMapper = new ModelMapper();
        List<RelativeCombineDTO> relativeCombineDTOList = new ArrayList<>();

        for(RelativeData relativeData : relativeList) {
            RelativeCombineDTO relativeCombineDTO = new RelativeCombineDTO();
            RelativeDTO relativeDTO = modelMapper.map(relativeData , RelativeDTO.class);
            Integer relativeId  = relativeDTO.getId();
            List<RelativeDetDTO> relativeDetDTOList = relativeDetWritePlatformService.fetchRelativeDetDTO(pepId,relativeId);
            List<RelativeChildrenDTO> relativeChildrenDTOList = childrenDetWritePlatformService.fetchRelativeChildrenDTO(pepId,relativeId);

            relativeCombineDTO.setRelativeDTO(relativeDTO);
            relativeCombineDTO.setRelativeDetDTOS(relativeDetDTOList);
            relativeCombineDTO.setRelativeChildrenDTOS(relativeChildrenDTOList);
            relativeCombineDTOList.add(relativeCombineDTO);
        }
        return relativeCombineDTOList;
    }
}
