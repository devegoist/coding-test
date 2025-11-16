import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 1. 장르별 노래 재생수 합을 구한다. -> Map<String, Integer>
        Map<String, Integer> genreTotal = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            genreTotal.put(genres[i], genreTotal.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        // 1-2. 장르별 재생수 기준 내림차순 리스트를 구한다.
        List<String> sortedGenreList = new ArrayList<>(genreTotal.keySet());
        sortedGenreList.sort((a, b) -> genreTotal.get(b) - genreTotal.get(a));
        
        // 2. 장르별 노래와 재생수 리스트를 구한다. -> Map<String, List<int[]>> (여기서 정렬까지 한다.)
        Map<String, List<int[]>> songByGenre = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            int[] song = new int[2];
            song[0] = i;
            song[1] = plays[i];
            if (songByGenre.containsKey(genres[i])) {
                songByGenre.get(genres[i])
                    .add(song);
            } else {
                List<int[]> songs = new ArrayList<>();
                songs.add(song);
                songByGenre.put(genres[i], songs);
            }
        }
        
        songByGenre.forEach((genre, songs) -> {
            songs.sort((a, b) -> {
                if (a[1] == b[1]) {
                    return a[0] - b[0];
                }
                return b[1] - a[1];
            });
        });
        
        // 2-2. 1-2의 sortedGenreList 를 기준으로 2의 Map의 List에서 두곡을 가져온다.
        List<Integer> result = new ArrayList<>();
        for (String genre : sortedGenreList) {
            List<int[]> songs = songByGenre.get(genre);
            result.add(songs.get(0)[0]);
            if (songs.size() > 1) {
                result.add(songs.get(1)[0]);
            }
        }
        
        int[] answer = result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        
        return answer;
    }
}