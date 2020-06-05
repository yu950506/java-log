package cn.yhs.learn.test;

import com.github.houbb.markdown.toc.core.impl.AtxMarkdownToc;
import com.github.houbb.markdown.toc.vo.TocGen;

public class MainTest {
    public static void main(String[] args) {
        String path = "C:\\Users\\1\\IdeaProjects\\java-log\\README.md";
        TocGen tocGen = AtxMarkdownToc.newInstance()
                .genTocFile(path);
        System.out.println(tocGen);
    }
}
