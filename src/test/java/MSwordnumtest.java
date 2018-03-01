/**
 * Created by Administrator on 2017/7/18.
 */
public class MSwordnumtest {
    public static void main(String args[]) {
        String context="20170710002918f88abe2dc407a5a75bc4dfcdefd4b1a8c87b90d476b27452";
        int words_count = 0;
        //中文单词
        String cn_words = context.replaceAll("[^(\\u4e00-\\u9fa5，。《》？；’‘：“”【】、）（……￥！·)]", "");
        int cn_words_count = cn_words.length();
        //非中文单词
        String non_cn_words = context.replaceAll("[^(a-zA-Z0-9`\\-=\';.,/~!@#$%^&*()_+|}{\":><?\\[\\])]", " ");
        int non_cn_words_count = 0;
        String[] ss = non_cn_words.split(" ");
        for(String s:ss){
            if(s.trim().length()!=0) non_cn_words_count++;
        }
//中文和非中文单词合计
        words_count = cn_words_count + non_cn_words_count;
        System.out.println(words_count);
    }

}
