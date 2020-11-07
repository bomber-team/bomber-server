package org.bomber.model.form

import com.fasterxml.jackson.annotation.JsonProperty

enum class TestFormStatus {
    NEW,
    READY,
    IN_PROGRESS,
    ERROR,
    FINISH
}