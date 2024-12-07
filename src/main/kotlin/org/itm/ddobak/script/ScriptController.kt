package org.itm.ddobak.script

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.itm.ddobak.classification.DifficultyLevel
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/v1/admin/scripts")
@Tag(name = "Script Management", description = "Operations related to managing scripts"  )
class ScriptController() {
    @Operation(
        summary = "Get script list",
        description = "Get a list of scripts",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
        ]
    )
    @GetMapping
    fun getScriptList(
        @RequestParam(value = "languageId", required = true) languageId: Long,
        @RequestParam(value = "categoryId", required = true) categoryId: Long,
        @RequestParam(value = "difficultyLevel", required = true) difficultyLevel: DifficultyLevel,
        @RequestParam(value = "unitId", required = true) unitId: Long
    ): ResponseEntity<List<ScriptInfo>> {
        val response = mutableListOf(
            ScriptInfo(
                id = 1,
                title = "Order in restaurant",
                script = "Hi, I'd like to place an order please.\nSure, what would you like to have?\nI'll have the grilled chicken with a side salad.\nWould you like any drinks with that?\nYes, I'll take an iced tea please.\nGreat choice! Your order will be ready in about 15 minutes.",
                translatedScript = "안녕하세요, 주문하고 싶습니다.\n네, 무엇을 드시겠습니까?\n구운 치킨과 사이드 샐러드로 할게요.\n음료는 어떠신가요?\n네, 아이스티 주세요.\n좋은 선택이에요! 주문하신 음식은 15분 정도 소요됩니다.",
                audioURL = "https://example.com/audio/restaurant_order.mp3",
                waveForm = "23,45,67,89,34,56,78,90,45,67,89,23,45,67,89,34,56,78",
                userAverageAccuracy = 90.3,
                userAverageFluency = 80.3,
                createdDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now()
            ),
            ScriptInfo(
                id = 2,
                title = "Coffee Shop Order",
                script = "Hello! What can I get for you today?\nI'd like a large iced latte with almond milk.\nWould you like any sweetener?\nYes, two pumps of vanilla syrup please.\nAnything to eat with your coffee?\nI'll take a blueberry muffin too.\nThat'll be $8.75. Will you be paying with card?",
                translatedScript = "안녕하세요! 무엇을 도와드릴까요?\n아이스 라떼 라지 사이즈로 아몬드 밀크로 부탁드려요.\n시럽 추가하시겠어요?\n네, 바닐라 시럽 두 번 넣어주세요.\n커피와 함께 드실 음식은 필요하신가요?\n블루베리 머핀도 주세요.\n8달러 75센트입니다. 카드로 결제하시겠어요?",
                audioURL = "https://example.com/audio/coffee_order.mp3",
                waveForm = "23,45,67,89,34,56,78,90,45,67,89,23,45,67,89,34,56,78",
                userAverageAccuracy = 60.3,
                userAverageFluency = 50.3,
                createdDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now(),
            ),
            ScriptInfo(
                id = 3,
                title = "Fast Food Drive-Through",
                script = "Welcome to Burger House, may I take your order?\nYes, I'd like a double cheeseburger meal with large fries.\nWhat would you like to drink with that?\nA medium Coca-Cola, please.\nWould you like to add apple pie for dessert? It's on special today.\nNo thanks, just the meal is fine.\nYour total is $12.50. Please drive to the next window.",
                translatedScript = "버거하우스에 오신 것을 환영합니다, 주문하시겠습니까?\n네, 더블 치즈버거 세트에 감자튀김 라지로 주세요.\n음료는 무엇으로 하시겠어요?\n콜라 미디움 사이즈로 주세요.\n디저트로 애플파이 추가하시겠어요? 오늘 특가상품입니다.\n아니요, 세트만 주문할게요.\n총 12달러 50센트입니다. 다음 창으로 이동해주세요.",
                audioURL = "https://example.com/audio/drive_through_order.mp3",
                waveForm = "45,67,89,23,45,67,89,34,56,78,90,23,45,67,89,12",
                userAverageAccuracy = 90.3,
                userAverageFluency = 80.3,
                createdDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now(),
            )
        )
        return ResponseEntity.ok(response)
    }

    @Operation(
        summary = "Create a new script",
        description = "Create a new script with the given name",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "400", description = "Request parameter error"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
        ]
    )
    @PostMapping
    fun createScript(@RequestParam name: String): ResponseEntity<ScriptInfo> {
        return ResponseEntity.ok(
             ScriptInfo(
                id = 3,
                title = "Cafe Drive-Through",
                script = "Welcome to Star cafe, may I take your order?\nYes, I'd like a small vanilla latte.\nYour total is $3.50. Please drive to the next window.",
                translatedScript = "스타카페에 오신 것을 환영합니다, 주문하시겠습니까?\n네, 작은 바닐라 라떼 한 잔 주세요.\n총 3달러 50센트입니다. 다음 창으로 이동해주세요.",
                audioURL = "https://example.com/audio/drive_through_order.mp3",
                waveForm = "45,67,89,23,45,67,89,34,56,78,90,23,45,67,89,12",
                 userAverageAccuracy = 90.3,
                 userAverageFluency = 80.3,
                 createdDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now(),
            )
        )
    }

    @Operation(
        summary = "Update a script",
        description = "Update the script with the given id",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "400", description = "Request parameter error"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
        ]
    )
    @PatchMapping
    fun modifyScript(@RequestParam name: String): ResponseEntity<ScriptInfo> {
        return ResponseEntity.ok(
            ScriptInfo(
                id = 3,
                title = "Cafe Drive Through",
                script = "Welcome to Star cafe, may I take your order?\nYes, I'd like a small vanilla latte.\nYour total is $3.50. Please drive to the next window.",
                translatedScript = "스타 카페에 오신 것을 환영합니다, 주문하시겠습니까?\n네, 작은 바닐라 라떼 한 잔 주세요.\n총 3달러 50센트입니다. 다음 창으로 이동해주세요.",
                audioURL = "https://example.com/audio/drive_through_order.mp3",
                waveForm = "45,67,89,23,45,67,89,34,56,78,90,23,45,67,89,12",
                userAverageAccuracy = 90.3,
                userAverageFluency = 80.3,
                createdDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now(),
            )
        )
    }

    @Operation(
        summary = "Delete a script",
        description = "Delete the script with the given id",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "400", description = "Request parameter error"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
        ]
    )
    @DeleteMapping("/{scriptId}")
    fun deleteScript(@PathVariable scriptId: Long): ResponseEntity<Unit> {
        return ResponseEntity.ok().build()
    }
}