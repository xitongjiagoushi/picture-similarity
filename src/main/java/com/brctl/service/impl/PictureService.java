package com.brctl.service.impl;

import com.brctl.service.IPictureService;
import com.brctl.util.SimilarImageSearch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Duan Xiaoxing on 2017-03-07.
 */
@Service
public class PictureService implements IPictureService {

    private static final Logger logger = LoggerFactory.getLogger(PictureService.class);

    // TODO 原始图片的"感知哈希"值需要持久化
    private static List<String> originHashes;

    static {
        // 选取八张不同角度拍摄的照片作为原图
        String[] hashArray = {"7c477f7f747f7777", "0084b48cffbfbf3f", "f0f0f0f0f0f0f070", "7c777f7f7f7f7f34",
                "003f373f7f777f0c", "003f0f0f7f3f3f00", "0303340878000433", "0078787878787800"};
        originHashes = Arrays.asList(hashArray);
    }

    @Override
    public String analyseSimilarity(String base64Image) throws Exception {
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] bytes = decoder.decodeBuffer(base64Image);
        // base64修正
        for(int i = 0; i < bytes.length; i++) {
            if(bytes[i] < 0) {
                bytes[i] += 256;
            }
        }
        InputStream is = new ByteArrayInputStream(bytes);
        String uploadHashCode = SimilarImageSearch.produceFingerPrint(is);
        /* 源图片
        InputStream sourceInputStream = new FileInputStream(new File("C:\\\\Users\\\\Orclover\\\\Desktop\\\\ggggggit\\\\picture-similarity\\\\img\\\\source.jpg"));
        String sourceHashCode = SimilarImageSearch.produceFingerPrint(sourceInputStream);
        logger.info("origin hash: {}", sourceHashCode);
        */
        // 计算汉明距离(hamming distance)
        String analyseOutcome = "http://original.hubpd.com/";
        for(String originHash: originHashes) {
            int difference = SimilarImageSearch.hammingDistance(originHash, uploadHashCode);
            if(difference < 10) {
                return analyseOutcome;
            }
        }
        return "";
    }

}
