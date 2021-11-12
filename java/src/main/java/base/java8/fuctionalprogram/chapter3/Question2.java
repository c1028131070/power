package base.java8.fuctionalprogram.chapter3;

import base.java8.fuctionalprogram.base.Artist;
import base.java8.fuctionalprogram.base.SampleData;

import java.util.List;
import java.util.stream.Collectors;

public class Question2 {

    /**
     * 2. 迭代。修改如下代码，将外部迭代转换成内部迭代：
     * int totalMembers = 0;
     * for (Artist artist : artists) {
     * Stream<Artist> members = artist.getMembers();
     * totalMembers += members.count();
     * }
     * @return
     */
    public long totalMembers() {
        return SampleData.threeArtists().flatMap(Artist::getMembers).count();
    }

    // Q3
    public static int countBandMembersInternal(List<Artist> artists) {
        // NB: readers haven't learnt about primitives yet, so can't use the sum() method
        return artists.stream()
                .map(artist -> artist.getMembers().count())
                .reduce(0L, Long::sum)
                .intValue();

        //return (int) artists.stream().flatMap(artist -> artist.getMembers()).count();
    }
}
