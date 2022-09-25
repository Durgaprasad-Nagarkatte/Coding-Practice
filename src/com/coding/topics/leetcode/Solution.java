//package com.coding.topics.leetcode;
//
//import java.time.Instant;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.*;
//import java.util.stream.Collectors;
//
//class Solution {
//
//    private static final String PATTERN_FORMAT = "yyyy-MM-dd HH:mm:ss";
//
//    public static class Photo {
//        private int orginalIndex
//        private String photoName;
//        private String city;
//        private LocalDateTime date;
//
//        public String getPhotoName() {
//            return photoName;
//        }
//
//        public String getCity() {
//            return city;
//        }
//
//        public LocalDateTime getDate() {
//            return date;
//        }
//
//        public void setPhotoName(String photoName) {
//            this.photoName = photoName;
//        }
//
//        public String rename(int i, int max) {
//            String[] photoName = this.photoName.split("\\.");
//
//            int iSize = Integer.toString(i).length();
//            int maxSize = Integer.toString(i, max).length();
//
//            int trailingZeros = maxSize - iSize;
//            String zero = "0";
//            return this.city + zero.repeat(trailingZeros)+i+"."+photoName[1].trim();
//        }
//
//        public Photo(String s, int i) {
//            String[] details = s.split(",");
//            this.orginalIndex = i;
//            this.photoName = details[0].trim();
//            this.city = details[1].trim();
//            this.date = LocalDateTime.parse(
//                            details[2].trim(),
//                            DateTimeFormatter.ofPattern(PATTERN_FORMAT));
//        }
//
//
//        @Override
//        public String toString() {
//            return "Photo{" +
//                    "photoName='" + photoName + '\'' +
//                    ", city='" + city + '\'' +
//                    ", date=" + date +
//                    '}';
//        }
//    }
//
//    public String solution(String S) {
//        // write your code in Java SE 8
//        String[] files  = S.split("\n");
//
//        List<Photo> photos = new ArrayList<>();
//        for(int i = 0; i < files.length; i++) {
//            photos.add(new Photo(files[0], i));
//        }
//
//        Map<String, List<Photo>> cityToPhotos = photos.stream().collect(Collectors.groupingBy(Photo::getCity));
//
//        for(String city : cityToPhotos.keySet()) {
//            List<Photo> cityPhotos = cityToPhotos.get(city);
//            cityToPhotos.put(city, cityPhotos.stream().sorted((a, b) -> {
//                int i = a.getDate().isBefore(b.getDate()) ? -1 : 1;
//                return i;
//            }).collect(Collectors.toList()));
//        }
//
//        StringBuilder sb = new StringBuilder();
//
//        for(String city : cityToPhotos.keySet()) {
//            int noOfPhotos = cityToPhotos.get(city).size();
//
//            List<Photo> photosByCity = cityToPhotos.get(city);
//
//            for(int i = 0; i < photosByCity.size(); i++){
//                String newName = photosByCity.get(i).rename(i, noOfPhotos);
//                photosByCity.get(i).setPhotoName(newName);
//                sb.append(newName).append("\n");
//            }
//        }
//
//
//        return sb.toString();
//    }
//
//    public static void main(String[] args){
//        Solution solution = new Solution();
//        solution.solution("photo.jpg, Warsaw, 2013-09-05 14:08:15");
//    }
//}
