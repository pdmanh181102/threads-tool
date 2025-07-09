package com.tools.core.model;

import java.util.List;

import com.tools.core.threads.ThreadsRuntimeConfig;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ThreadsToolConfig {
    private ThreadsAccount account;
    private List<String> trackingUsernames;
    private ThreadsRuntimeConfig threadsRuntimeConfig;
}
