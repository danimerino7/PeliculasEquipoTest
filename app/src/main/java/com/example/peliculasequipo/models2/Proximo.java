package com.example.peliculasequipo.models2;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Proximo implements Parcelable {


    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("overview")
    private String overview;

    @SerializedName("release_date")
    private String release_date;

    @SerializedName("poster_path")
    private String poster_path;


    public Proximo(int id, String title, String overview,String release_date, String poster_path) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.release_date = release_date;
        this.poster_path = poster_path;
    }

    protected Proximo(Parcel in) {
        id = in.readInt();
        title = in.readString();
        overview = in.readString();
        release_date = in.readString();
        poster_path = in.readString();
    }

    public static final Creator<Proximo> CREATOR = new Creator<Proximo>() {
        @Override
        public Proximo createFromParcel(Parcel in) {
            return new Proximo(in);
        }

        @Override
        public Proximo[] newArray(int size) {
            return new Proximo[size];
        }
    };

    public int getIdEstreno() {
        return id;
    }

    public void setIdEstreno(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() { return release_date; }

    public void setRelease_date(String release_date) { this.release_date = release_date; }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(overview);
        dest.writeString(release_date);
        dest.writeString(poster_path);
    }
}
