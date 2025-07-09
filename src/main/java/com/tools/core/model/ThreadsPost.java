package com.tools.core.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ThreadsPost {
    private String content;
    private List<String> photos;
    private List<String> videos;
}
