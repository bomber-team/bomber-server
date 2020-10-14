package org.bomber.api.dto.form

import com.fasterxml.jackson.annotation.JsonProperty

enum class StatusFormDto {
    @JsonProperty("new")
    NEW,
    @JsonProperty("ready")
    READY,
    @JsonProperty("in_progress")
    IN_PROGRESS,
    @JsonProperty("error")
    ERROR,
    @JsonProperty("finish")
    FINISH
}