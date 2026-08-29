package com.newsvideomake.editor.data.models

import kotlin.uuid.Uuid

/**
 * Factory for creating predefined template configurations.
 * Includes common news video layouts.
 */
object TemplateFactory {

    /**
     * Creates a standard 2-zone template: top video + bottom video layout (1080x1920).
     */
    fun createTopBottomTemplate(): TemplateModel {
        val topZone = MediaZone(
            zoneId = "zone_top",
            name = "Top Video Zone",
            type = ZoneType.VIDEO,
            x = 0,
            y = 0,
            width = 1080,
            height = 900,
            isTopZone = true,
            cornerRadius = 8,
            borderColor = 0xFF333333.toInt(),
            borderWidth = 2
        )

        val bottomZone = MediaZone(
            zoneId = "zone_bottom",
            name = "Bottom Video Zone",
            type = ZoneType.VIDEO,
            x = 0,
            y = 1020,
            width = 1080,
            height = 900,
            isBottomZone = true,
            cornerRadius = 8,
            borderColor = 0xFF333333.toInt(),
            borderWidth = 2
        )

        val tickerConfig = TickerBarConfig(
            tickerId = "ticker_main",
            y = 920,
            width = 1080,
            height = 100,
            backgroundColor = 0xFF1a1a1a.toInt(),
            textColor = 0xFFFFFFFF.toInt(),
            fontSize = 42f,
            scrollDuration = 8000,
            text = "Breaking News • Latest Updates"
        )

        return TemplateModel(
            templateId = "template_top_bottom_${Uuid.random()}",
            templateName = "Top & Bottom Split",
            width = 1080,
            height = 1920,
            zones = listOf(topZone, bottomZone),
            tickerBar = tickerConfig,
            audioConfig = AudioConfig(
                bgmVolume = 0.4f,
                voiceoverVolume = 1.0f
            )
        )
    }

    /**
     * Creates a single full-screen video template with overlay zones.
     */
    fun createFullScreenTemplate(): TemplateModel {
        val fullZone = MediaZone(
            zoneId = "zone_full",
            name = "Full Screen Video",
            type = ZoneType.VIDEO,
            x = 0,
            y = 0,
            width = 1080,
            height = 1820,
            cornerRadius = 0
        )

        val tickerConfig = TickerBarConfig(
            tickerId = "ticker_bottom",
            y = 1820,
            width = 1080,
            height = 100,
            backgroundColor = 0x99000000.toInt(),
            textColor = 0xFFFFFFFF.toInt(),
            fontSize = 48f
        )

        return TemplateModel(
            templateId = "template_fullscreen_${Uuid.random()}",
            templateName = "Full Screen",
            zones = listOf(fullZone),
            tickerBar = tickerConfig
        )
    }

    /**
     * Creates a 3-zone template: top video + middle ticker + bottom video.
     */
    fun createThreeZoneTemplate(): TemplateModel {
        val topZone = MediaZone(
            zoneId = "zone_top",
            name = "Top Video",
            type = ZoneType.VIDEO,
            x = 0,
            y = 0,
            width = 1080,
            height = 850,
            isTopZone = true
        )

        val bottomZone = MediaZone(
            zoneId = "zone_bottom",
            name = "Bottom Video",
            type = ZoneType.VIDEO,
            x = 0,
            y = 1070,
            width = 1080,
            height = 850,
            isBottomZone = true
        )

        val tickerConfig = TickerBarConfig(
            tickerId = "ticker_middle",
            y = 850,
            width = 1080,
            height = 220,
            backgroundColor = 0xFF000000.toInt(),
            textColor = 0xFFFFFF00.toInt(),
            fontSize = 50f,
            scrollDuration = 10000
        )

        return TemplateModel(
            templateId = "template_three_zone_${Uuid.random()}",
            templateName = "Three Zone Layout",
            zones = listOf(topZone, bottomZone),
            tickerBar = tickerConfig
        )
    }

    /**
     * Creates a picture-in-picture template: main video + small overlay video.
     */
    fun createPipTemplate(): TemplateModel {
        val mainZone = MediaZone(
            zoneId = "zone_main",
            name = "Main Video",
            type = ZoneType.VIDEO,
            x = 0,
            y = 0,
            width = 1080,
            height = 1920,
            cornerRadius = 0
        )

        val pipZone = MediaZone(
            zoneId = "zone_pip",
            name = "Picture in Picture",
            type = ZoneType.VIDEO,
            x = 700,
            y = 1500,
            width = 350,
            height = 350,
            cornerRadius = 16,
            borderColor = 0xFFFFFFFF.toInt(),
            borderWidth = 3
        )

        val tickerConfig = TickerBarConfig(
            y = 1700,
            width = 650,
            height = 150,
            backgroundColor = 0xCC000000.toInt(),
            textColor = 0xFFFFFFFF.toInt()
        )

        return TemplateModel(
            templateId = "template_pip_${Uuid.random()}",
            templateName = "Picture in Picture",
            zones = listOf(mainZone, pipZone),
            tickerBar = tickerConfig
        )
    }

    /**
     * Get all available predefined templates.
     */
    fun getAllTemplates(): List<TemplateModel> {
        return listOf(
            createTopBottomTemplate(),
            createFullScreenTemplate(),
            createThreeZoneTemplate(),
            createPipTemplate()
        )
    }
}
