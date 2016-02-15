package com.doctor.jackson;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

/**
 * @author sdcuike
 *
 * @time 2016年2月15日 下午5:02:46
 * 
 * @see https://github.com/FasterXML/jackson-databind
 *      http://www.studytrails.com/java/json/java-jackson-introduction.jsp
 */
public class Practice01 {

    public static void main(String[] args) throws ParseException, JsonGenerationException, JsonMappingException, IOException {
        Album album = new Album("Kind Of Blue");
        album.setLinks(new String[] { "link1", "link2" });
        List<String> songs = new ArrayList<>();
        songs.add("So What");
        songs.add("Flamenco Sketches");
        songs.add("Freddie Freeloader");
        album.setSongs(songs);
        Artist artist = new Artist();
        artist.name = "Miles Davis";
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        artist.birthDate = format.parse("26-05-1926");
        album.setArtist(artist);
        album.addMusician("Miles Davis", "Trumpet, Band leader");
        album.addMusician("Julian Adderley", "Alto Saxophone");
        album.addMusician("Paul Chambers", "double bass");

        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(album);
        System.out.println(json);
        Album album2 = objectMapper.readValue(json, Album.class);
        System.out.println("=====");
        System.out.println(album2);
        System.out.flush();

        //
    }

    public static class Album {
        private String title;
        private String[] links;
        private List<String> songs = new ArrayList<>();
        private Artist artist;

        private Map<String, String> musicians = new HashMap<>();

        public Album() {

        }

        public Album(String title) {
            this.title = title;
        }

        public void addMusician(String key, String value) {
            musicians.put(key, value);
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String[] getLinks() {
            return links;
        }

        public void setLinks(String[] links) {
            this.links = links;
        }

        public List<String> getSongs() {
            return songs;
        }

        public void setSongs(List<String> songs) {
            this.songs = songs;
        }

        public Artist getArtist() {
            return artist;
        }

        public void setArtist(Artist artist) {
            this.artist = artist;
        }

        public Map<String, String> getMusicians() {
            return Collections.unmodifiableMap(musicians);
        }

        public void setMusicians(Map<String, String> musicians) {
            this.musicians = musicians;
        }

        @Override
        public String toString() {
            return new Gson().toJson(this);
        }
    }

    public static class Artist {
        public String name;
        public Date birthDate;
        public int age;
        public String homeTown;
        public List<String> awardsWon = new ArrayList<>();

        @Override
        public String toString() {
            return new Gson().toJson(this);
        }
    }
}
