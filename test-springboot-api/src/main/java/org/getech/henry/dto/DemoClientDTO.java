package org.getech.henry.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hengji.li@getech.cn
 * @date 2020/2/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DemoClientDTO {

    private String name;
    private Integer age;
}
