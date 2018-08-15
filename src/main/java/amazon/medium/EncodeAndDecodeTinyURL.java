package amazon.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 535. Encode and Decode TinyURL
 * Created by admin on 2018/3/27.
 * Note: This is a companion problem to the System Design problem: Design TinyURL.
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and
 * it returns a short URL such as http://tinyurl.com/4e9iAk.
 * <p/>
 * Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode
 * algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be
 * decoded to the original URL.
 * <p/>
 * below is the tiny url solution in java, also this is the similar method in industry. In industry, most of shorten
 * url service is by database, one auto increasing long number as primary key. whenever a long url need to be
 * shorten, append to the database, and return the primary key number. (the database is very easy to distribute to
 * multiple machine like HBase, or even you can use the raw file system to store data and improve performance by
 * shard and replica).
 * Note, it’s meaningless to promise the same long url to be shorten as the same short url. if you do the promise and
 * use something like hash to check existing, the benefit is must less than the cost.
 * Note: if you want the shorted url contains ‘0-9a-zA-Z’ instead of ‘0-9’, then you need to use 62 number system,
 * not 10 number system(decimal) to convert the primary key number. like 123->‘123’ in decimal, 123->‘1Z’ in 62
 * number system (or ‘0001Z’ for align).
 * <p/>
 * 下面是java中的小url解决方案，这也是行业中类似的方法。在行业中，缩短url服务的大部分是通过数据库，一个是自动增加长号作为主键。每当需要缩短长URL时，追加到数据库并返回主键号码。
 * （数据库非常容易分发到像hbase这样的多台机器，或者甚至可以使用原始文件系统存储数据并通过分片和副本提高性能）。
 * <p/>
 * 请注意，承诺将同一个较长的网址缩短为相同的短网址是没有意义的。如果你做了承诺，并使用哈希来检查现有的好处，则好处是必须低于成本。
 * 注意：如果你想短url包含'0-9a-za-z'而不是'0-9'，那么你需要使用62号码系统，而不是10号码系统（十进制）来转换主键号码。像123  - >'123'在十进制中，123  -
 * >'1z'在62数字系统（或'0001z'对齐）。
 */
public class EncodeAndDecodeTinyURL {

    List<String> urls = new ArrayList<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {

        urls.add(longUrl);
        return String.valueOf(urls.size() - 1);


    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {

        int index = Integer.valueOf(shortUrl);
        return (index < urls.size()) ? urls.get(index) : "";
    }


}
