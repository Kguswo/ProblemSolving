import java.util.*;

class Solution {
    
    class Genre{
        int sum;
        int[] songs;
        Genre(int sum, int order){
            this.sum = sum; // 장르별 총합
            this.songs = new int[2]; // 장르별 내림차순 2개
            songs[0] = order;
            songs[1] = -1;
        }
        
        
    }
    
    static Set<String> orderedGenre = new LinkedHashSet<>(); // 장르별 고유번호 순서
    static Map<String, Genre> genreMap = new HashMap<>();
    public int[] solution(String[] genres, int[] plays) {
        String g;
        int p;
        
        for(int i=0; i<genres.length; i++){
            g = genres[i];
            p = plays[i];
            orderedGenre.add(g);
            
            if(!genreMap.containsKey(g)) genreMap.put(g, new Genre(p, i));
            else{
                Genre genre = genreMap.get(g);
                genre.sum += p;
                
                updateMax2Songs(genres, plays, genre, i, p);
            }
        }
        
        // 정답순으로 정렬
        List<String> orderedGenreList = new ArrayList<>(orderedGenre);
        orderedGenreList.sort((o1, o2) -> genreMap.get(o2).sum - genreMap.get(o1).sum);
        
        // 정답리스트
        List<Integer> tmp = new ArrayList<>();
        for(String s : orderedGenreList){
            Genre genre = genreMap.get(s);
            tmp.add(genre.songs[0]);
            if(genre.songs[1] != -1) tmp.add(genre.songs[1]);
        }
        
        // 정답리스트를 배열로
        int[] res = new int[tmp.size()];
        for(int i=0; i<tmp.size(); i++){
            res[i] = tmp.get(i);
        }
        return res;
    }
    
    // 두 곡 내림차순 업데이트
    private void updateMax2Songs(String[] genres, int[] plays, Genre G, int i, int p){
        int firstSong = G.songs[0];
        int secondSong = G.songs[1];
        if(p > plays[firstSong] || (p == plays[firstSong] && i < firstSong)){
            G.songs[1] = firstSong;
            G.songs[0] = i;
        }
        else if(secondSong == -1 || plays[secondSong] < p || (plays[secondSong] == p && i < secondSong)) G.songs[1] = i;
    }
}