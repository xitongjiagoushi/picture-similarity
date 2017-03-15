package com.brctl.web;

import com.brctl.service.IPictureService;
import com.brctl.vo.PictureVO;
import com.brctl.vo.ResponseStatus;
import com.brctl.vo.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Duan Xiaoxing on 2017-03-07.
 */
@Controller
public class PictureController {

    private static final Logger logger = LoggerFactory.getLogger(PictureController.class);

    @Autowired
    private IPictureService pictureService;

    @RequestMapping(value = "/similarity", method = RequestMethod.POST)
    @ResponseBody
    public HttpEntity<ResponseVO> similarity(@RequestBody PictureVO pictureVO) {
        String analyseOutcome;
        ResponseVO responseVO = new ResponseVO();
        try {
            analyseOutcome = pictureService.analyseSimilarity(pictureVO.getBase64());
            responseVO.setUrl(analyseOutcome);
            responseVO.setStatus(ResponseStatus.OK);
        } catch (Exception ex) {
            responseVO.setStatus(ResponseStatus.ERR);
            logger.error("error, cause: {}", ex.getMessage());
        }
        return new ResponseEntity<>(responseVO, HttpStatus.OK);
    }

}
