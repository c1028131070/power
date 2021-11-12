package base.java8.fuctionalprogram.chapter4;

import base.java8.fuctionalprogram.base.Artist;

import java.util.stream.Stream;

import static java.util.stream.Stream.concat;

public class Question1 {

    /**
     * 1. 在例 4-25 所示的 Performance 接口基础上，添加 getAllMusicians 方法，该方法返回包
     * 含所有艺术家名字的 Stream ，如果对象是乐队，则返回每个乐队成员的名字。例如，如
     * 果 getMusicians 方法返回甲壳虫乐队，则 getAllMusicians 方法返回乐队名和乐队成员，
     * 如约翰 · 列侬、保罗 · 麦卡特尼等。
     * 例 4-25　表示音乐表演的接口
     * 该接口表示艺术家的演出——专辑或演唱会
     *

     public interface Performance {

     public String getName();

     public Stream<Artist> getMusicians();

     }
     */

    public interface Performance {

        public String getName();

        public Stream<Artist> getMusicians();

        default Stream<Artist> getAllMusicians() {
            return getMusicians()
                    .flatMap(artist -> concat(Stream.of(artist), artist.getMembers()));
        }

    }


}
