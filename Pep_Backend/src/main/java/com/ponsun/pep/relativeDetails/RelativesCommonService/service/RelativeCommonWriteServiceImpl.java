//package com.ponsun.pep.relativeDetails.RelativesCommonService.service;
//
//import com.ponsun.pep.relativeDetails.Relative.domain.Relative;
//import com.ponsun.pep.relativeDetails.Relative.domain.RelativeRepository;
//import com.ponsun.pep.relativeDetails.Relative.request.CreateRelativeRequest;
//import com.ponsun.pep.relativeDetails.Relative.services.RelativeWritePlatformService;
//import com.ponsun.pep.relativeDetails.RelativeChildrenDet.domain.ChildrenDet;
//import com.ponsun.pep.relativeDetails.RelativeChildrenDet.request.CreateChildrenDetRequest;
//import com.ponsun.pep.relativeDetails.Relativedet.domain.RelativeDet;
//import com.ponsun.pep.relativeDetails.Relativedet.request.CreateRelativeDetRequest;
//import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeChildrenDTO;
//import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeCombineDTO;
//import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeDetDTO;
//import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
//import com.ponsun.pep.infrastructure.utils.Response;
//import com.ponsun.pep.pepDetails.Customer.domain.Customer;
//import com.ponsun.pep.pepDetails.Customer.domain.CustomerRepository;
//
//import com.ponsun.pep.relativeDetails.RelativeChildrenDet.domain.ChildrenDetRepository;
//import com.ponsun.pep.relativeDetails.Relativedet.domain.RelativeDetRepository;
//import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeDTO;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.modelmapper.ModelMapper;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.data.crossstore.ChangeSetPersister;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//@Slf4j
//
//public class RelativeCommonWriteServiceImpl implements RelativeCommonWriteService {
//
//    private final CustomerRepository pepCustomerRepository;
//    private final RelativeRepository relativeRepository;
//    private final RelativeDetRepository relativeDetRepository;
//    private final ChildrenDetRepository childrenDetRepository;
//    private final RelativeWritePlatformService relativeWritePlatformService;
//    @Override
//    @Transactional
//    public Response createRelativeDetails(Integer pepId, List<RelativeCombineDTO> relativeCombineDTO) {
//        try {
//            Response response = null;
//            ModelMapper modelMapper = new ModelMapper();
//
//            for (RelativeCombineDTO dto : relativeCombineDTO) {
//
//                CreateRelativeRequest request = modelMapper.map(dto.getRelativeDTO(), CreateRelativeRequest.class);
//
//                final Relative relative = Relative.create(request);
//                if (!relative.getRelativeName().isEmpty())
//                {
//                    relative.setPepId(pepId);
//                this.relativeRepository.save(relative);
//                int detId = relative.getId();
//                response = Response.of(relative.getId());
//
//                for (RelativeDetDTO relativeDetDTO : dto.getRelativeDetDTOS()) {
//                    CreateRelativeDetRequest relativeDetRequest = modelMapper.map(relativeDetDTO, CreateRelativeDetRequest.class);
//                    if(!relativeDetRequest.getName().isEmpty()) {
//                        relativeDetRequest.setRelativeId(detId);
//                        relativeDetRequest.setPepId(pepId);
//                        final RelativeDet relativeDet = RelativeDet.create(relativeDetRequest);
//                        this.relativeDetRepository.save(relativeDet);
//                    }
//                }
//                for (RelativeChildrenDTO relativeChildrenDTO : dto.getRelativeChildrenDTOS()) {
//                    CreateChildrenDetRequest createChildrenDetRequest = modelMapper.map(relativeChildrenDTO, CreateChildrenDetRequest.class);
//                    if(!createChildrenDetRequest.getChildrenName().isEmpty()) {
//                        createChildrenDetRequest.setRelativeId(detId);
//                        createChildrenDetRequest.setPepId(pepId);
//                        final ChildrenDet childrenDet = ChildrenDet.create(createChildrenDetRequest);
//                        this.childrenDetRepository.save(childrenDet);
//                    }
//                }
//            }
//            }
//            return response;
//        } catch (DataIntegrityViolationException e) {
//            throw new EQAS_PEP_AppicationException(e.getMessage());
//        }
//    }
//
//    @Override
//    @Transactional
//    public Response createAndUpdateRelativeDetails(Integer pepId,Integer euid, List<RelativeCombineDTO> relativeCombineDTO) {
//        try {
//
//            Response response = null;
//            ModelMapper modelMapper = new ModelMapper();
//
//            for (RelativeCombineDTO dto : relativeCombineDTO) {
//
//                CreateRelativeRequest request = modelMapper.map(dto.getRelativeDTO(), CreateRelativeRequest.class);
//
//                Integer RelativeMasterId = request.getRelativeMasterId();
//                this.relativeWritePlatformService.DeactiveRelative(pepId,RelativeMasterId,euid);
//                final Relative relative = Relative.create(request);
//                final RelativeDet relativesDet = RelativeDet.create(new CreateRelativeDetRequest());
//                relative.setPepId(pepId);
//                this.relativeRepository.save(relative);
//                int detId = relative.getId();
//                int relativeDetId = relativesDet.getId();
//                response = Response.of(relative.getId());
//
//                for (RelativeDetDTO relativeDetDTO : dto.getRelativeDetDTOS()) {
//                    //        List<RelativeCombineDTO> relativeCombineDTo                       = relativeCommonReadService.getRelativeActivity(pepId);
//                    CreateRelativeDetRequest relativeDetRequest = modelMapper.map(relativeDetDTO, CreateRelativeDetRequest.class);
//                    relativeDetRequest.setRelativeId(detId);
//                    relativeDetRequest.setPepId(pepId);
//                    final RelativeDet relativeDet = RelativeDet.create(relativeDetRequest);
//                    this.relativeDetRepository.save(relativeDet);
//                }
//                for (RelativeChildrenDTO relativeChildrenDTO : dto.getRelativeChildrenDTOS()) {
//                    CreateChildrenDetRequest createChildrenDetRequest = modelMapper.map(relativeChildrenDTO, CreateChildrenDetRequest.class);
//                    createChildrenDetRequest.setRelativeId(detId);
//                    createChildrenDetRequest.setPepId(pepId);
//                    createChildrenDetRequest.setRelativeDetId(relativeDetId);
//                    final ChildrenDet childrenDet = ChildrenDet.create(createChildrenDetRequest);
//                    this.childrenDetRepository.save(childrenDet);
//                }
//            }
//            return response;
//        } catch (DataIntegrityViolationException e) {
//            throw new EQAS_PEP_AppicationException(e.getMessage());
//        }
//    }
//    @Transactional
//    public String createRelative(Integer pepId, Integer relativeMasterId, String allMemberDet, Integer createdBy)
//    {
//        try {
//            Customer pepCustomer = pepCustomerRepository.findById(pepId)
//                    .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
//
//            // Logic for handling AllMemberDet
//            String[] allMemberArray = allMemberDet.split("<$>");
//            for (String memberData : allMemberArray) {
//                String[] memberArray = memberData.split("<##>");
//
//                String member = memberArray[0];
//                String memberDet = memberArray.length > 1 ? memberArray[1] : "";
//                String memberChildDet = memberArray.length > 2 ? memberArray[2] : "";
//
//                String[] memberDetails = member.split("\\|");
//                String memberName = memberDetails.length > 0 ? memberDetails[0] : "";
//                String memberPan = memberDetails.length > 1 ? memberDetails[1] : "";
//
//                // Insert into PepRelative
//                RelativeDTO relativedto = new RelativeDTO();
//                relativedto.setPepId(pepCustomer.getId());
//                relativedto.setRelativeMasterId(relativeMasterId);
//                relativedto.setRelativeName(memberName);
//                relativedto.setPan(memberPan);
//                final Relative relative = Relative.createthrwDTO(relativedto);
//                Relative savedRelative = this.relativeRepository.saveAndFlush(relative);
//                Integer pepRelativeId = savedRelative.getId();
//
//                String[] memberDetArray = memberDet.split("<#>");
//                for (String memberDetData : memberDetArray) {
//                    String[] memberDetDetails = memberDetData.split("\\|");
//                    String memberDetName = memberDetDetails.length > 0 ? memberDetDetails[0] : "";
//                    String memberDetPan = memberDetDetails.length > 1 ? memberDetDetails[1] : "";
//
//                    //Insert into PepRelativeDet
//                    RelativeDet pepRelativeDet = new RelativeDet();
//                    pepRelativeDet.setPepId(pepCustomer.getId());
//                    pepRelativeDet.setRelativeId(pepRelativeId);
//                    pepRelativeDet.setName(memberDetName);
//                    pepRelativeDet.setPan(memberDetPan);
//                    relativeDetRepository.save(pepRelativeDet);
//                }
////                // Insert into PepRelativeDetChildren
//                if (!memberChildDet.isEmpty()) {
//                String[] memberChildDetArray = memberChildDet.split("<#>");
//                    for (String memberChildDetData : memberChildDetArray) {
//                        String[] memberChildDetDetails = memberChildDetData.split("\\|");
//                        String memberDetName = memberChildDetDetails.length > 0 ? memberChildDetDetails[0] : "";
//                        String memberDetPan = memberChildDetDetails.length > 1 ? memberChildDetDetails[1] : "";
//
//                        //Insert into PepRelativeDet
//                        ChildrenDet childrenDet = new ChildrenDet();
//                        childrenDet.setPepId(pepCustomer.getId());
//                        childrenDet.setRelativeDetId(pepRelativeId);
//                        childrenDet.setChildrenName(memberDetName);
//                        childrenDet.setPan(memberDetPan);
//                        childrenDetRepository.save(childrenDet);
//                    }
//                }
//            }
//
//            return "SUCCESS";
//        } catch (Exception e) {
//            // Handle exceptions appropriately
//            e.printStackTrace();
//            return "FAILURE";
//        }
//    }
//}
package com.ponsun.pep.relativeDetails.RelativesCommonService.service;

import com.ponsun.pep.relativeDetails.Relative.domain.Relative;
import com.ponsun.pep.relativeDetails.Relative.domain.RelativeRepository;
import com.ponsun.pep.relativeDetails.Relative.request.CreateRelativeRequest;
import com.ponsun.pep.relativeDetails.Relative.services.RelativeWritePlatformService;
import com.ponsun.pep.relativeDetails.RelativeChildrenDet.domain.ChildrenDet;
import com.ponsun.pep.relativeDetails.RelativeChildrenDet.request.CreateChildrenDetRequest;
import com.ponsun.pep.relativeDetails.Relativedet.domain.RelativeDet;
import com.ponsun.pep.relativeDetails.Relativedet.request.CreateRelativeDetRequest;
import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeChildrenDTO;
import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeCombineDTO;
import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeDetDTO;
import com.ponsun.pep.infrastructure.exceptions.EQAS_PEP_AppicationException;
import com.ponsun.pep.infrastructure.utils.Response;
import com.ponsun.pep.pepDetails.Customer.domain.Customer;
import com.ponsun.pep.pepDetails.Customer.domain.CustomerRepository;

import com.ponsun.pep.relativeDetails.RelativeChildrenDet.domain.ChildrenDetRepository;
import com.ponsun.pep.relativeDetails.Relativedet.domain.RelativeDetRepository;
import com.ponsun.pep.relativeDetails.RelativesCommonService.dto.RelativeDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class RelativeCommonWriteServiceImpl implements RelativeCommonWriteService {

    private final CustomerRepository pepCustomerRepository;
    private final RelativeRepository relativeRepository;
    private final RelativeDetRepository relativeDetRepository;
    private final ChildrenDetRepository childrenDetRepository;
    private final RelativeWritePlatformService relativeWritePlatformService;
    @Override
    @Transactional
    public Response createRelativeDetails(Integer pepId, List<RelativeCombineDTO> relativeCombineDTO) {
        try {
            Response response = null;
            ModelMapper modelMapper = new ModelMapper();

            for (RelativeCombineDTO dto : relativeCombineDTO) {

                CreateRelativeRequest request = modelMapper.map(dto.getRelativeDTO(), CreateRelativeRequest.class);

                final Relative relative = Relative.create(request);
                if (!relative.getRelativeName().isEmpty())
                {
                    relative.setPepId(pepId);
                    this.relativeRepository.save(relative);
                    int detId = relative.getId();
                    response = Response.of(relative.getId());

                    int relativeDetId = 0;

                    for (RelativeDetDTO relativeDetDTO : dto.getRelativeDetDTOS()) {
                        CreateRelativeDetRequest relativeDetRequest = modelMapper.map(relativeDetDTO, CreateRelativeDetRequest.class);
                        if(!relativeDetRequest.getName().isEmpty()) {
                            relativeDetRequest.setRelativeId(detId);
                            relativeDetRequest.setPepId(pepId);
                            final RelativeDet relativeDet = RelativeDet.create(relativeDetRequest);
                            this.relativeDetRepository.save(relativeDet);
                            //relativeDetId=relativeDet.getId();
                        }
                    }
                    for (RelativeChildrenDTO relativeChildrenDTO : dto.getRelativeChildrenDTOS()) {
                    CreateChildrenDetRequest createChildrenDetRequest = modelMapper.map(relativeChildrenDTO, CreateChildrenDetRequest.class);
                    if(!createChildrenDetRequest.getChildrenName().isEmpty()) {
                        createChildrenDetRequest.setRelativeId(detId);
                        createChildrenDetRequest.setPepId(pepId);
                        //createChildrenDetRequest.setRelativeDetId(relativeDetId);
                        final ChildrenDet childrenDet = ChildrenDet.create(createChildrenDetRequest);
                        this.childrenDetRepository.save(childrenDet);
                    }
                }
                }
            }
            return response;
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response createAndUpdateRelativeDetails(Integer pepId,Integer euid, List<RelativeCombineDTO> relativeCombineDTO) {
        try {
            Response response = null;
            ModelMapper modelMapper = new ModelMapper();
            this.relativeWritePlatformService.DeactiveRelative(pepId, euid);
            for (RelativeCombineDTO dto : relativeCombineDTO) {
                CreateRelativeRequest request = modelMapper.map(dto.getRelativeDTO(), CreateRelativeRequest.class);
            if(!request.getRelativeName().isEmpty()) {
                Integer RelativeMasterId = request.getRelativeMasterId();
//                this.relativeWritePlatformService.DeactiveRelative(pepId, RelativeMasterId, euid);
                final Relative relative = Relative.create(request);
                //final RelativeDet relativesDet = RelativeDet.create(new CreateRelativeDetRequest());
                relative.setPepId(pepId);
                this.relativeRepository.save(relative);

                Integer detId = relative.getId();
                response = Response.of(relative.getId());

                for (RelativeDetDTO relativeDetDTO : dto.getRelativeDetDTOS()) {
                    if (!relativeDetDTO.getName().isEmpty()) {
                        //        List<RelativeCombineDTO> relativeCombineDTo                       = relativeCommonReadService.getRelativeActivity(pepId);
                        CreateRelativeDetRequest relativeDetRequest = modelMapper.map(relativeDetDTO, CreateRelativeDetRequest.class);
                        relativeDetRequest.setRelativeId(detId);
                        relativeDetRequest.setPepId(pepId);
                        final RelativeDet relativeDet = RelativeDet.create(relativeDetRequest);
                        this.relativeDetRepository.save(relativeDet);
                    }
                    //Integer relativeDetId = relativeDet.getId();
                }
                for (RelativeChildrenDTO relativeChildrenDTO : dto.getRelativeChildrenDTOS()) {
                    if (!relativeChildrenDTO.getChildrenName().isEmpty()) {
                        CreateChildrenDetRequest createChildrenDetRequest = modelMapper.map(relativeChildrenDTO, CreateChildrenDetRequest.class);
                        createChildrenDetRequest.setRelativeId(detId);
                        createChildrenDetRequest.setPepId(pepId);
                        //createChildrenDetRequest.setRelativeDetId(relativeDetId);
                        final ChildrenDet childrenDet = ChildrenDet.create(createChildrenDetRequest);
                        this.childrenDetRepository.save(childrenDet);
                    }
                }
            }
            }
            return response;
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_PEP_AppicationException(e.getMessage());
        }
    }
    @Transactional
    public String createRelative(Integer pepId, Integer relativeMasterId, String allMemberDet, Integer createdBy)
    {
        try {
            Customer pepCustomer = pepCustomerRepository.findById(pepId)
                    .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
            // Logic for handling AllMemberDet
            String[] allMemberArray = allMemberDet.split("<$>");
            for (String memberData : allMemberArray) {
                String[] memberArray = memberData.split("<##>");

                String member = memberArray[0];
                String memberDet = memberArray.length > 1 ? memberArray[1] : "";
                String memberChildDet = memberArray.length > 2 ? memberArray[2] : "";

                String[] memberDetails = member.split("\\|");
                String memberName = memberDetails.length > 0 ? memberDetails[0] : "";
                String memberPan = memberDetails.length > 1 ? memberDetails[1] : "";

                // Insert into PepRelative
                RelativeDTO relativedto = new RelativeDTO();
                relativedto.setPepId(pepCustomer.getId());
                relativedto.setRelativeMasterId(relativeMasterId);
                relativedto.setRelativeName(memberName);
                relativedto.setPan(memberPan);
                final Relative relative = Relative.createthrwDTO(relativedto);
                Relative savedRelative = this.relativeRepository.saveAndFlush(relative);
                Integer pepRelativeId = savedRelative.getId();

                String[] memberDetArray = memberDet.split("<#>");
                for (String memberDetData : memberDetArray) {
                    String[] memberDetDetails = memberDetData.split("\\|");
                    String memberDetName = memberDetDetails.length > 0 ? memberDetDetails[0] : "";
                    String memberDetPan = memberDetDetails.length > 1 ? memberDetDetails[1] : "";

                    //Insert into PepRelativeDet
                    RelativeDet pepRelativeDet = new RelativeDet();
                    pepRelativeDet.setPepId(pepCustomer.getId());
                    pepRelativeDet.setRelativeId(pepRelativeId);
                    pepRelativeDet.setName(memberDetName);
                    pepRelativeDet.setPan(memberDetPan);
                    relativeDetRepository.save(pepRelativeDet);
                }
//                // Insert into PepRelativeDetChildren
                if (!memberChildDet.isEmpty()) {
                    String[] memberChildDetArray = memberChildDet.split("<#>");
                    for (String memberChildDetData : memberChildDetArray) {
                        String[] memberChildDetDetails = memberChildDetData.split("\\|");
                        String memberDetName = memberChildDetDetails.length > 0 ? memberChildDetDetails[0] : "";
                        String memberDetPan = memberChildDetDetails.length > 1 ? memberChildDetDetails[1] : "";

                        //Insert into PepRelativeDet
                        ChildrenDet childrenDet = new ChildrenDet();
                        childrenDet.setPepId(pepCustomer.getId());
                        childrenDet.setRelativeDetId(pepRelativeId);
                        childrenDet.setChildrenName(memberDetName);
                        childrenDet.setPan(memberDetPan);
                        childrenDetRepository.save(childrenDet);
                    }
                }
            }

            return "SUCCESS";
        } catch (Exception e) {
            // Handle exceptions appropriately
            e.printStackTrace();
            return "FAILURE";
        }
    }
}
