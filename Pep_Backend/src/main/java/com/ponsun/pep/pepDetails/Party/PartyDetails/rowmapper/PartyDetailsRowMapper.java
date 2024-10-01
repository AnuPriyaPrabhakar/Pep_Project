package com.ponsun.pep.pepDetails.Party.PartyDetails.rowmapper;

import com.ponsun.pep.pepDetails.Party.PartyDTO.DTO.PartyDetailsDTO;
import com.ponsun.pep.pepDetails.Party.PartyDetails.data.PartyDetailsData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class PartyDetailsRowMapper implements RowMapper<PartyDetailsDTO> {

    private final String schema;
    public PartyDetailsRowMapper(){ final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM pep_party_details a");
        this.schema = builder.toString();
    }
    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.pepId as pepId, ");
        builder.append("a.partyMasterId as partyMasterId, ");
        builder.append("a.formerAndCurrent as formerAndCurrent, ");
        builder.append("a.positionInTheParty as positionInTheParty, ");
        builder.append("a.partyCandidateId as partyCandidateId, ");
        builder.append("a.uid as uid, ");
        builder.append("a.euid as euid ");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public PartyDetailsDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer pepId = rs.getInt("pepId");
        final Integer partyMasterId = rs.getInt("partyMasterId");
        final String formerAndCurrent = rs.getString("formerAndCurrent");
        final String positionInTheParty = rs.getString("positionInTheParty");
        final Integer partyCandidateId = rs.getInt("partyCandidateId");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new PartyDetailsDTO(pepId ,partyMasterId ,formerAndCurrent ,positionInTheParty,partyCandidateId,uid,euid);
    }
}
