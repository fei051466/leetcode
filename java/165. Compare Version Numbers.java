public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] version1_split = version1.split("\\.");
        String[] version2_split = version2.split("\\.");
        int version1_part;
        int version2_part;
        for(version1_part=0, version2_part=0; version1_part<version1_split.length&&version2_part<version2_split.length;
            version1_part++, version2_part++){
            if(Integer.valueOf(version1_split[version1_part]) < Integer.valueOf(version2_split[version2_part]))
                return -1;
            else if(Integer.valueOf(version1_split[version1_part]) > Integer.valueOf(version2_split[version2_part]))
                return 1;
        }
        if(version1_part == version1_split.length && version2_part == version2_split.length)
            return 0;
        else if(version1_part < version1_split.length){
            while(version1_part < version1_split.length){
                if(Integer.valueOf(version1_split[version1_part]) != 0)
                    return 1;
                version1_part++;
            }
            return 0;
        }
        else{
            while(version2_part < version2_split.length){
                if(Integer.valueOf(version2_split[version2_part]) != 0)
                    return -1;
                version2_part++;
            }
            return 0;
        }
    }
}