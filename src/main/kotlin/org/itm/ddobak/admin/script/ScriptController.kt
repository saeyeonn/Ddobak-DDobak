package org.itm.ddobak.admin.script

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.itm.ddobak.admin.DifficultyLevel
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/v1/admin/scripts")
@Tag(name = "Script Management", description = "Operations related to managing scripts")
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
                waveForm = listOf(0.0f, 0.3f, 0.5f, 0.7f),
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
                audioURL = "https://example.com/audio/drive_through_order.mp3",
                waveForm = listOf(0.0f, 0.3f, 0.5f, 0.7f),
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
                waveForm = listOf(0.0f, 0.3f, 0.5f, 0.7f),
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
    fun createScript(@RequestParam name: String): ResponseEntity<Unit> {
        return ResponseEntity.ok().build()
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
    fun modifyScript(@RequestParam name: String): ResponseEntity<Unit> {
        return ResponseEntity.ok().build()
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

    @Operation(
        summary = "Get script by Open API",
        description = "Get script by Open API",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
            ApiResponse(responseCode = "404", description = "Not Found"),
            ApiResponse(responseCode = "500", description = "Internal Server Error")
        ]
    )
    @PostMapping("/open-ai/create")
    fun getScriptByOpenAPI(@PathVariable scriptId: Long, @RequestBody request: CollectScriptRequest): ResponseEntity<CollectScriptResponse> {
        return ResponseEntity.ok(CollectScriptResponse("Hello, this is a translated script!"))
    }

    @Operation(
        summary = "Get script by Tatoeba API",
        description = "Get script by Tatoeba API",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
            ApiResponse(responseCode = "404", description = "Not Found"),
            ApiResponse(responseCode = "500", description = "Internal Server Error")
        ]
    )
    @PostMapping("/tatoeba/create")
    fun getScriptByTatoebaAPI(@PathVariable scriptId: Long, @RequestBody request: CollectScriptRequest): ResponseEntity<CollectScriptResponse> {
        return ResponseEntity.ok(CollectScriptResponse("Hello, this is a translated script!"))
    }

    @Operation(
        summary = "Get script by Google Translate API",
        description = "Get script by Google Translate API",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
            ApiResponse(responseCode = "404", description = "Not Found"),
            ApiResponse(responseCode = "500", description = "Internal Server Error")
        ]
    )
    @PostMapping("/{scriptId}/translate")
    fun getTranslatedScript(@PathVariable scriptId: Long, @RequestBody request: TranslateRequest): ResponseEntity<TranslateResponse> {
        return ResponseEntity.ok(TranslateResponse("안녕하세요. 번역된 스크립트입니다."))
    }

    @Operation(
        summary = "Get answer audio data for script",
        description = "Get answer audio data for a script",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
            ApiResponse(responseCode = "404", description = "Not Found"),
            ApiResponse(responseCode = "500", description = "Internal Server Error")
        ]
    )
    @PostMapping("/{scriptId}/audio")
    fun getAnswerAudio(@PathVariable scriptId: Long, @RequestParam audioURL: String) : ResponseEntity<String>{
        return ResponseEntity.ok("http://audio.url")
    }

    @Operation(
        summary = "Delete answer audio data for script",
        description = "Delete answer audio data for a script",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
            ApiResponse(responseCode = "404", description = "Not Found"),
            ApiResponse(responseCode = "500", description = "Internal Server Error")
        ]
    )
    @DeleteMapping("/{scriptId}/audio")
    fun deleteAnswerAudio(@PathVariable scriptId: Long) : ResponseEntity<Unit> {
        return ResponseEntity.ok().build()
    }

    @Operation(
        summary = "Get waveform data for script audio",
        description = "Get waveform data for a script audio file",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
            ApiResponse(responseCode = "404", description = "Not Found"),
            ApiResponse(responseCode = "500", description = "Internal Server Error")
        ]
    )
    @PostMapping("/{scriptId}/waveform")
    fun getAnswerAudioWaveForm(
        @PathVariable scriptId: Long, @RequestParam audioURL: String): ResponseEntity<List<Float>> {
        return ResponseEntity.ok(listOf(0.0f, 0.3f, 0.5f, 0.7f))
    }

    @Operation(
        summary = "Delete waveform data of script audio",
        description = "Delete waveform data of a script audio file",
        responses = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "403", description = "Forbidden"),
            ApiResponse(responseCode = "404", description = "Not Found"),
            ApiResponse(responseCode = "500", description = "Internal Server Error")
        ]
    )
    @DeleteMapping("/{scriptId}/waveform")
    fun deleteAnswerAudioWaveForm(
        @PathVariable scriptId: Long, @RequestParam audioURL: String): ResponseEntity<Unit> {
        return ResponseEntity.ok().build()
    }
}