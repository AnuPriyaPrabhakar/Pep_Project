package com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.rowmapper;

import com.ponsun.pep.pepDetails.Party.PartyCanditateDetails.data.PartyCandidateDetailsData;
import com.ponsun.pep.pepDetails.Party.PartyDTO.DTO.PartyCandidateDetailsDTO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class PartyCandidateDetailsRowMapper implements RowMapper<PartyCandidateDetailsDTO> {

    private final String schema;
    public PartyCandidateDetailsRowMapper(){ final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM pep_party_candidate_details pcd");
        this.schema = builder.toString();
    }
    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("pcd.id as id, ");
        builder.append("pcd.pepId as pepId, ");
        builder.append("pcd.otherInformation as otherInformation, ");
        builder.append("pcd.positionInTheGovernment as positionInTheGovernment, ");
        builder.append("pcd.permanentAddress as permanentAddress, ");
        builder.append("pcd.uid as uid, ");
        builder.append("pcd.euid as euid ");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public PartyCandidateDetailsDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final Integer pepId = rs.getInt("pepId");
        final String otherInformation = rs.getString("otherInformation");
        final String positionInTheGovernment = rs.getString("positionInTheGovernment");
        final String died = rs.getString("died");
        final String permanentAddress = rs.getString("permanentAddress");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new PartyCandidateDetailsDTO(id,pepId ,otherInformation,positionInTheGovernment,died,permanentAddress,uid,euid);
    }
}
