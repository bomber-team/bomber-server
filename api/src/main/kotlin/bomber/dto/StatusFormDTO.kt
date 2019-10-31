package bomber.dto

import com.fasterxml.jackson.annotation.JsonProperty

enum class StatusFormDTO {
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