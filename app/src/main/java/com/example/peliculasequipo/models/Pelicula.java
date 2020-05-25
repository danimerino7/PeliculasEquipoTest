package com.example.peliculasequipo.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Pelicula implements Parcelable {

    @SerializedName("id")
    private int id;

    @SerializedName("popularity")
    private float popularity;

    @SerializedName("title")
    private String title;

    @SerializedName("vote_average")
    private String vote_average;

    @SerializedName("release_date")
    private String release_date;

    @SerializedName("overview")
    private String overview;

    @SerializedName("poster_path")
    private String poster_path;

    public Pelicula(int id, float popularity, String title, String vote_average, String release_date, String overview, String poster_path) {
        this.id = id;
        this.popularity = popularity;
        this.title = title;
        this.vote_average = vote_average;
        this.release_date = release_date;
        this.overview = overview;
        this.poster_path = poster_path;
    }

    protected Pelicula(Parcel in) {
        id = in.readInt();
        popularity = in.readFloat();
        title = in.readString();
        vote_average = in.readString();
        release_date = in.readString();
        overview = in.readString();
        poster_path = in.readString();
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

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeFloat(popularity);
        dest.writeString(title);
        dest.writeString(vote_average);
        dest.writeString(release_date);
        dest.writeString(overview);
        dest.writeString(poster_path);
    }
}
