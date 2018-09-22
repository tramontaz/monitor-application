package net.chemodurov.monitorapplication.persistance.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
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

    public String toLog() {
        Field[] fields = this.getClass().getDeclaredFields();
        StringBuilder message = new StringBuilder();
        for (Field field : fields) {
            try {
                if (field.get(this) != null) {
                    message.append(field.getName()).append(": ").append(field.get(this)).append(", ");
                }
            } catch (IllegalAccessException e) {
                LoggerFactory.getLogger(this.getClass()).warn(e.getMessage());
            }
        }
        message.setLength(message.length() - 2);
        return String.valueOf(message);
    }
}
