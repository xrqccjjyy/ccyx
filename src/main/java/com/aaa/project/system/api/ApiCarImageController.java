package com.aaa.project.system.api;

import com.aaa.common.exception.file.FileNameLengthLimitExceededException;
import com.aaa.framework.config.FileUploadConfig;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.project.system.carimage.domain.Carimage;
import com.aaa.project.system.carimage.service.ICarimageService;
import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static com.aaa.common.utils.file.FileUploadUtils.upload;

@RestController
@RequestMapping("/api/car")
public class ApiCarImageController  {
    @Autowired
    private ICarimageService carimageServiceImpl;
    @Autowired
    private FileUploadConfig config;


    /**
     * 新增或修改车辆信息
     * @param
     * @return 结果
     */
    @RequestMapping(value = "/setCarInfo", method = RequestMethod.POST)
    public AjaxResult setCarInfo(Carimage carimage,@RequestParam(value = "file") MultipartFile file) throws FileUploadBase.FileSizeLimitExceededException, FileNameLengthLimitExceededException, IOException {
        Carimage carimage1 = new Carimage();
        carimage1.setCarinfoid( carimage.getCarinfoid() );
        String url = config.getWashCarImageDir()+upload( config.getUploadWashCarImage(),file,".jpg" );
        carimage1.setImageurl( url );
        carimageServiceImpl.insertCarimage(carimage1);
        return AjaxResult.success(  );
    }




}
