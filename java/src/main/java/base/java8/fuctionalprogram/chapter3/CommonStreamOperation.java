package base.java8.fuctionalprogram.chapter3;

import base.java8.fuctionalprogram.base.Album;
import base.java8.fuctionalprogram.base.Artist;
import base.java8.fuctionalprogram.base.SampleData;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommonStreamOperation {

    /**
     * a. 编写一个求和函数，计算流中所有数之和。例如， int addUp(Stream<Integer>
     * numbers) ；
     * @param numbers
     * @return
     */
    int addUp(Stream<Integer> numbers) {
        return numbers.mapToInt(Integer::intValue).sum();
    }

    public static int addUpAns(Stream<Integer> numbers) {
        return numbers.reduce(0, (acc, x) -> acc + x);
    }

    /**
     * b. 编写一个函数，接受艺术家列表作为参数，返回一个字符串列表，其中包含艺术家的
     * 姓名和国籍；
     * c. 编写一个函数，接受专辑列表作为参数，返回一个由最多包含 3 首歌曲的专辑组成的
     * 列表。
     */
    public String b() {
        return SampleData.threeArtists().map(artist ->
                artist.getName() + ":" + artist.getNationality()
        ).collect(Collectors.joining(",", "[", "]"));
    }

    public List<Album> c() {
        return SampleData.albums.filter(album -> album.getTrackList().size() <= 3).collect(Collectors.toList());
    }
}
