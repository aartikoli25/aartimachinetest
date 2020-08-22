package com.exam.application.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Datum {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("datetime")
    @Expose
    var datetime: Long? = null

    @SerializedName("cover")
    @Expose
    var cover: String? = null

    @SerializedName("cover_width")
    @Expose
    var coverWidth: Long? = null

    @SerializedName("cover_height")
    @Expose
    var coverHeight: Long? = null

    @SerializedName("account_url")
    @Expose
    var accountUrl: String? = null

    @SerializedName("account_id")
    @Expose
    var accountId: Long? = null

    @SerializedName("privacy")
    @Expose
    var privacy: String? = null

    @SerializedName("layout")
    @Expose
    var layout: String? = null

    @SerializedName("views")
    @Expose
    var views: Long? = null

    @SerializedName("link")
    @Expose
    var link: String? = null

    @SerializedName("ups")
    @Expose
    var ups: Long? = null

    @SerializedName("downs")
    @Expose
    var downs: Long? = null

    @SerializedName("poLongs")
    @Expose
    var poLongs: Long? = null

    @SerializedName("score")
    @Expose
    var score: Long? = null

    @SerializedName("is_album")
    @Expose
    var isAlbum: Boolean? = null

    @SerializedName("vote")
    @Expose
    var vote: Any? = null

    @SerializedName("favorite")
    @Expose
    var favorite: Boolean? = null

    @SerializedName("nsfw")
    @Expose
    var nsfw: Boolean? = null

    @SerializedName("section")
    @Expose
    var section: String? = null

    @SerializedName("comment_count")
    @Expose
    var commentCount: Long? = null

    @SerializedName("favorite_count")
    @Expose
    var favoriteCount: Long? = null

    @SerializedName("topic")
    @Expose
    var topic: String? = null

    @SerializedName("topic_id")
    @Expose
    var topicId: Long? = null

    @SerializedName("images_count")
    @Expose
    var imagesCount : Long? = null

    @SerializedName("in_gallery")
    @Expose
    var inGallery: Boolean? = null

    @SerializedName("is_ad")
    @Expose
    var isAd: Boolean? = null

    @SerializedName("tags")
    @Expose
    var tags: List<Tag>? = null

    @SerializedName("ad_type")
    @Expose
    var adType : Long? = null

    @SerializedName("ad_url")
    @Expose
    var adUrl: String? = null

    @SerializedName("in_most_viral")
    @Expose
    var inMostViral: Boolean? = null

    @SerializedName("include_album_ads")
    @Expose
    var includeAlbumAds: Boolean? = null

    @SerializedName("images")
    @Expose
    var images: List<Image>? = null

    @SerializedName("ad_config")
    @Expose
    var adConfig: AdConfig? = null
}