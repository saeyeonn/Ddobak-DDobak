package org.itm.ddobak.user.notification

import java.time.LocalTime


data class NotificationSettings(
    val enabled: Boolean,
    val days: List<NotificationDays>,
    val time: LocalTime,
) {
}