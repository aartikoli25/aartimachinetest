package com.exam.application.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Image {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("title")
    @Expose
    var title: Any? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("datetime")
    @Expose
    var datetime: Long? = null

    @SerializedName("type")
    @Expose
    var type: String? = null

    @SerializedName("animated")
    @Expose
    var animated: Boolean? = null

    @SerializedName("width")
    @Expose
    var width: Long? = null

    @SerializedName("height")
    @Expose
    var height: Long? = null

    @SerializedName("size")
    @Expose
    var size : Long? = null

    @SerializedName("views")
    @Expose
    var views: Long? = null

    @SerializedName("bandwidth")
    @Expose
    var bandwidth: Long? = null

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

    @SerializedName("account_url")
    @Expose
    var accountUrl: String? = null

    @SerializedName("account_id")
    @Expose
    var accountId: Long? = null

    @SerializedName("is_ad")
    @Expose
    var isAd : Boolean? = null

    @SerializedName("in_most_viral")
    @Expose
    var inMostViral: Boolean? = null

    @SerializedName("has_sound")
    @Expose
    var hasSound: Boolean? = null

    @SerializedName("tags")
    @Expose
    var tags: List<Tag>? = null

    @SerializedName("ad_type")
    @Expose
    var adType: Long? = null

    @SerializedName("ad_url")
    @Expose
    var adUrl: String? = null

    @SerializedName("edited")
    @Expose
    var edited: String? = null

    @SerializedName("in_gallery")
    @Expose
    var inGallery: Boolean? = null

    @SerializedName("link")
    @Expose
    var link: String? = null

    @SerializedName("comment_count")
    @Expose
    var commentCount: Any? = null

    @SerializedName("favorite_count")
    @Expose
    var favoriteCount: Any? = null

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
}