public class Solution {
    public String simplifyPath(String path) {
        List<String> paths = Arrays.asList(path.split("/"));
        List<String> result = new ArrayList<String>();
        int level = 0;
        for (String subPath: paths) {
            if (subPath.equals("") || subPath.equals("."))
                continue;
            else if (subPath.equals("..")) {
                if (level > 0)
                    level--;
            }
            else {
                level++;
                if (level > result.size()) {
                    result.add(subPath);
                }
                else {
                    result.set(level - 1, subPath);
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < level; i++) {
            sb.append('/');
            sb.append(result.get(i));
        }
        if (level == 0) {
            sb.append('/');
        }

        return sb.toString();
    }
}