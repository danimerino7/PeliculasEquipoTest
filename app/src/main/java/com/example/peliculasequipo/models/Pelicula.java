package com.example.peliculasequipo.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Pelicula implements Parcelable {

    @SerializedName("id")
    private int id;

    @SerializedName("popularity")
    private int popularity;

    @SerializedName("title")
    private String title;

    @SerializedName("vote_average")
    private String vote_average;

    @SerializedName("release_date")
    private String release_date;

    @SerializedName("overview")
    private String overview;

    protected Pelicula(Parcel in) {
        id = in.readInt();
        popularity = in.readInt();
        title = in.readString();
        vote_average = in.readString();
        release_date = in.readString();
        overview = in.readString();
    }

    public static final Creator<Pelicula> CREATOR = new Creator<Pelicula>() {
        @Override
        public Pelicula createFromParcel(Parcel in) {
            return new Pelicula(in);
        }

        @Override
        public Pelicula[] newArray(int size) {
            return new Pelicula[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(popularity);
        dest.writeString(title);
        dest.writeString(vote_average);
        dest.writeString(release_date);
        dest.writeString(overview);
    }
}
