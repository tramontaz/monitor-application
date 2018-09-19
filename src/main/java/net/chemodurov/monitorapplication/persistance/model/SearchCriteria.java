package net.chemodurov.monitorapplication.persistance.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteria {
    private String instance;
    private String partOfMessage;
    private Date startDate;
    private Date endDate;
}
