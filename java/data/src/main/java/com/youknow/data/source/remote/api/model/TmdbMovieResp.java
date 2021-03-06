package com.youknow.data.source.remote.api.model;

import com.google.gson.annotations.SerializedName;
import com.youknow.domain.model.Movie;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class TmdbMovieResp {
    private boolean adult;
    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("belongs_to_collection")
    private MovieCollection belongsToCollection;
    private int budget;
    private List<Genre> genres;
    private String homepage;
    private int id;
    @SerializedName("imdb_id")
    private String imdbId;
    @SerializedName("original_language")
    private String originalLanguage;
    @SerializedName("original_title")
    private String originalTitle;
    private String overview;
    private float popularity;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("production_companies")
    private List<ProductionCompany> productionCompanies;
    @SerializedName("production_countries")
    private List<ProductionCountry> productionCountries;
    @SerializedName("release_date")
    private String releaseDate;
    private long revenue;
    private int runtime;
    @SerializedName("spoken_languages")
    private List<SpokenLanguage> spokenLanguages;
    private String status;
    private String tagline;
    private String title;
    private boolean video;
    @SerializedName("vote_average")
    private float voteAverage;
    @SerializedName("vote_count")
    private int voteCount;

    public static Movie mapToDomain(TmdbMovieResp movieResp) {
        List<String> genreList = new ArrayList<>();
        for (Genre genre : movieResp.genres) {
            genreList.add(genre.getName());
        }

        return new Movie(
                movieResp.adult,
                genreList,
                movieResp.homepage,
                movieResp.id,
                movieResp.overview,
                movieResp.popularity,
                movieResp.posterPath,
                movieResp.releaseDate,
                movieResp.runtime,
                movieResp.status,
                movieResp.tagline,
                movieResp.title,
                movieResp.voteAverage,
                movieResp.voteCount
        );
    }
}

@Data
class MovieCollection {
    private int id;
    private String name;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("backdrop_path")
    private String backdropPath;
}

@Data
class Genre {
    private int id;
    private String name;
}

@Data
class ProductionCompany {
    private String name;
    private int id;
    @SerializedName("logo_path")
    private String logoPath;
    @SerializedName("origin_country")
    private String originCountry;
}

@Data
class ProductionCountry {
    private String iso_3166_1;
    private String name;
}

@Data
class SpokenLanguage {
    private String iso_639_1;
    private String name;
}
