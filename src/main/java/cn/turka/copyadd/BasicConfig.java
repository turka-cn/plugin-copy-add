package cn.turka.copyadd;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Turka
 * @date 2023/4/21 17:23
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BasicConfig {
    String copyAddContent;

    String divideType;

    String copyMinLength;

    Boolean contentPageOnly;
}
