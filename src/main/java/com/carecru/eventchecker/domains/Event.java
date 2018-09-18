package com.carecru.eventchecker.domains;

import lombok.*;

@Data
@EqualsAndHashCode(of = "name")
@AllArgsConstructor
public class Event {

    private String name;

    private Integer count;

    public void addCount() {
        this.count++;
    }
}
