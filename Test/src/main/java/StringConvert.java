import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class StringConvert {
    //z字符变换,第6题
    public String convert(String s, int numRows){
        if (numRows==1)return s;
        List<StringBuilder> rows= new ArrayList<>();
        for (int i=0;i<Math.min(numRows,s.length());i++){
            rows.add(new StringBuilder());
        }

        boolean sign=false;
        int curRow=0;
        for (char c:s.toCharArray()){
            rows.get(curRow).append(c);
            if (curRow==0 || curRow==numRows-1){
                sign=!sign;
            }
            curRow+=(sign?1:-1);
        }
        StringBuilder res=new StringBuilder();
        for (StringBuilder ss:rows){
            res.append(ss);
        }
        return res.toString();
    }
}
