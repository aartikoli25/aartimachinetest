package com.exam.application.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Datum() : Parcelable {
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

    constructor(parcel: Parcel) : this() {
        id = parcel.readString()
        title = parcel.readString()
        description = parcel.readString()
        datetime = parcel.readValue(Long::class.java.classLoader) as? Long
        cover = parcel.readString()
        coverWidth = parcel.readValue(Long::class.java.classLoader) as? Long
        coverHeight = parcel.readValue(Long::class.java.classLoader) as? Long
        accountUrl = parcel.readString()
        accountId = parcel.readValue(Long::class.java.classLoader) as? Long
        privacy = parcel.readString()
        layout = parcel.readString()
        views = parcel.readValue(Long::class.java.classLoader) as? Long
        link = parcel.readString()
        ups = parcel.readValue(Long::class.java.classLoader) as? Long
        downs = parcel.readValue(Long::class.java.classLoader) as? Long
        poLongs = parcel.readValue(Long::class.java.classLoader) as? Long
        score = parcel.readValue(Long::class.java.classLoader) as? Long
        isAlbum = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        favorite = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        nsfw = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        section = parcel.readString()
        commentCount = parcel.readValue(Long::class.java.classLoader) as? Long
        favoriteCount = parcel.readValue(Long::class.java.classLoader) as? Long
        topic = parcel.readString()
        topicId = parcel.readValue(Long::class.java.classLoader) as? Long
        imagesCount = parcel.readValue(Long::class.java.classLoader) as? Long
        inGallery = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        isAd = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        adType = parcel.readValue(Long::class.java.classLoader) as? Long
        adUrl = parcel.readString()
        inMostViral = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        includeAlbumAds = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
    }

    companion object CREATOR : Parcelable.Creator<Datum> {
        override fun createFromParcel(parcel: Parcel): Datum {
            return Datum(parcel)
        }

        override fun newArray(size: Int): Array<Datum?> {
            return arrayOfNulls(size)
        }
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0!!.writeValue(id)
        p0!!.writeValue(title)
        p0!!.writeValue(description)
        p0!!.writeValue(datetime)
        p0!!.writeValue(cover)
        p0!!.writeValue(coverWidth)
        p0!!.writeValue(coverHeight)
        p0!!.writeValue(accountUrl)
        p0!!.writeValue(accountId)
        p0!!.writeValue(privacy)
        p0!!.writeValue(layout)
        p0!!.writeValue(views)
        p0!!.writeValue(link)
        p0!!.writeValue(ups)
        p0!!.writeValue(downs)
        p0!!.writeValue(poLongs)
        p0!!.writeValue(score)
        p0!!.writeValue(isAlbum)
        p0!!.writeValue(favorite)
        p0!!.writeValue(nsfw)
        p0!!.writeValue(section)
        p0!!.writeValue(commentCount)
        p0!!.writeValue(favoriteCount)
        p0!!.writeValue(topicId)
        p0!!.writeValue(imagesCount)
        p0!!.writeValue(inGallery)
        p0!!.writeValue(isAd)
        p0!!.writeValue(adType)
        p0!!.writeValue(adUrl)
        p0!!.writeValue(inMostViral)
        p0!!.writeValue(includeAlbumAds)

    }

    override fun describeContents(): Int {
        return 0
    }
}