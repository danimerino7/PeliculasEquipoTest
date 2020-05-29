package com.example.peliculasequipo.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Similares implements Parcelable {

    private int page;
    private List<Results> results;
    private int total_pages;
    private int total_results;

    public Similares(int page, List<Results> results, int total_pages, int total_results) {
        this.page = page;
        this.results = results;
        this.total_pages = total_pages;
        this.total_results = total_results;
    }

    protected Similares(Parcel in) {
        page = in.readInt();
        results = in.createTypedArrayList(Results.CREATOR);
        total_pages = in.readInt();
        total_results = in.readInt();
    }

    public static final Creator<Similares> CREATOR = new Creator<Similares>() {
        @Override
        public Similares createFromParcel(Parcel in) {
            return new Similares(in);
        }

        @Override
        public Similares[] newArray(int size) {
            return new Similares[size];
        }
    };

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(page);
        dest.writeTypedList(results);
        dest.writeInt(total_pages);
        dest.writeInt(total_results);
    }
}
