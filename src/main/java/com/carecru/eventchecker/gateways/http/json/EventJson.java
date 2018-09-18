package com.carecru.eventchecker.gateways.http.json;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EventJson {

    private String name;

    private Integer count;
}
