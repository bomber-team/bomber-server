package bomber.dto

import org.codehaus.jackson.annotate.JsonProperty

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