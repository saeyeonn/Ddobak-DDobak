package org.itm.ddobak.user.study

import org.itm.ddobak.admin.DifficultyLevel
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/v1/user/{userId}/study")
class StudyController {
    @PostMapping("/progress")
    fun saveCurrentProgress(@PathVariable userId: Long, @RequestBody progress: UserProgress) : ResponseEntity<Unit> {
        return ResponseEntity.ok().build()
    }

    @GetMapping("/progress")
    fun getCurrentProgress(@PathVariable userId: Long) : ResponseEntity<UserProgress> {
        return ResponseEntity.ok(UserProgress(
            languageId = 1,
            categoryId = 1,
            difficultyLevel = DifficultyLevel.INTERMEDIATE,
            unitId = 5,
            scriptId = 9,
            createdDate = LocalDateTime.now(),
            modifiedDate = LocalDateTime.now()
        ))
    }

    fun getScript() {}

    fun getAnalysis() {}

    fun getFeedback() {}

    fun addWrongScript() {}

    fun deleteWrongScript() {}

    fun addDifficultScript() {}

    fun deleteDifficultScript() {}

    fun addVocabularies() {}
}