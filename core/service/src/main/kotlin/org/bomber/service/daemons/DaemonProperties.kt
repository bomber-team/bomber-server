package org.bomber.service.daemons

import java.time.Duration

data class DaemonProperties(
    val delay: Duration,
    val errorDelay: Duration
)