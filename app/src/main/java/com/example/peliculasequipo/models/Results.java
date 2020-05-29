package com.example.peliculasequipo.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Results implements Parcelable {

    private boolean adult;
    private boolean backdrop_path;
    private int id;
    private String original_language;
    private String original_title;
    private String overview;
    private String poster_path;
    private String release_date;
    private float popularity;
    private String title;

    public Results(boolean adult, boolean backdrop_path, int id, String original_language, String original_title, String overview, String poster_path, String release_date, float popularity, String title) {
        this.adult = adult;
        this.backdrop_path = backdrop_path;
        this.id = id;
        this.original_language = original_language;
        this.original_title = original_title;
        this.overview = overview;
        this.poster_path = poster_path;
        this.release_date = release_date;
        this.popularity = popularity;
        this.title = title;
    }


    protected Results(Parcel in) {
        adult = in.readByte() != 0;
        backdrop_path = in.readByte() != 0;
        id = in.readInt();
        original_language = in.readString();
        original_title = in.readString();
        overview = in.readString();
        poster_path = in.readString();
        release_date = in.readString();
        popularity = in.readFloat();
        title = in.readString();
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public boolean isBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(boolean backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public int getIdSimilar() {
        return id;
    }

    public void setIdSimilar(int id) {
        this.id = id;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static Creator<Results> getCREATOR() {
        return CREATOR;
    }

    public static final Creator<Results> CREATOR = new Creator<Results>() {
        @Override
        public Results createFromParcel(Parcel in) {
            return new Results(in);
        }

        @Override
        public Results[] newArray(int size) {
            return new Results[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (adult ? 1 : 0));
        dest.writeByte((byte) (backdrop_path ? 1 : 0));
        dest.writeInt(id);
        dest.writeString(original_language);
        dest.writeString(original_title);
        dest.writeString(overview);
        dest.writeString(poster_path);
        dest.writeString(release_date);
        dest.writeFloat(popularity);
        dest.writeString(title);
    }
}
