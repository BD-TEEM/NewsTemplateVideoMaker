package com.newsvideomake.editor.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Represents a video template with multiple frames/zones.
 * Supports 1080x1920 vertical layout with configurable video/image zones.
 */
@Parcelize
data class TemplateModel(
    val templateId: String,
    val templateName: String,
    val width: Int = 1080,
    val height: Int = 1920,
    val backgroundResId: Int? = null,
    val zones: List<MediaZone> = emptyList(),
    val overlayLayers: List<OverlayLayer> = emptyList(),
    val tickerBar: TickerBarConfig? = null,
    val audioConfig: AudioConfig? = null
) : Parcelable

/**
 * Defines a single media zone (video/image placement area) in the template.
 */
@Parcelize
data class MediaZone(
    val zoneId: String,
    val name: String,
    val type: ZoneType = ZoneType.VIDEO,
    val x: Int = 0,
    val y: Int = 0,
    val width: Int,
    val height: Int,
    val isTopZone: Boolean = false,
    val isBottomZone: Boolean = false,
    val cornerRadius: Int = 0,
    val borderColor: Int? = null,
    val borderWidth: Int = 0
) : Parcelable

/**
 * Type of media zone.
 */
enum class ZoneType {
    VIDEO, IMAGE, TEXT
}

/**
 * Represents an overlay layer (stickers, borders, logos).
 */
@Parcelize
data class OverlayLayer(
    val layerId: String,
    val resourcePath: String, // File path to PNG/image
    val x: Int = 0,
    val y: Int = 0,
    val width: Int,
    val height: Int,
    val opacity: Float = 1.0f,
    val rotation: Float = 0f
) : Parcelable

/**
 * Configuration for scrolling news ticker/headline text.
 */
@Parcelize
data class TickerBarConfig(
    val tickerId: String = "ticker_main",
    val y: Int = 960, // Middle of 1920 height
    val width: Int = 1080,
    val height: Int = 100,
    val backgroundColor: Int = 0xFF000000.toInt(),
    val textColor: Int = 0xFFFFFFFF.toInt(),
    val fontSize: Float = 48f,
    val scrollDuration: Long = 10000, // ms for full scroll
    val text: String = ""
) : Parcelable

/**
 * Audio configuration for background music and voiceover mixing.
 */
@Parcelize
data class AudioConfig(
    val bgmPath: String? = null,
    val bgmVolume: Float = 0.5f, // 0.0 to 1.0
    val voiceoverPath: String? = null,
    val voiceoverVolume: Float = 1.0f,
    val voiceoverStartTime: Long = 0, // ms
    val audioOutputPath: String? = null
) : Parcelable

/**
 * Represents an imported media asset (video/image with position and timing info).
 */
@Parcelize
data class MediaLayer(
    val layerId: String,
    val zoneId: String,
    val mediaPath: String,
    val mediaType: MediaType,
    val startTime: Long = 0, // ms
    val duration: Long = 0, // ms (0 = auto-calculate)
    val cropX: Int = 0,
    val cropY: Int = 0,
    val cropWidth: Int,
    val cropHeight: Int,
    val opacity: Float = 1.0f,
    val scaleType: ScaleType = ScaleType.CROP,
    val rotation: Float = 0f
) : Parcelable

/**
 * Type of media (video, image, or audio).
 */
enum class MediaType {
    VIDEO, IMAGE, AUDIO
}

/**
 * How to scale media to fit zone (crop, fit, fill, etc).
 */
enum class ScaleType {
    CROP,      // Crop to fit (center-based)
    FIT,       // Fit inside without cropping
    FILL,      // Fill zone (may distort)
    CENTER     // Center without scaling
}

/**
 * Project state containing all template and media information.
 */
@Parcelize
data class VideoProjectState(
    val projectId: String,
    val projectName: String,
    val template: TemplateModel,
    val mediaLayers: List<MediaLayer> = emptyList(),
    val overlays: List<OverlayLayer> = emptyList(),
    val tickerText: String = "",
    val audioConfig: AudioConfig? = null,
    val outputPath: String? = null,
    val duration: Long = 15000, // Default 15 seconds
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
) : Parcelable
