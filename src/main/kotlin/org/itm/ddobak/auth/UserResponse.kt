package org.itm.ddobak.auth

import org.itm.ddobak.user.RecentProgress
import org.itm.ddobak.user.StudySettings

data class UserResponse(
    val id: Long,
    val email: String,
    val name: String,
    val studySettings: StudySettings,
    val recentProgress: RecentProgress,
)
