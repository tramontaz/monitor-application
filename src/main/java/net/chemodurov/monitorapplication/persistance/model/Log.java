package net.chemodurov.monitorapplication.persistance.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Log {

    @Id
    private String id;
    private String instance;
    private Date datetime;
    private Integer logLevel;
    private String message;
    private String stacktrace;
}
