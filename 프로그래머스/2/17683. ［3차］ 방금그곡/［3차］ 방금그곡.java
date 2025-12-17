class Solution {
    public String solution(String m, String[] musicinfos) {
        m = convert(m);
        
        int maxPlayTime = -1;
        String res = "";
        
        for(String musicinfo : musicinfos) {
            String[] split = musicinfo.split(",");
            String start = split[0];
            String end = split[1];
            String title = split[2];
            String pattern = split[3];
            
            int gap = calGap(start, end);
            
            String newPattern = convert(pattern);
            StringBuilder sb = new StringBuilder();
            
            for(int i=0; i<(gap/newPattern.length()); i++) {
                sb.append(newPattern);
            }
            sb.append(newPattern.substring(0, gap%newPattern.length()));
            
            if(sb.toString().contains(m)) {
                if(maxPlayTime < gap) {
                    maxPlayTime = gap;
                    res = title;
                }
            }
        }
        if(res.length() == 0) return "(None)";
        else return res;
    }
    
    private String convert(String m) {
        m = m.replace("C#", "c");
        m = m.replace("D#", "d");
        m = m.replace("F#", "f");
        m = m.replace("G#", "g");
        m = m.replace("A#", "a");
        m = m.replace("B#", "b");
        return m;
    }
    
    private int calGap(String start, String end) {
        String[] s_split = start.split(":");
        String[] e_split = end.split(":");
        int s_time = Integer.parseInt(s_split[0]) * 60 + Integer.parseInt(s_split[1]);
        int e_time = Integer.parseInt(e_split[0]) * 60 + Integer.parseInt(e_split[1]);
        return e_time - s_time;
    }
}