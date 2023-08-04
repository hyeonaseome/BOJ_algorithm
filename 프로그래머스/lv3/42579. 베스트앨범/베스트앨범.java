import java.util.*;
class Solution {
    private class Song{
        int idx;
        int plays;
        public Song(int idx, int plays) {
            this.idx = idx;
            this.plays = plays;
        }
    }
    private class GenreSongs {
        int sum = 0;
        PriorityQueue<Song> songs;
        public GenreSongs(int sum) {
            this.sum = sum;
            this.songs = new PriorityQueue(new Comparator<Song>() {
                @Override
                public int compare(Song o1, Song o2) {
                    return o2.plays-o1.plays;
                }
            });
        }
    }
    public int[] solution(String[] genres, int[] plays) {

        Map<String, GenreSongs> genreStream = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            Song newSong = new Song(i, plays[i]);
            if (genreStream.containsKey(genres[i])) {
                GenreSongs gs = genreStream.get(genres[i]);
                gs.sum += newSong.plays;
                gs.songs.add(newSong);
            } else {
                GenreSongs gs = new GenreSongs(newSong.plays);
                gs.songs.add(newSong);
                genreStream.put(genres[i], gs);
            }
        }
        
        List<String> keySet = new ArrayList<>(genreStream.keySet());
        keySet.sort( new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return genreStream.get(o2).sum - genreStream.get(o1).sum;
            }
        });
        
        List<Integer> answerList = new ArrayList<>();

        for (String key : keySet) {

            GenreSongs curGs = genreStream.get(key);
            int len = Math.min(curGs.songs.size(), 2);
            
            for (int i = 0; i < len; i++) {
                answerList.add(curGs.songs.poll().idx);
            }
        }
        
        int[] answer = new int[answerList.size()];
        for (int i = 0 ; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}